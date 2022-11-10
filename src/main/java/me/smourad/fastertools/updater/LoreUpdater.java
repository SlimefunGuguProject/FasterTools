package me.smourad.fastertools.updater;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.smourad.fastertools.item.FasterTool;
import me.smourad.fastertools.lore.FasterLore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LoreUpdater implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        updateMoonlightItems(player, player.getInventory());
    }

    @EventHandler
    public void onPlayerPickup(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player player) {
            updateMoonlightItems(player, player.getInventory());
        }
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        Inventory inventory = event.getInventory();

        if (event.getPlayer() instanceof Player player) {
            updateMoonlightItems(player, inventory);
        }
    }

    private void updateMoonlightItems(Player player, Inventory inventory) {
        for (ItemStack item : inventory.getContents()) {
            SlimefunItem slimefunItem = SlimefunItem.getByItem(item);

            if (slimefunItem instanceof FasterTool tool) {
                ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
                assert meta != null;
                FasterLore.update(meta, tool.getEfficiencyMultiplier(player, item));
            }
        }
    }
}
