package me.smourad.fastertools.resources;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.food.FortuneCookie;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.smourad.fastertools.FasterToolsAddon;
import me.smourad.fastertools.item.resources.MoonlightTool;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class FasterItemSetup {

    private static boolean registeredItems = false;

    private FasterItemSetup() {}

     private static final ItemGroup FASTER_TOOL = new ItemGroup(new NamespacedKey(FasterToolsAddon.INSTANCE, "faster-tool"),
            new CustomItemStack(FasterItems.MOONLIGHT_PICKAXE, ChatColor.YELLOW + ""), 1);

    public static void setup() {
        if (registeredItems) {
            throw new UnsupportedOperationException("Slimefun Faster Items can only be registered once!");
        }

        registeredItems = true;

        new MoonlightTool(FASTER_TOOL, FasterItems.MOONLIGHT_PICKAXE, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        new ItemStack(Material.CLOCK), new ItemStack(Material.DAYLIGHT_DETECTOR), new ItemStack(Material.CLOCK),
                        new ItemStack(Material.DAYLIGHT_DETECTOR), new ItemStack(Material.IRON_PICKAXE), new ItemStack(Material.DAYLIGHT_DETECTOR),
                        new ItemStack(Material.CLOCK), new ItemStack(Material.DAYLIGHT_DETECTOR), new ItemStack(Material.CLOCK)
        }).register(FasterToolsAddon.INSTANCE);

        new MoonlightTool(FASTER_TOOL, FasterItems.MOONLIGHT_SHOVEL, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        new ItemStack(Material.CLOCK), new ItemStack(Material.DAYLIGHT_DETECTOR), new ItemStack(Material.CLOCK),
                        new ItemStack(Material.DAYLIGHT_DETECTOR), new ItemStack(Material.IRON_SHOVEL), new ItemStack(Material.DAYLIGHT_DETECTOR),
                        new ItemStack(Material.CLOCK), new ItemStack(Material.DAYLIGHT_DETECTOR), new ItemStack(Material.CLOCK)
                }).register(FasterToolsAddon.INSTANCE);

        new MoonlightTool(FASTER_TOOL, FasterItems.MOONLIGHT_AXE, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        new ItemStack(Material.CLOCK), new ItemStack(Material.DAYLIGHT_DETECTOR), new ItemStack(Material.CLOCK),
                        new ItemStack(Material.DAYLIGHT_DETECTOR), new ItemStack(Material.IRON_AXE), new ItemStack(Material.DAYLIGHT_DETECTOR),
                        new ItemStack(Material.CLOCK), new ItemStack(Material.DAYLIGHT_DETECTOR), new ItemStack(Material.CLOCK)
                }).register(FasterToolsAddon.INSTANCE);

        new MoonlightTool(FASTER_TOOL, FasterItems.MOONLIGHT_HOE, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        new ItemStack(Material.CLOCK), new ItemStack(Material.DAYLIGHT_DETECTOR), new ItemStack(Material.CLOCK),
                        new ItemStack(Material.DAYLIGHT_DETECTOR), new ItemStack(Material.IRON_HOE), new ItemStack(Material.DAYLIGHT_DETECTOR),
                        new ItemStack(Material.CLOCK), new ItemStack(Material.DAYLIGHT_DETECTOR), new ItemStack(Material.CLOCK)
                }).register(FasterToolsAddon.INSTANCE);

        new MoonlightTool(FASTER_TOOL, FasterItems.MOONLIGHT_SHEARS, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        new ItemStack(Material.CLOCK), new ItemStack(Material.DAYLIGHT_DETECTOR), new ItemStack(Material.CLOCK),
                        new ItemStack(Material.DAYLIGHT_DETECTOR), new ItemStack(Material.SHEARS), new ItemStack(Material.DAYLIGHT_DETECTOR),
                        new ItemStack(Material.CLOCK), new ItemStack(Material.DAYLIGHT_DETECTOR), new ItemStack(Material.CLOCK)
                }).register(FasterToolsAddon.INSTANCE);
    }

}
