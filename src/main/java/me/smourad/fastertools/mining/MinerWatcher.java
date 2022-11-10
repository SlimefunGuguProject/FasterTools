package me.smourad.fastertools.mining;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.EnumWrappers;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.smourad.fastertools.FasterToolsAddon;
import me.smourad.fastertools.event.PlayerMiningBlockEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockDestructionPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ServerGamePacketListener;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class MinerWatcher implements Listener {

    protected final static Map<Player, Long> lastSwing = new ConcurrentHashMap<>();

    static {
        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(
                FasterToolsAddon.INSTANCE, ListenerPriority.NORMAL, PacketType.Play.Client.ARM_ANIMATION) {
            @Override
            public void onPacketReceiving(PacketEvent event) {
                lastSwing.put(event.getPlayer(), System.currentTimeMillis());
            }
        });

        new BukkitRunnable() {
            @Override
            public void run() {
                long currentTime = System.currentTimeMillis();
                lastSwing.forEach((player, time) -> {
                    if (time + 150 < currentTime) lastSwing.remove(player);
                });
            }
        }.runTaskTimer(FasterToolsAddon.INSTANCE, 1L, 1L);
    }

    private final Map<Player, BukkitTask> tasks = new HashMap<>();
    private final Map<Player, Block> blocks = new HashMap<>();
    private final Random random;

    public MinerWatcher() {
        this.random = new Random();
        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(FasterToolsAddon.INSTANCE,
                ListenerPriority.NORMAL, PacketType.Play.Client.BLOCK_DIG) {
            @Override
            public void onPacketReceiving(PacketEvent event) {
                Player player = event.getPlayer();
                PacketType type = event.getPacketType();
                PacketContainer packet = event.getPacket();

                if (type.equals(PacketType.Play.Client.BLOCK_DIG)) {
                    EnumWrappers.PlayerDigType status = packet.getPlayerDigTypes().read(0);
                    BlockPosition bp = packet.getBlockPositionModifier().read(0);
                    Block block = player.getWorld().getBlockAt(bp.getX(), bp.getY(), bp.getZ());

                    if (status.equals(EnumWrappers.PlayerDigType.START_DESTROY_BLOCK)) {
                        if (tasks.containsKey(player)) {
                            tasks.remove(player).cancel();
                            sendCrackAnimation(player, blocks.remove(player), -1);
                        }

                        if (block.getType().getHardness() > 0) {
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    startBlockBreaking(player, block);
                                }
                            }.runTask(FasterToolsAddon.INSTANCE);
                        }
                    }
                }
            }
        });
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        addMiningFatigue(player);
    }

    @EventHandler
    public void onMiningFatigueApply(EntityPotionEffectEvent event) {
        if ((event.getNewEffect() != null && event.getNewEffect().getType().equals(PotionEffectType.SLOW_DIGGING)) ||
                (event.getOldEffect() != null && event.getOldEffect().getType().equals(PotionEffectType.SLOW_DIGGING))) {
            if (event.getEntity() instanceof Player player) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        addMiningFatigue(player);
                    }
                }.runTask(FasterToolsAddon.INSTANCE);
            }
        }
    }

    @EventHandler
    public void onSpawn(EntitySpawnEvent event) {
        if (event.getEntity() instanceof Player player) addMiningFatigue(player);
    }

    private void addMiningFatigue(Player player) {
        ServerGamePacketListener connection = ((CraftPlayer) player).getHandle().connection;

        Packet<ClientGamePacketListener> entityEffect = new ClientboundUpdateMobEffectPacket(player.getEntityId(),
                new MobEffectInstance(MobEffects.DIG_SLOWDOWN, Integer.MAX_VALUE, 255, true, false));
        connection.getConnection().send(entityEffect);
    }

    private int getBreakingTicksSpeed(Player player, Block block) {
        Material material = block.getType();
        ItemStack tool = player.getInventory().getItemInMainHand();

        PlayerMiningBlockEvent event = new PlayerMiningBlockEvent(player, block, tool);
        Bukkit.getPluginManager().callEvent(event);

        double speedMultiplier = event.getToolSpeedEfficiency();

        if (!block.getDrops(tool).isEmpty() && speedMultiplier > 1.0) {
            speedMultiplier += Math.pow(tool.getEnchantmentLevel(Enchantment.DIG_SPEED), 2) + 1;
        }

        if (player.hasPotionEffect(PotionEffectType.FAST_DIGGING)) {
            PotionEffect haste = player.getPotionEffect(PotionEffectType.FAST_DIGGING);
            assert haste != null;
            speedMultiplier *= 0.2 * haste.getAmplifier() + 1;
        }

        if (player.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
            PotionEffect fatigue = player.getPotionEffect(PotionEffectType.SLOW_DIGGING);
            assert fatigue != null;
            speedMultiplier *= Math.pow(0.3, Math.min(fatigue.getAmplifier(), 4));
        }

        if (player.isInWater()) {
            ItemStack helmet = player.getInventory().getHelmet();
            if (helmet != null && !helmet.getEnchantments().containsKey(Enchantment.WATER_WORKER)) {
                speedMultiplier /= 5;
            }
        }

        if (!player.isOnGround()) {
            speedMultiplier /= 5;
        }

        double damage = speedMultiplier / material.getHardness();
        damage /= !block.getDrops(tool).isEmpty() ? 30 : 100;

        if (damage > 1) {
            return 0;
        }

        return (int) Math.ceil(1 / damage);
    }

    private void breakBlock(Player player, Block block, ItemStack tool) {
        Material type = block.getType();
        BlockData blockData = type.createBlockData();
        SoundGroup soundGroup = blockData.getSoundGroup();
        World world = block.getWorld();

        BlockBreakEvent event = new BlockBreakEvent(block, player);
        event.setExpToDrop(MinerUtils.getExpToDrop(type));
        Bukkit.getPluginManager().callEvent(event);

        if (event.isCancelled()) return;

        block.breakNaturally(tool);

        world.playSound(block.getLocation(), soundGroup.getBreakSound(), soundGroup.getVolume(), soundGroup.getPitch());
        world.spawnParticle(Particle.BLOCK_CRACK, block.getLocation().add(0.5, 0.5, 0.5),
                10, 0.3, 0.3, 0.3, blockData);

        if (event.getExpToDrop() > 0) {
            ExperienceOrb orb = world.spawn(block.getLocation(), ExperienceOrb.class);
            orb.setExperience(event.getExpToDrop());
        }

        // They already lose durability on block break event
        if (SlimefunItem.getByItem(tool) == null) {
            if (random.nextInt(100) < 100. / (tool.getEnchantmentLevel(Enchantment.DURABILITY) + 1.))
                useDurability(tool, player);
        }
    }

    private void useDurability(ItemStack tool, Player player) {
        if (tool.getItemMeta() instanceof Damageable damageable) {
            damageable.setDamage(damageable.getDamage() + 1);

            if (damageable.getDamage() >= tool.getType().getMaxDurability()) {
                player.getInventory().setItemInMainHand(null);

                tool.setAmount(0);
                Bukkit.getPluginManager().callEvent(new PlayerItemBreakEvent(player, tool));

                Location playerLocation = player.getLocation();
                World world = playerLocation.getWorld();
                assert world != null;
                world.spawnParticle(
                        Particle.ITEM_CRACK,
                        playerLocation,
                        10,
                        0.3, 0.5, 0.3,
                        tool
                );
                player.playSound(
                        player.getLocation(),
                        Sound.ENTITY_ITEM_BREAK,
                        1F, 1F
                );
            } else {
                tool.setItemMeta(damageable);
            }
        }
    }

    private void startBlockBreaking(Player player, Block block) {
        ItemStack tool = player.getInventory().getItemInMainHand();
        int ticks = getBreakingTicksSpeed(player, block);

        blocks.put(player, block);

        if (ticks < 1) {
            sendCrackAnimation(player, block, -1);
            breakBlock(player, block, tool);
            return;
        }

        tasks.put(player, new BukkitRunnable() {
            private int mining = 0;

            @Override
            public void run() {
                if (!lastSwing.containsKey(player)) {
                    sendCrackAnimation(player, block, -1);
                    blocks.remove(player);
                    tasks.remove(player);
                    cancel();
                } else {
                    int ticks = getBreakingTicksSpeed(player, block);
                    if (mining > ticks) {
                        blocks.remove(player);
                        tasks.remove(player);
                        sendCrackAnimation(player, block, -1);
                        breakBlock(player, block, tool);
                        cancel();
                    } else {
                        sendCrackAnimation(player, block, (int) (mining / (ticks * 0.1)));
                        mining++;
                    }
                }
            }
        }.runTaskTimer(FasterToolsAddon.INSTANCE, 0L, 1L));
    }

    private void sendCrackAnimation(Player player, Block block, int state) {
        Location location = block.getLocation();
        Packet<ClientGamePacketListener> entityEffect = new ClientboundBlockDestructionPacket(
                (player.getEntityId() + 1) * 1000,
                new BlockPos(location.getBlockX(), location.getBlockY(), location.getBlockZ()),
                state
        );

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            ServerGamePacketListener connection = ((CraftPlayer) onlinePlayer).getHandle().connection;
            connection.getConnection().send(entityEffect);
        }
    }

}
