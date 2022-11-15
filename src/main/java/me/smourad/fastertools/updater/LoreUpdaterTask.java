package me.smourad.fastertools.updater;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.smourad.fastertools.item.FasterTool;
import me.smourad.fastertools.lore.FasterLore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LoreUpdaterTask implements Runnable {

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (!player.isValid() || player.isDead()) {
                continue;
            }

            updateFasterToolLore(player, player.getInventory());
        }
    }

    private void updateFasterToolLore(Player player, Inventory inventory) {
        for (ItemStack item : inventory.getContents()) {
            SlimefunItem slimefunItem = SlimefunItem.getByItem(item);

            if (slimefunItem instanceof FasterTool tool) {
                ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
                assert meta != null;
                FasterLore.update(meta, tool.getEfficiencyMultiplier(player, item));
                item.setItemMeta(meta);
            }
        }
    }
}