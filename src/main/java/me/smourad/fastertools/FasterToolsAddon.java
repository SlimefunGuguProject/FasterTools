package me.smourad.fastertools;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import me.smourad.fastertools.mining.MinerWatcher;
import me.smourad.fastertools.mining.MiningListener;
import me.smourad.fastertools.resources.FasterItemSetup;
import me.smourad.fastertools.updater.LoreUpdaterTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class FasterToolsAddon extends JavaPlugin implements SlimefunAddon {

    public static FasterToolsAddon INSTANCE; { INSTANCE = this; }

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config config = new Config(this);

        if (config.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
            // TODO FOR FUN
        }

        FasterItemSetup.setup();
        getServer().getScheduler().runTaskTimerAsynchronously(this, new LoreUpdaterTask(), 0L,
                config.getInt("options.lore-update-interval") * 20L);

        Arrays.asList(
                new MiningListener(),
                new MinerWatcher()
        ).forEach(listener -> Bukkit.getPluginManager().registerEvents(listener, this));
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        // TODO
        return null;
    }

    @Override
    @Nonnull
    public JavaPlugin getJavaPlugin() {
        return this;
    }

}
