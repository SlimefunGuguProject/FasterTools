package me.smourad.fastertools.mining;

import org.bukkit.Material;

import java.util.Random;

public class MinerUtils {

    public static boolean isBestToolToBreakBlock(Material tool, Material block) {
        switch (tool) {
            case WOODEN_AXE:
            case STONE_AXE:
            case IRON_AXE:
            case GOLDEN_AXE:
            case DIAMOND_AXE:
            case NETHERITE_AXE:
                switch (block) {
                    // PLANTS
                    case BEE_NEST:
                    case CARVED_PUMPKIN:
                    case COCOA:
                    case JACK_O_LANTERN:
                    case MELON:
                    case RED_MUSHROOM_BLOCK:
                    case BROWN_MUSHROOM_BLOCK:
                    case MUSHROOM_STEM:
                    case PUMPKIN:
                    case VINE:

                        // WOOD
                    case BLACK_BANNER:
                    case BLACK_WALL_BANNER:
                    case BLUE_BANNER:
                    case BLUE_WALL_BANNER:
                    case BROWN_BANNER:
                    case BROWN_WALL_BANNER:
                    case CYAN_BANNER:
                    case CYAN_WALL_BANNER:
                    case GRAY_BANNER:
                    case GRAY_WALL_BANNER:
                    case GREEN_BANNER:
                    case GREEN_WALL_BANNER:
                    case LIGHT_BLUE_BANNER:
                    case LIGHT_BLUE_WALL_BANNER:
                    case LIGHT_GRAY_BANNER:
                    case LIGHT_GRAY_WALL_BANNER:
                    case LIME_BANNER:
                    case LIME_WALL_BANNER:
                    case MAGENTA_BANNER:
                    case MAGENTA_WALL_BANNER:
                    case ORANGE_BANNER:
                    case ORANGE_WALL_BANNER:
                    case PINK_BANNER:
                    case PINK_WALL_BANNER:
                    case PURPLE_BANNER:
                    case PURPLE_WALL_BANNER:
                    case RED_BANNER:
                    case RED_WALL_BANNER:
                    case WHITE_BANNER:
                    case WHITE_WALL_BANNER:
                    case YELLOW_BANNER:
                    case YELLOW_WALL_BANNER:
                    case BARREL:
                    case BEEHIVE:
                    case BOOKSHELF:
                    case CAMPFIRE:
                    case SOUL_CAMPFIRE:
                    case CARTOGRAPHY_TABLE:
                    case CHEST:
                    case COMPOSTER:
                    case CRAFTING_TABLE:
                    case DAYLIGHT_DETECTOR:
                    case ACACIA_FENCE:
                    case BIRCH_FENCE:
                    case CRIMSON_FENCE:
                    case DARK_OAK_FENCE:
                    case JUNGLE_FENCE:
                    case MANGROVE_FENCE:
                    case OAK_FENCE:
                    case SPRUCE_FENCE:
                    case WARPED_FENCE:
                    case ACACIA_FENCE_GATE:
                    case BIRCH_FENCE_GATE:
                    case CRIMSON_FENCE_GATE:
                    case DARK_OAK_FENCE_GATE:
                    case JUNGLE_FENCE_GATE:
                    case MANGROVE_FENCE_GATE:
                    case OAK_FENCE_GATE:
                    case SPRUCE_FENCE_GATE:
                    case WARPED_FENCE_GATE:
                    case FLETCHING_TABLE:
                    case JUKEBOX:
                    case WARPED_HYPHAE:
                    case CRIMSON_HYPHAE:
                    case STRIPPED_WARPED_HYPHAE:
                    case STRIPPED_CRIMSON_HYPHAE:
                    case LADDER:
                    case LECTERN:
                    case ACACIA_LOG:
                    case BIRCH_LOG:
                    case DARK_OAK_LOG:
                    case JUNGLE_LOG:
                    case MANGROVE_LOG:
                    case OAK_LOG:
                    case SPRUCE_LOG:
                    case LOOM:
                    case MANGROVE_ROOTS:
                    case NOTE_BLOCK:
                    case ACACIA_PLANKS:
                    case BIRCH_PLANKS:
                    case CRIMSON_PLANKS:
                    case DARK_OAK_PLANKS:
                    case JUNGLE_PLANKS:
                    case MANGROVE_PLANKS:
                    case OAK_PLANKS:
                    case SPRUCE_PLANKS:
                    case WARPED_PLANKS:
                    case ACACIA_SIGN:
                    case BIRCH_SIGN:
                    case CRIMSON_SIGN:
                    case DARK_OAK_SIGN:
                    case JUNGLE_SIGN:
                    case MANGROVE_SIGN:
                    case OAK_SIGN:
                    case SPRUCE_SIGN:
                    case WARPED_SIGN:
                    case ACACIA_WALL_SIGN:
                    case BIRCH_WALL_SIGN:
                    case CRIMSON_WALL_SIGN:
                    case DARK_OAK_WALL_SIGN:
                    case JUNGLE_WALL_SIGN:
                    case MANGROVE_WALL_SIGN:
                    case OAK_WALL_SIGN:
                    case SPRUCE_WALL_SIGN:
                    case WARPED_WALL_SIGN:
                    case CRIMSON_STEM:
                    case STRIPPED_CRIMSON_STEM:
                    case SMITHING_TABLE:
                    case TRAPPED_CHEST:
                    case ACACIA_WOOD:
                    case BIRCH_WOOD:
                    case DARK_OAK_WOOD:
                    case JUNGLE_WOOD:
                    case MANGROVE_WOOD:
                    case OAK_WOOD:
                    case SPRUCE_WOOD:
                    case ACACIA_BUTTON:
                    case BIRCH_BUTTON:
                    case DARK_OAK_BUTTON:
                    case JUNGLE_BUTTON:
                    case MANGROVE_BUTTON:
                    case OAK_BUTTON:
                    case SPRUCE_BUTTON:
                    case CRIMSON_BUTTON:
                    case WARPED_BUTTON:
                    case ACACIA_DOOR:
                    case BIRCH_DOOR:
                    case DARK_OAK_DOOR:
                    case JUNGLE_DOOR:
                    case MANGROVE_DOOR:
                    case OAK_DOOR:
                    case SPRUCE_DOOR:
                    case CRIMSON_DOOR:
                    case WARPED_DOOR:
                    case ACACIA_PRESSURE_PLATE:
                    case BIRCH_PRESSURE_PLATE:
                    case DARK_OAK_PRESSURE_PLATE:
                    case JUNGLE_PRESSURE_PLATE:
                    case MANGROVE_PRESSURE_PLATE:
                    case OAK_PRESSURE_PLATE:
                    case SPRUCE_PRESSURE_PLATE:
                    case CRIMSON_PRESSURE_PLATE:
                    case WARPED_PRESSURE_PLATE:
                    case ACACIA_SLAB:
                    case BIRCH_SLAB:
                    case DARK_OAK_SLAB:
                    case JUNGLE_SLAB:
                    case MANGROVE_SLAB:
                    case OAK_SLAB:
                    case SPRUCE_SLAB:
                    case CRIMSON_SLAB:
                    case WARPED_SLAB:
                    case ACACIA_STAIRS:
                    case BIRCH_STAIRS:
                    case DARK_OAK_STAIRS:
                    case JUNGLE_STAIRS:
                    case MANGROVE_STAIRS:
                    case OAK_STAIRS:
                    case SPRUCE_STAIRS:
                    case CRIMSON_STAIRS:
                    case WARPED_STAIRS:
                    case ACACIA_TRAPDOOR:
                    case BIRCH_TRAPDOOR:
                    case DARK_OAK_TRAPDOOR:
                    case JUNGLE_TRAPDOOR:
                    case MANGROVE_TRAPDOOR:
                    case OAK_TRAPDOOR:
                    case SPRUCE_TRAPDOOR:
                    case CRIMSON_TRAPDOOR:
                    case WARPED_TRAPDOOR:
                        return true;

                    default:
                        return false;
                }

            case WOODEN_PICKAXE:
            case IRON_PICKAXE:
            case STONE_PICKAXE:
            case DIAMOND_PICKAXE:
            case GOLDEN_PICKAXE:
            case NETHERITE_PICKAXE:
                switch (block) {
                    // ICE
                    case BLUE_ICE:
                    case ICE:
                    case PACKED_ICE:

                        // Metal I
                    case ANVIL:
                    case CHIPPED_ANVIL:
                    case DAMAGED_ANVIL:
                    case BELL:
                    case REDSTONE_BLOCK:
                    case BREWING_STAND:
                    case CAULDRON:
                    case CHAIN:
                    case HOPPER:
                    case IRON_BARS:
                    case IRON_DOOR:
                    case IRON_TRAPDOOR:
                    case LANTERN:
                    case SOUL_LANTERN:
                    case LIGHT_WEIGHTED_PRESSURE_PLATE:
                    case HEAVY_WEIGHTED_PRESSURE_PLATE:

                        // Metal II
                    case COPPER_BLOCK:
                    case WAXED_COPPER_BLOCK:
                    case IRON_BLOCK:
                    case LAPIS_BLOCK:
                    case CUT_COPPER:
                    case EXPOSED_CUT_COPPER:
                    case OXIDIZED_CUT_COPPER:
                    case WEATHERED_CUT_COPPER:
                    case WAXED_CUT_COPPER:
                    case WAXED_EXPOSED_CUT_COPPER:
                    case WAXED_OXIDIZED_CUT_COPPER:
                    case WAXED_WEATHERED_CUT_COPPER:
                    case CUT_COPPER_SLAB:
                    case EXPOSED_CUT_COPPER_SLAB:
                    case OXIDIZED_CUT_COPPER_SLAB:
                    case WEATHERED_CUT_COPPER_SLAB:
                    case WAXED_CUT_COPPER_SLAB:
                    case WAXED_EXPOSED_CUT_COPPER_SLAB:
                    case WAXED_OXIDIZED_CUT_COPPER_SLAB:
                    case WAXED_WEATHERED_CUT_COPPER_SLAB:
                    case CUT_COPPER_STAIRS:
                    case EXPOSED_CUT_COPPER_STAIRS:
                    case OXIDIZED_CUT_COPPER_STAIRS:
                    case WEATHERED_CUT_COPPER_STAIRS:
                    case WAXED_CUT_COPPER_STAIRS:
                    case WAXED_EXPOSED_CUT_COPPER_STAIRS:
                    case WAXED_OXIDIZED_CUT_COPPER_STAIRS:
                    case WAXED_WEATHERED_CUT_COPPER_STAIRS:
                    case LIGHTNING_ROD:

                        // METAL III
                    case DIAMOND_BLOCK:
                    case EMERALD_BLOCK:
                    case GOLD_BLOCK:

                        // METAL IV
                    case NETHERITE_BLOCK:

                        // PISTON
                    case PISTON:
                    case STICKY_PISTON:
                    case PISTON_HEAD:

                        // OTHER
                    case CONDUIT:
                    case SHULKER_BOX:

                        // RAIL
                    case ACTIVATOR_RAIL:
                    case DETECTOR_RAIL:
                    case POWERED_RAIL:
                    case RAIL:

                        // ROCK I
                    case SMALL_AMETHYST_BUD:
                    case MEDIUM_AMETHYST_BUD:
                    case LARGE_AMETHYST_BUD:
                    case ANDESITE:
                    case BASALT:
                    case BLACKSTONE:
                    case BLAST_FURNACE:
                    case AMETHYST_BLOCK:
                    case COAL_BLOCK:
                    case QUARTZ_BLOCK:
                    case BONE_BLOCK:
                    case BRICKS:
                    case BUDDING_AMETHYST:
                    case COAL_ORE:
                    case COBBLED_DEEPSLATE:
                    case COBBLESTONE:
                    case TERRACOTTA:
                    case BLACK_TERRACOTTA:
                    case BLUE_TERRACOTTA:
                    case BROWN_TERRACOTTA:
                    case CYAN_TERRACOTTA:
                    case GRAY_TERRACOTTA:
                    case GREEN_TERRACOTTA:
                    case LIGHT_BLUE_TERRACOTTA:
                    case LIGHT_GRAY_TERRACOTTA:
                    case LIME_TERRACOTTA:
                    case MAGENTA_TERRACOTTA:
                    case ORANGE_TERRACOTTA:
                    case PINK_TERRACOTTA:
                    case PURPLE_TERRACOTTA:
                    case RED_TERRACOTTA:
                    case WHITE_TERRACOTTA:
                    case YELLOW_TERRACOTTA:
                    case BLACK_CONCRETE:
                    case BLUE_CONCRETE:
                    case BROWN_CONCRETE:
                    case CYAN_CONCRETE:
                    case GRAY_CONCRETE:
                    case GREEN_CONCRETE:
                    case LIGHT_BLUE_CONCRETE:
                    case LIGHT_GRAY_CONCRETE:
                    case LIME_CONCRETE:
                    case MAGENTA_CONCRETE:
                    case ORANGE_CONCRETE:
                    case PINK_CONCRETE:
                    case PURPLE_CONCRETE:
                    case RED_CONCRETE:
                    case WHITE_CONCRETE:
                    case YELLOW_CONCRETE:
                    case BRAIN_CORAL_BLOCK:
                    case BUBBLE_CORAL_BLOCK:
                    case FIRE_CORAL_BLOCK:
                    case HORN_CORAL_BLOCK:
                    case TUBE_CORAL_BLOCK:
                    case DARK_PRISMARINE:
                    case DEAD_BRAIN_CORAL_BLOCK:
                    case DEAD_BUBBLE_CORAL_BLOCK:
                    case DEAD_FIRE_CORAL_BLOCK:
                    case DEAD_HORN_CORAL_BLOCK:
                    case DEAD_TUBE_CORAL_BLOCK:
                    case DEEPSLATE:
                    case DEEPSLATE_BRICKS:
                    case CHISELED_DEEPSLATE:
                    case INFESTED_DEEPSLATE:
                    case POLISHED_DEEPSLATE:
                    case DEEPSLATE_COAL_ORE:
                    case DIORITE:
                    case DISPENSER:
                    case DRIPSTONE_BLOCK:
                    case DROPPER:
                    case ENCHANTING_TABLE:
                    case END_STONE:
                    case ENDER_CHEST:
                    case FURNACE:
                    case GILDED_BLACKSTONE:
                    case BLACK_GLAZED_TERRACOTTA:
                    case BLUE_GLAZED_TERRACOTTA:
                    case BROWN_GLAZED_TERRACOTTA:
                    case CYAN_GLAZED_TERRACOTTA:
                    case GRAY_GLAZED_TERRACOTTA:
                    case GREEN_GLAZED_TERRACOTTA:
                    case LIGHT_BLUE_GLAZED_TERRACOTTA:
                    case LIGHT_GRAY_GLAZED_TERRACOTTA:
                    case LIME_GLAZED_TERRACOTTA:
                    case MAGENTA_GLAZED_TERRACOTTA:
                    case ORANGE_GLAZED_TERRACOTTA:
                    case PINK_GLAZED_TERRACOTTA:
                    case PURPLE_GLAZED_TERRACOTTA:
                    case RED_GLAZED_TERRACOTTA:
                    case WHITE_GLAZED_TERRACOTTA:
                    case YELLOW_GLAZED_TERRACOTTA:
                    case GRANITE:
                    case GRINDSTONE:
                    case LODESTONE:
                    case MOSSY_COBBLESTONE:
                    case MOSSY_STONE_BRICKS:
                    case MUD_BRICKS:
                    case NETHER_BRICKS:
                    case NETHER_BRICK_FENCE:
                    case NETHER_GOLD_ORE:
                    case NETHER_QUARTZ_ORE:
                    case NETHERRACK:
                    case OBSERVER:
                    case PACKED_MUD:
                    case PRISMARINE:
                    case PRISMARINE_BRICKS:
                    case POINTED_DRIPSTONE:
                    case POLISHED_ANDESITE:
                    case POLISHED_BLACKSTONE:
                    case POLISHED_BLACKSTONE_BRICKS:
                    case POLISHED_BLACKSTONE_BUTTON:
                    case POLISHED_BLACKSTONE_PRESSURE_PLATE:
                    case POLISHED_DIORITE:
                    case POLISHED_GRANITE:
                    case RED_SANDSTONE:
                    case SANDSTONE:
                    case SMOKER:
                    case SPAWNER:
                    case STONECUTTER:
                    case COBBLED_DEEPSLATE_SLAB:
                    case POLISHED_DEEPSLATE_SLAB:
                    case DEEPSLATE_BRICK_SLAB:
                    case DEEPSLATE_TILE_SLAB:
                    case END_STONE_BRICK_SLAB:
                    case STONE_BRICK_SLAB:
                    case BLACKSTONE_SLAB:
                    case POLISHED_BLACKSTONE_SLAB:
                    case POLISHED_BLACKSTONE_BRICK_SLAB:
                    case MOSSY_COBBLESTONE_SLAB:
                    case MOSSY_STONE_BRICK_SLAB:
                    case DARK_PRISMARINE_SLAB:
                    case COBBLESTONE_SLAB:
                    case STONE_SLAB:
                    case SMOOTH_STONE_SLAB:
                    case NETHER_BRICK_SLAB:
                    case RED_NETHER_BRICK_SLAB:
                    case PURPUR_SLAB:
                    case QUARTZ_SLAB:
                    case SMOOTH_QUARTZ_SLAB:
                    case SANDSTONE_SLAB:
                    case CUT_SANDSTONE_SLAB:
                    case SMOOTH_SANDSTONE_SLAB:
                    case CUT_RED_SANDSTONE_SLAB:
                    case SMOOTH_RED_SANDSTONE_SLAB:
                    case RED_SANDSTONE_SLAB:
                    case ANDESITE_SLAB:
                    case POLISHED_ANDESITE_SLAB:
                    case DIORITE_SLAB:
                    case POLISHED_DIORITE_SLAB:
                    case GRANITE_SLAB:
                    case POLISHED_GRANITE_SLAB:
                    case PRISMARINE_SLAB:
                    case PRISMARINE_BRICK_SLAB:
                    case MUD_BRICK_SLAB:
                    case SMOOTH_STONE:
                    case COBBLED_DEEPSLATE_STAIRS:
                    case POLISHED_DEEPSLATE_STAIRS:
                    case DEEPSLATE_BRICK_STAIRS:
                    case DEEPSLATE_TILE_STAIRS:
                    case END_STONE_BRICK_STAIRS:
                    case STONE_BRICK_STAIRS:
                    case BLACKSTONE_STAIRS:
                    case POLISHED_BLACKSTONE_STAIRS:
                    case POLISHED_BLACKSTONE_BRICK_STAIRS:
                    case MOSSY_COBBLESTONE_STAIRS:
                    case MOSSY_STONE_BRICK_STAIRS:
                    case COBBLESTONE_STAIRS:
                    case STONE_STAIRS:
                    case DARK_PRISMARINE_STAIRS:
                    case NETHER_BRICK_STAIRS:
                    case RED_NETHER_BRICK_STAIRS:
                    case PURPUR_STAIRS:
                    case QUARTZ_STAIRS:
                    case SMOOTH_QUARTZ_STAIRS:
                    case SANDSTONE_STAIRS:
                    case BRICK_STAIRS:
                    case SMOOTH_SANDSTONE_STAIRS:
                    case SMOOTH_RED_SANDSTONE_STAIRS:
                    case RED_SANDSTONE_STAIRS:
                    case ANDESITE_STAIRS:
                    case POLISHED_ANDESITE_STAIRS:
                    case DIORITE_STAIRS:
                    case POLISHED_DIORITE_STAIRS:
                    case GRANITE_STAIRS:
                    case POLISHED_GRANITE_STAIRS:
                    case PRISMARINE_STAIRS:
                    case PRISMARINE_BRICK_STAIRS:
                    case MUD_BRICK_STAIRS:
                    case STONE:
                    case INFESTED_MOSSY_STONE_BRICKS:
                    case STONE_BRICKS:
                    case STONE_BUTTON:
                    case STONE_PRESSURE_PLATE:
                    case DEEPSLATE_BRICK_WALL:
                    case DEEPSLATE_TILE_WALL:
                    case COBBLED_DEEPSLATE_WALL:
                    case POLISHED_DEEPSLATE_WALL:
                    case END_STONE_BRICK_WALL:
                    case BRICK_WALL:
                    case MOSSY_COBBLESTONE_WALL:
                    case RED_NETHER_BRICK_WALL:
                    case POLISHED_BLACKSTONE_WALL:
                    case ANDESITE_WALL:
                    case BLACKSTONE_WALL:
                    case DIORITE_WALL:
                    case GRANITE_WALL:
                    case POLISHED_BLACKSTONE_BRICK_WALL:
                    case PRISMARINE_WALL:
                    case MOSSY_STONE_BRICK_WALL:
                    case MUD_BRICK_WALL:
                    case SANDSTONE_WALL:
                    case RED_SANDSTONE_WALL:
                    case SMOOTH_SANDSTONE:
                    case CHISELED_RED_SANDSTONE:
                    case CHISELED_SANDSTONE:
                    case CUT_SANDSTONE:
                    case CUT_RED_SANDSTONE:
                    case SMOOTH_RED_SANDSTONE:

                        // Rock II
                    case RAW_COPPER_BLOCK:
                    case RAW_IRON_BLOCK:
                    case COPPER_ORE:
                    case DEEPSLATE_COPPER_ORE:
                    case DEEPSLATE_IRON_ORE:
                    case DEEPSLATE_LAPIS_ORE:
                    case IRON_ORE:
                    case LAPIS_ORE:

                        // Rock III
                    case RAW_GOLD_BLOCK:
                    case DEEPSLATE_DIAMOND_ORE:
                    case DEEPSLATE_EMERALD_ORE:
                    case DEEPSLATE_GOLD_ORE:
                    case DEEPSLATE_REDSTONE_ORE:
                    case DIAMOND_ORE:
                    case EMERALD_ORE:
                    case GOLD_ORE:
                    case REDSTONE_ORE:

                        // Rock IV
                    case ANCIENT_DEBRIS:
                    case CRYING_OBSIDIAN:
                    case OBSIDIAN:
                    case RESPAWN_ANCHOR:
                        return true;

                    default:
                        return false;
                }

            case SHEARS:
                switch (block) {
                    case ACACIA_LEAVES:
                    case AZALEA_LEAVES:
                    case OAK_LEAVES:
                    case BIRCH_LEAVES:
                    case DARK_OAK_LEAVES:
                    case FLOWERING_AZALEA_LEAVES:
                    case JUNGLE_LEAVES:
                    case MANGROVE_LEAVES:
                    case SPRUCE_LEAVES:
                    case COBWEB:
                    case BLACK_WOOL:
                    case BLUE_WOOL:
                    case BROWN_WOOL:
                    case CYAN_WOOL:
                    case GRAY_WOOL:
                    case GREEN_WOOL:
                    case LIGHT_BLUE_WOOL:
                    case LIGHT_GRAY_WOOL:
                    case LIME_WOOL:
                    case MAGENTA_WOOL:
                    case ORANGE_WOOL:
                    case PINK_WOOL:
                    case PURPLE_WOOL:
                    case RED_WOOL:
                    case WHITE_WOOL:
                    case YELLOW_WOOL:

                    default:
                        return false;
                }

            case DIAMOND_SHOVEL:
            case GOLDEN_SHOVEL:
            case IRON_SHOVEL:
            case NETHERITE_SHOVEL:
            case STONE_SHOVEL:
            case WOODEN_SHOVEL:
                switch (block) {
                    case CLAY:
                    case COARSE_DIRT:
                    case BLACK_CONCRETE_POWDER:
                    case BLUE_CONCRETE_POWDER:
                    case BROWN_CONCRETE_POWDER:
                    case CYAN_CONCRETE_POWDER:
                    case GRAY_CONCRETE_POWDER:
                    case GREEN_CONCRETE_POWDER:
                    case LIGHT_BLUE_CONCRETE_POWDER:
                    case LIGHT_GRAY_CONCRETE_POWDER:
                    case LIME_CONCRETE_POWDER:
                    case MAGENTA_CONCRETE_POWDER:
                    case ORANGE_CONCRETE_POWDER:
                    case PINK_CONCRETE_POWDER:
                    case PURPLE_CONCRETE_POWDER:
                    case RED_CONCRETE_POWDER:
                    case WHITE_CONCRETE_POWDER:
                    case YELLOW_CONCRETE_POWDER:
                    case DIRT:
                    case DIRT_PATH:
                    case FARMLAND:
                    case GRASS_BLOCK:
                    case GRAVEL:
                    case MUD:
                    case MUDDY_MANGROVE_ROOTS:
                    case MYCELIUM:
                    case PODZOL:
                    case RED_SAND:
                    case SAND:
                    case SOUL_SAND:
                    case SOUL_SOIL:
                    case SNOW:
                    case SNOW_BLOCK:
                        return true;

                    default:
                        return false;
                }

            case DIAMOND_SWORD:
            case GOLDEN_SWORD:
            case IRON_SWORD:
            case NETHERITE_SWORD:
            case STONE_SWORD:
            case WOODEN_SWORD:
                switch (block) {
                    case COBWEB:
                    case BAMBOO:
                        return true;

                    default:
                        return false;
                }

            case DIAMOND_HOE:
            case GOLDEN_HOE:
            case IRON_HOE:
            case NETHERITE_HOE:
            case STONE_HOE:
            case WOODEN_HOE:
                switch (block) {
                    case HAY_BLOCK:
                    case ACACIA_LEAVES:
                    case AZALEA_LEAVES:
                    case OAK_LEAVES:
                    case BIRCH_LEAVES:
                    case DARK_OAK_LEAVES:
                    case FLOWERING_AZALEA_LEAVES:
                    case JUNGLE_LEAVES:
                    case MANGROVE_LEAVES:
                    case SPRUCE_LEAVES:
                    case MOSS_BLOCK:
                    case NETHER_WART_BLOCK:
                    case SCULK:
                    case SCULK_CATALYST:
                    case SCULK_SENSOR:
                    case SCULK_SHRIEKER:
                    case SCULK_VEIN:
                    case SHROOMLIGHT:
                    case SPONGE:
                    case TARGET:
                    case WARPED_WART_BLOCK:
                    case WET_SPONGE:
                        return true;

                    default:
                        return false;
                }

            default:
                return false;
        }
    }

    public static int getExpToDrop(Material block) {
        Random random = new Random();

        return switch (block) {
            case COAL_ORE -> random.nextInt(3);
            case NETHER_GOLD_ORE -> random.nextInt(2);
            case DIAMOND_ORE, EMERALD_ORE -> 3 + random.nextInt(5);
            case LAPIS_ORE, NETHER_QUARTZ_ORE -> 2 + random.nextInt(4);
            case REDSTONE_ORE -> 1 + random.nextInt(5);
            case SPAWNER -> 15 + random.nextInt(29);
            case SCULK -> 1;
            case SCULK_SENSOR, SCULK_SHRIEKER, SCULK_CATALYST -> 5;
            default -> 0;
        };
    }

    public static double getSpeedMultiplier(Material tool, Material block) {
        if (isBestToolToBreakBlock(tool, block)) {
            return switch (tool) {
                case WOODEN_AXE, WOODEN_HOE, WOODEN_SHOVEL, WOODEN_PICKAXE -> 2.0;
                case STONE_AXE, STONE_HOE, STONE_SHOVEL, STONE_PICKAXE -> 4.0;
                case IRON_AXE, IRON_HOE, IRON_SHOVEL, IRON_PICKAXE -> 6.0;
                case GOLDEN_AXE, GOLDEN_HOE, GOLDEN_SHOVEL, GOLDEN_PICKAXE -> 12.0;
                case DIAMOND_AXE, DIAMOND_HOE, DIAMOND_SHOVEL, DIAMOND_PICKAXE -> 8.0;
                case NETHERITE_AXE, NETHERITE_HOE, NETHERITE_SHOVEL, NETHERITE_PICKAXE -> 9.0;
                case SHEARS -> switch (block) {
                    case    VINE, GLOW_LICHEN -> 1.0;
                    case    BLACK_WOOL, BLUE_WOOL, BROWN_WOOL, CYAN_WOOL, GRAY_WOOL, GREEN_WOOL,
                            LIGHT_BLUE_WOOL, LIGHT_GRAY_WOOL, LIME_WOOL, MAGENTA_WOOL, ORANGE_WOOL,
                            PINK_WOOL, PURPLE_WOOL, RED_WOOL, WHITE_WOOL, YELLOW_WOOL -> 5.0;
                    case    COBWEB, ACACIA_LEAVES, AZALEA_LEAVES, BIRCH_LEAVES, DARK_OAK_LEAVES,
                            FLOWERING_AZALEA_LEAVES, JUNGLE_LEAVES, MANGROVE_LEAVES, OAK_LEAVES,
                            SPRUCE_LEAVES -> 15.0;
                    default -> 2.0;
                };
                case WOODEN_SWORD, STONE_SWORD, IRON_SWORD, GOLDEN_SWORD, DIAMOND_SWORD, NETHERITE_SWORD ->
                        block.equals(Material.COBWEB) ? 15.0 : 1.5;
                default -> 1.0;
            };
        } else {
            return 1.0;
        }
    }

}
