package me.paulvogel.modhelp.utils;

import me.paulvogel.modhelp.ModHelp;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Paul on 23.05.2016.
 */
public class DatabaseUtils {

    private Connection connection = null;
    private String dbprefix = null;

    public DatabaseUtils() {
        this.dbprefix = CacheUtils.getMysqlprefix();
        this.checkTables();
    }

    private void checkTables() {
        if (!this.existsTable(this.dbprefix + "config"))
            this.execute("CREATE TABLE IF NOT EXISTS `" + this.dbprefix + "config` (" +
                    "`id` int(11) NOT NULL," +
                    "  `key` varchar(64) NOT NULL," +
                    "  `value` varchar(128) NOT NULL" +
                    ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;");

    }

    public ResultSet select(final String query) {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // fetch a connection
            if (connection == null)
                connection = DataSource.getInstance().getConnection();

            if (connection != null) {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (connection != null) try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultSet;
    }

    public Boolean execute(final String query) {
        try {
            if (this.connection == null)
                this.connection = DataSource.getInstance().getConnection();
            this.connection.createStatement().execute(query);
            return Boolean.valueOf(true);
        } catch (SQLException e) {
            ModHelp.getInstance().getLogger().severe("Failed to execute query '" + query + "': " + e.getMessage());
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            ModHelp.getInstance().getLogger().severe("Failed to execute query '" + query + "': " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            ModHelp.getInstance().getLogger().severe("Failed to execute query '" + query + "': " + e.getMessage());
            e.printStackTrace();
        }
        return Boolean.valueOf(false);
    }

    public Boolean existsTable(String table) {
        try {
            if (this.connection == null)
                this.connection = DataSource.getInstance().getConnection();
            ResultSet tables = connection.getMetaData().getTables(null, null, table, null);
            return Boolean.valueOf(tables.next());
        } catch (SQLException e) {
            ModHelp.getInstance().getLogger().severe("Failed to check if table '" + table + "' exists: " + e.getMessage());
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            ModHelp.getInstance().getLogger().severe("Failed to check if table '" + table + "' exists: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            ModHelp.getInstance().getLogger().severe("Failed to check if table '" + table + "' exists: " + e.getMessage());
            e.printStackTrace();
        }
        return Boolean.valueOf(false);
    }

    public Boolean existsColumn(String table, String column) {
        try {
            if (this.connection == null)
                this.connection = DataSource.getInstance().getConnection();
            ResultSet colums = connection.getMetaData().getColumns(null, null, table, column);
            return Boolean.valueOf(colums.next());
        } catch (SQLException e) {
            ModHelp.getInstance().getLogger().severe("Failed to check if column '" + column + "' exists: " + e.getMessage());
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            ModHelp.getInstance().getLogger().severe("Failed to check if column '" + column + "' exists: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            ModHelp.getInstance().getLogger().severe("Failed to check if column '" + column + "' exists: " + e.getMessage());
            e.printStackTrace();
        }
        return Boolean.valueOf(false);
    }

}
