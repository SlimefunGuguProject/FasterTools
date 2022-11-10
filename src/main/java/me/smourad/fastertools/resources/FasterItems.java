package me.smourad.fastertools.resources;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import me.smourad.fastertools.lore.FasterLore;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class FasterItems {

    private static final String MOONLIGHT_LORE = ChatColor.WHITE + "This tool is thirsty of moonlight ☽";
    private static final String LAST_STAND_LORE = ChatColor.WHITE + "This tool do his best at the end";

    public static final SlimefunItemStack MOONLIGHT_PICKAXE = new SlimefunItemStack("MOONLIGHT_PICKAXE", Material.IRON_PICKAXE, ChatColor.LIGHT_PURPLE + "Moonlight Pickaxe", MOONLIGHT_LORE, FasterLore.generate());
    public static final SlimefunItemStack MOONLIGHT_AXE = new SlimefunItemStack("MOONLIGHT_AXE", Material.IRON_AXE, ChatColor.LIGHT_PURPLE + "Moonlight Axe", MOONLIGHT_LORE,  FasterLore.generate());
    public static final SlimefunItemStack MOONLIGHT_SHOVEL = new SlimefunItemStack("MOONLIGHT_SHOVEL", Material.IRON_SHOVEL, ChatColor.LIGHT_PURPLE + "Moonlight Shovel", MOONLIGHT_LORE, FasterLore.generate());
    public static final SlimefunItemStack MOONLIGHT_HOE = new SlimefunItemStack("MOONLIGHT_HOE",Material.IRON_HOE, ChatColor.LIGHT_PURPLE + "Moonlight Hoe", MOONLIGHT_LORE, FasterLore.generate());
    public static final SlimefunItemStack MOONLIGHT_SHEARS = new SlimefunItemStack("MOONLIGHT_SHEARS", Material.SHEARS, ChatColor.LIGHT_PURPLE + "Moonlight Shears", MOONLIGHT_LORE, FasterLore.generate());

    public static final SlimefunItemStack LAST_STAND_PICKAXE = new SlimefunItemStack("LAST_STAND_PICKAXE", Material.GOLDEN_PICKAXE, ChatColor.RED + "Last Stand Pickaxe", LAST_STAND_LORE, FasterLore.generate());
    public static final SlimefunItemStack LAST_STAND_AXE = new SlimefunItemStack("LAST_STAND_AXE", Material.GOLDEN_AXE, ChatColor.RED + "Last Stand Axe", LAST_STAND_LORE, FasterLore.generate());
    public static final SlimefunItemStack LAST_STAND_SHOVEL = new SlimefunItemStack("LAST_STAND_SHOVEL", Material.GOLDEN_SHOVEL, ChatColor.RED + "Last Stand Shovel", LAST_STAND_LORE, FasterLore.generate());
    public static final SlimefunItemStack LAST_STAND_HOE = new SlimefunItemStack("LAST_STAND_HOE", Material.GOLDEN_HOE, ChatColor.RED + "Last Stand Hoe", LAST_STAND_LORE, FasterLore.generate());


}
