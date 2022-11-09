package me.smourad.fastertools.resources;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class FasterItems {

    private static final String MOONLIGHT_LORE = ChatColor.WHITE + "This tool is thirsty of moonlight ☽";

    public static final SlimefunItemStack MOONLIGHT_PICKAXE = new SlimefunItemStack("MOONLIGHT_PICKAXE", Material.IRON_PICKAXE, ChatColor.LIGHT_PURPLE + "Moonlight Pickaxe", MOONLIGHT_LORE);
    public static final SlimefunItemStack MOONLIGHT_AXE = new SlimefunItemStack("MOONLIGHT_AXE", Material.IRON_AXE, ChatColor.LIGHT_PURPLE + "Moonlight Axe", MOONLIGHT_LORE);
    public static final SlimefunItemStack MOONLIGHT_SHOVEL = new SlimefunItemStack("MOONLIGHT_SHOVEL", Material.IRON_SHOVEL, ChatColor.LIGHT_PURPLE + "Moonlight Shovel", MOONLIGHT_LORE);
    public static final SlimefunItemStack MOONLIGHT_HOE = new SlimefunItemStack("MOONLIGHT_HOE",Material.IRON_HOE, ChatColor.LIGHT_PURPLE + "Moonlight Hoe", MOONLIGHT_LORE);
    public static final SlimefunItemStack MOONLIGHT_SHEARS = new SlimefunItemStack("MOONLIGHT_SHEARS", Material.SHEARS, ChatColor.LIGHT_PURPLE + "Moonlight Shears", MOONLIGHT_LORE);

}
