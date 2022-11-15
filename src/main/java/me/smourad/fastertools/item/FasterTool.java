package me.smourad.fastertools.item;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemSetting;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.DamageableItem;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import me.smourad.fastertools.lore.FasterLore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public abstract class FasterTool extends SimpleSlimefunItem<FasterToolUseHandler> implements NotPlaceable, DamageableItem {

    protected final ItemSetting<Boolean> damageOnUse = new ItemSetting<>(this, "damage-on-use", Boolean.TRUE);

    protected FasterTool(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        addItemSetting(damageOnUse);
    }

    @Override
    public boolean isDamageable() {
        return damageOnUse.getValue();
    }

    @Override
    @Nonnull
    public FasterToolUseHandler getItemHandler() {
        return event -> {
            if (event.isBestTool()) {
                double speedEfficiency = event.getToolSpeedEfficiency();
                event.setToolSpeedEfficiency(speedEfficiency * getEfficiencyMultiplier(event.getPlayer(), event.getTool()));
            }
        };
    }

    public abstract double getEfficiencyMultiplier(Player player, ItemStack tool);

}
