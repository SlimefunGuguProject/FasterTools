package me.smourad.fastertools;

import me.smourad.fastertools.mining.MiningListener;
import me.smourad.fastertools.mining.MinerWatcher;
import me.smourad.fastertools.resources.FasterItemSetup;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;

import java.util.Arrays;

public class FasterToolsAddon extends JavaPlugin implements SlimefunAddon {

    public static FasterToolsAddon INSTANCE; { INSTANCE = this; }

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }

        FasterItemSetup.setup();

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
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

}
