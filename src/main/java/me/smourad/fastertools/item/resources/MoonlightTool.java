package me.smourad.fastertools.item.resources;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemSetting;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.smourad.fastertools.item.FasterTool;
import me.smourad.fastertools.item.FasterToolUseHandler;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class MoonlightTool extends FasterTool {

    protected final ItemSetting<Double> dayEfficiencyRatio = new ItemSetting<>(this, "day-efficiency-ratio", 0.8);
    protected final ItemSetting<Double> nightEfficiencyRatio = new ItemSetting<>(this, "night-efficiency-ratio", 1.6);

    public MoonlightTool(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        addItemSetting(dayEfficiencyRatio, nightEfficiencyRatio);
    }

    @Override
    @Nonnull
    public FasterToolUseHandler getItemHandler() {
        return event -> {
            if (event.isBestTool()) {
                World world = event.getPlayer().getWorld();
                double time = world.getTime();
                boolean isNight = 23460 > time && time >= 12542;
                double speedEfficiency = event.getToolSpeedEfficiency();

                event.setToolSpeedEfficiency(speedEfficiency * (isNight ?
                        nightEfficiencyRatio.getValue() : dayEfficiencyRatio.getValue()));
            }
        };
    }

}
