package me.smourad.fastertools.lore;

import io.github.thebusybiscuit.slimefun4.libraries.commons.lang.Validate;
import io.github.thebusybiscuit.slimefun4.libraries.dough.common.ChatColors;
import org.bukkit.ChatColor;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class FasterLore {

    private FasterLore() {}

    public static final String LORE_PREFIX = ChatColors.color("&8\u21E8 &7");
    private static final Pattern REGEX = Pattern.compile(ChatColors.color("(&c&o)?" + LORE_PREFIX) + "[0-9.]+x faster");

    public static String generate() {
        return ChatColor.DARK_GRAY + "\u21E8 " + ChatColor.GRAY + new DecimalFormat("#0.00").format(1.0) + "x faster";
    }

    public static void update(@Nonnull ItemMeta meta, double ratio) {
        Validate.notNull(meta, "Meta cannot be null!");
        String ratioFormat = new DecimalFormat("#0.00").format(ratio);

        List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
        for (int i = 0; i < lore.size(); i++) {
            String line = lore.get(i);

            if (REGEX.matcher(line).matches()) {
                lore.set(i, LORE_PREFIX + ratioFormat + "x faster");
                meta.setLore(lore);
                return;
            }
        }

        lore.add(LORE_PREFIX + ratioFormat + "x faster");
        meta.setLore(lore);
    }


}
