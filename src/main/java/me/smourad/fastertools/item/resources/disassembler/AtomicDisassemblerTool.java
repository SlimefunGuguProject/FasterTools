package me.smourad.fastertools.item.resources.disassembler;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemSetting;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.ToolUseHandler;
import me.smourad.fastertools.event.PlayerMiningBlockEvent;
import me.smourad.fastertools.item.FasterTool;
import me.smourad.fastertools.item.FasterToolUseHandler;
import me.smourad.fastertools.mining.MinerUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.*;

public class AtomicDisassemblerTool extends FasterTool implements Rechargeable {

    private final Map<UUID, Integer> selectedMode = new HashMap<>();
    private final List<ItemSetting<Double>> efficiencyRatios = new ArrayList<>();
    private final float COST = 0.3f;

    public AtomicDisassemblerTool(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        AtomicDisassemblerMode[] modes = AtomicDisassemblerMode.getMiningMode();
        for (int i = 0; i < modes.length; i++) {
            ItemSetting<Double> efficiencyRatio = new ItemSetting<>(this, modes
                    [i].name().toLowerCase(Locale.ROOT) + "-efficiency-ratio", 2 * Math.pow(5, i));

            efficiencyRatios.add(efficiencyRatio);
            addItemSetting(efficiencyRatio);
        }
    }

    @Override
    public void preRegister() {
        super.preRegister();
        addItemHandler(getToolUseHandler());
        addItemHandler(getItemUseHandler());
    }

    @Override
    public float getMaxItemCharge(ItemStack itemStack) {
        return 400.f;
    }

    @Override
    public double getEfficiencyMultiplier(Player player, ItemStack tool) {
        int index = selectedMode.getOrDefault(player.getUniqueId(), 1);

        if (index + 1 >= AtomicDisassemblerMode.values().length) {
            return Double.MIN_VALUE;
        }

        return efficiencyRatios.get(index).getValue();
    }


    private float getCost(Player player) {
        int index = selectedMode.getOrDefault(player.getUniqueId(), 1);
        return (float) (COST * Math.pow(5, index));
    }

    public ToolUseHandler getToolUseHandler() {
        return (event, tool, fortune, drops) -> {
            Player player = event.getPlayer();
            removeItemCharge(tool, getCost(player));

            if (!event.isDropItems()) return;

            event.setDropItems(false);
            Block block = event.getBlock();

            for (Material material : MinerUtils.getBestTools()) {
                if (!MinerUtils.isBestToolToBreakBlock(material, block.getType())) continue;

                ItemStack fakeTool = new ItemStack(material);

                if (fortune > 0) {
                    ItemMeta meta = fakeTool.hasItemMeta() ?
                            fakeTool.getItemMeta() :
                            Bukkit.getItemFactory().getItemMeta(material);
                    meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, fortune, true);
                    fakeTool.setItemMeta(meta);
                }

                block.breakNaturally(fakeTool);
                return;
            }

            block.breakNaturally(new ItemStack(Material.SHEARS));
        };
    }

    @Nonnull
    protected ItemUseHandler getItemUseHandler() {
        return event -> {
            Player player = event.getPlayer();
            event.cancel();

            int index = selectedMode.getOrDefault(player.getUniqueId(), 1);

            if (player.isSneaking()) {
                index = (index + 1) % AtomicDisassemblerMode.values().length;
                selectedMode.put(player.getUniqueId(), index);
                player.sendMessage(ChatColor.AQUA + "Atomic Disassembler " + ChatColor.GRAY + "mode changed to: "
                        + ChatColor.BLUE + AtomicDisassemblerMode.values()[index].name());
            }
        };
    }

    @Nonnull
    @Override
    public FasterToolUseHandler getFasterToolUseHandler() {
        return event -> {
            Player player = event.getPlayer();
            int index = selectedMode.getOrDefault(player.getUniqueId(), 1);

            if (index + 1 >= AtomicDisassemblerMode.values().length) {
                event.setCancelled(true);
            } else if (getItemCharge(event.getTool()) >= getCost(player)) {
                applyFasterToolEvent(event, true, getEfficiencyMultiplier(event.getPlayer(), event.getTool()));
            } else {
                applyFasterToolEvent(event, false, 1.0);
            }
        };
    }

    private void applyFasterToolEvent(PlayerMiningBlockEvent event, boolean state, double ratio) {
        event.setBestTool(state);
        event.setCanHarvest(state);
        event.setToolSpeedEfficiency(ratio);
    }


}
