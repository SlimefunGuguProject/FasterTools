package me.smourad.fastertools.lore;

import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;
import io.github.thebusybiscuit.slimefun4.libraries.dough.common.ChatColors;
import org.bukkit.ChatColor;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class FasterLore {

    private FasterLore() {}

    public static final String LORE_PREFIX = ChatColors.color("&8\u21E8 &7Mining Speed: ");
    private static final Pattern NEGATIVE_REGEX = Pattern.compile(ChatColors.color("(&c&o)?" + LORE_PREFIX) + ChatColor.GREEN + "\\+[0-9]+%");
    private static final Pattern POSITIVE_REGEX = Pattern.compile(ChatColors.color("(&c&o)?" + LORE_PREFIX) + ChatColor.RED   +   "-[0-9]+%");

    public static void update(@Nonnull ItemMeta meta, double ratio) {
        Validate.notNull(meta, "Meta cannot be null!");

        List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
        for (int i = 0; i < lore.size(); i++) {
            String line = lore.get(i);

            if (POSITIVE_REGEX.matcher(line).matches() || NEGATIVE_REGEX.matcher(line).matches()) {
                lore.set(i, getFasterLoreString(ratio));
                meta.setLore(lore);
                return;
            }
        }

        lore.add(getFasterLoreString(ratio));
        meta.setLore(lore);
    }

    private static String getFasterLoreString(double ratio) {
        int percent = (int) (100 * ratio) - 100;
        StringBuilder str = new StringBuilder()
                .append(LORE_PREFIX);

        if (percent < 0) {
            str.append(ChatColor.RED)
                    .append("-");
        } else {
            str.append(ChatColor.GREEN)
                    .append("+");
        }

        return str.append(Math.abs(percent))
                .append("%")
                .toString();
    }

}
