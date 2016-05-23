package me.paulvogel.modhelp.handlers;

import me.paulvogel.modhelp.ModHelp;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

/**
 * Created by Paul on 23.05.2016.
 */

public class FileHandler {

    private static File configFile;
    private static File messagesFile;
    private static YamlConfiguration config;
    private static YamlConfiguration messages;

    /**
     * Set files and some variables
     */
    public static void init() {
        checkForFiles();
    }

    /**
     * Set the configfile & messagesfile and load the files
     */
    private static void checkForFiles() {
        FileHandler.configFile = new File(ModHelp.getInstance().getDataFolder(), "config.yml");
        FileHandler.messagesFile = new File(ModHelp.getInstance().getDataFolder(), "messages.yml");

        if (!FileHandler.configFile.exists()) {
            ModHelp.getInstance().getLogger().info("No configfile found, creating...");
            setConfigs();
        }
        if (!FileHandler.messagesFile.exists()) {
            ModHelp.getInstance().getLogger().warning("No messagesfile found, creating...");
            setConfigs();
        }
        loadFiles();
    }

    /**
     * Save all files
     */
    public static void saveFiles() {
        try {
            FileHandler.config.save(FileHandler.configFile);
            FileHandler.messages.save(FileHandler.messagesFile);
        } catch (Exception e) {
            ModHelp.getInstance().getLogger().severe("Could not save configfiles!");
            e.printStackTrace();
        }
    }

    /**
     * Load all files and set the file variables
     */
    public static void loadFiles() {
        try {
            if (FileHandler.config == null)
                FileHandler.configFile = new File(ModHelp.getInstance().getDataFolder(), "config.yml");

            FileHandler.config = YamlConfiguration.loadConfiguration(FileHandler.configFile);

            if (FileHandler.messages == null)
                FileHandler.messagesFile = new File(ModHelp.getInstance().getDataFolder(), "messages.yml");

            FileHandler.messages = YamlConfiguration.loadConfiguration(FileHandler.messagesFile);
        } catch (Exception e) {
            ModHelp.getInstance().getLogger().warning("Could not load configfiles!");
            e.printStackTrace();
        }
    }

    /**
     * Set the file variables
     */
    public static void setConfigs() {
        FileHandler.config = YamlConfiguration.loadConfiguration(FileHandler.configFile);
        if (!FileHandler.configFile.exists())
            ModHelp.getInstance().saveResource("config.yml", false);


        FileHandler.messages = YamlConfiguration.loadConfiguration(FileHandler.messagesFile);
        if (!FileHandler.messagesFile.exists())
            ModHelp.getInstance().saveResource("messages.yml", false);

    }

    public static YamlConfiguration getConfig() {
        return config;
    }

    public static YamlConfiguration getMessages() {
        return messages;
    }
}
