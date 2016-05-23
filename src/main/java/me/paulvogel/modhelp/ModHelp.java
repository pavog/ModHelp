package me.paulvogel.modhelp;

import me.paulvogel.modhelp.handlers.FileHandler;
import me.paulvogel.modhelp.utils.CacheUtils;
import me.paulvogel.modhelp.utils.DatabaseUtils;
import org.bukkit.plugin.java.JavaPlugin;

public class ModHelp extends JavaPlugin {

    private static ModHelp instance;
    private static DatabaseUtils databaseUtils;

    /**
     * Receive the plugin instance
     *
     * @return
     */
    public static ModHelp getInstance() {
        return ModHelp.instance;
    }


    /**
     * Receive the plugins database utils to access the database and execute queries
     * @return
     */
    public static DatabaseUtils getDatabaseUtils() {
        return ModHelp.databaseUtils;
    }

    @Override
    public void onEnable() {
        instance = this;

        FileHandler.init();
        CacheUtils.init();

        databaseUtils = new DatabaseUtils();

    }

    @Override
    public void onDisable() {
    }

}
