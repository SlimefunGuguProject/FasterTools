package me.smourad.fastertools.item;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public abstract class FasterTool extends SlimefunItem implements NotPlaceable {

    protected FasterTool(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        addItemHandler(getFasterToolUseHandler());
    }

    @Nonnull
    public FasterToolUseHandler getFasterToolUseHandler() {
        return event -> {
            if (event.isBestTool()) {
                double speedEfficiency = event.getToolSpeedEfficiency();
                event.setToolSpeedEfficiency(speedEfficiency * getEfficiencyMultiplier(event.getPlayer(), event.getTool()));
            }
        };
    }

    public abstract double getEfficiencyMultiplier(Player player, ItemStack tool);

}
