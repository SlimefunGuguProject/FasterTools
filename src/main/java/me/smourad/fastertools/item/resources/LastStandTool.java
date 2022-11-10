package me.smourad.fastertools.item.resources;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemSetting;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.smourad.fastertools.item.FasterTool;
import me.smourad.fastertools.item.FasterToolUseHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

import javax.annotation.Nonnull;

public class LastStandTool extends FasterTool {

    protected final ItemSetting<Double> efficiencyBonusPerLossPercentage
            = new ItemSetting<>(this, "efficiency-bonus-per-loss-percentage", 0.1);

    public LastStandTool(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        addItemSetting(efficiencyBonusPerLossPercentage);
    }

    @Override
    @Nonnull
    public FasterToolUseHandler getItemHandler() {
        return event -> {
            if (event.isBestTool()) {
                ItemStack tool = event.getTool();
                if (!tool.hasItemMeta()) return;

                if (tool.getItemMeta() instanceof Damageable damageable) {
                    double speedEfficiency = event.getToolSpeedEfficiency();
                    double durabilityPercentageLoss = damageable.getDamage() / (double) tool.getType().getMaxDurability();
                    event.setToolSpeedEfficiency(speedEfficiency * (1 + durabilityPercentageLoss * efficiencyBonusPerLossPercentage.getValue()));
                }
            }
        };
    }
}
