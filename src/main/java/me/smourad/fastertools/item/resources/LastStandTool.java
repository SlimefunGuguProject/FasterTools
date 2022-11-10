package me.smourad.fastertools.item.resources;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemSetting;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.smourad.fastertools.item.FasterTool;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

public class LastStandTool extends FasterTool {

    protected final ItemSetting<Double> efficiencyBonusPerLossPercentage
            = new ItemSetting<>(this, "efficiency-bonus-per-loss-percentage", 0.1);

    public LastStandTool(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        addItemSetting(efficiencyBonusPerLossPercentage);
    }

    @Override
    public double getEfficiencyMultiplier(Player player, ItemStack tool) {
        if (tool.getItemMeta() instanceof Damageable damageable) {
            double durabilityPercentageLoss = damageable.getDamage() / (double) tool.getType().getMaxDurability();
            return 1.0 + durabilityPercentageLoss * efficiencyBonusPerLossPercentage.getValue();
        }

        return 1.0;
    }
}
