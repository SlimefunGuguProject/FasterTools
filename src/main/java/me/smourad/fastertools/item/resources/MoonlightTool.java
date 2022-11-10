package me.smourad.fastertools.item.resources;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemSetting;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.smourad.fastertools.item.FasterTool;
import me.smourad.fastertools.utils.FasterConstant;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MoonlightTool extends FasterTool {

    protected final ItemSetting<Double> dayEfficiencyRatio = new ItemSetting<>(this, "day-efficiency-ratio", 0.8);
    protected final ItemSetting<Double> nightEfficiencyRatio = new ItemSetting<>(this, "night-efficiency-ratio", 1.6);

    public MoonlightTool(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        addItemSetting(dayEfficiencyRatio, nightEfficiencyRatio);
    }

    @Override
    public double getEfficiencyMultiplier(Player player, ItemStack tool) {
        World world = player.getWorld();
        double time = world.getTime();
        boolean isNight = FasterConstant.DAY_BEGIN_TIME > time && time >= FasterConstant.NIGHT_BEGIN_TIME;

        return isNight ? nightEfficiencyRatio.getValue() : dayEfficiencyRatio.getValue();
    }

}
