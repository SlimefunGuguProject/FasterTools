package me.smourad.fastertools.mining;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.smourad.fastertools.event.PlayerMiningBlockEvent;
import me.smourad.fastertools.item.FasterTool;
import me.smourad.fastertools.item.FasterToolUseHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class MiningListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onMining(PlayerMiningBlockEvent event) {
        double vanillaToolSpeedMultiplier = MinerUtils.getSpeedMultiplier(event.getTool().getType(), event.getBlock().getType());
        event.setBestTool(vanillaToolSpeedMultiplier > 1.0);
        event.setToolSpeedEfficiency(vanillaToolSpeedMultiplier);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onSlimeFunMining(PlayerMiningBlockEvent event) {
        if (!event.isBestTool()) return;

        if (SlimefunItem.getByItem(event.getTool()) instanceof FasterTool tool) {
            if (tool.canUse(event.getPlayer(), true)) {
                tool.callItemHandler(FasterToolUseHandler.class, handler -> handler.onToolUse(event));
            }
        }
    }

}
