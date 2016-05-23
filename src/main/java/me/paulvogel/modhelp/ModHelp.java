package me.paulvogel.modhelp;

import me.paulvogel.modhelp.handlers.FileHandler;
import me.paulvogel.modhelp.utils.CacheUtils;
import me.paulvogel.modhelp.utils.DataSource;
import org.bukkit.plugin.java.JavaPlugin;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModHelp extends JavaPlugin {

    private static ModHelp instance;

    /**
     * Receive the plugin instance
     * @return
     */
    public static ModHelp getInstance() {
        return ModHelp.instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        FileHandler.init();
        CacheUtils.init();

        this.getLogger().info("==================== BoneCP Connection Speedtest ====================");
        this.getLogger().info("Starttime: " + System.currentTimeMillis());

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // fetch a connection
            connection = DataSource.getInstance().getConnection();

            if (connection != null) {
                statement = connection.createStatement();
                resultSet = statement.executeQuery("select * from mh_config");
                while (resultSet.next())
                    this.getLogger().info("Key: " + resultSet.getString("key") + " Value: " + resultSet.getString("value"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) {e.printStackTrace();}
            if (statement != null) try { statement.close(); } catch (SQLException e) {e.printStackTrace();}
            if (connection != null) try { connection.close(); } catch (SQLException e) {e.printStackTrace();}
        }

        this.getLogger().info("Stoptime: " + System.currentTimeMillis());
        this.getLogger().info("==================== BoneCP Connection Speedtest ====================");


        this.getLogger().info("Enabled " + this.getDescription().getName() + " version " + this.getDescription().getVersion());
    }

    @Override
    public void onDisable() {
        this.getLogger().info("Disabled " + this.getDescription().getName() + " version " + this.getDescription().getVersion());
    }

}
