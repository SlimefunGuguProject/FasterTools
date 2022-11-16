package me.smourad.fastertools.item;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemSetting;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.DamageableItem;
import org.bukkit.inventory.ItemStack;

public abstract class DamageableFasterTool extends FasterTool implements DamageableItem {

    protected final ItemSetting<Boolean> damageOnUse = new ItemSetting<>(this, "damage-on-use", Boolean.TRUE);

    public DamageableFasterTool(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        addItemSetting(damageOnUse);
    }

    @Override
    public boolean isDamageable() {
        return damageOnUse.getValue();
    }
}
