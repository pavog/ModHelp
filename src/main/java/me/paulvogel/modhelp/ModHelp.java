package me.paulvogel.modhelp;

import org.bukkit.plugin.java.JavaPlugin;

public class ModHelp extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getLogger().info("Enabled " + this.getDescription().getName() + " version " + this.getDescription().getVersion());
    }

    @Override
    public void onDisable() {
        this.getLogger().info("Disabled " + this.getDescription().getName() + " version " + this.getDescription().getVersion());
    }

}
