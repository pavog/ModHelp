package me.paulvogel.modhelp.utils;

import me.paulvogel.modhelp.handlers.FileHandler;

/**
 * Created by Paul on 23.05.2016.
 */
public class CacheUtils {

    private static String mysqlhost, mysqluser, mysqldatabase, mysqlpassword, mysqlprefix;
    private static int mysqlport;

    public static void init() {
        CacheUtils.mysqlhost = FileHandler.getConfig().getString("database.host");
        CacheUtils.mysqluser = FileHandler.getConfig().getString("database.username");
        CacheUtils.mysqlpassword = FileHandler.getConfig().getString("database.password");
        CacheUtils.mysqldatabase = FileHandler.getConfig().getString("database.database");
        CacheUtils.mysqlprefix = FileHandler.getConfig().getString("database.prefix");

        CacheUtils.mysqlport = FileHandler.getConfig().getInt("database.port");
    }

    public static String getMysqlhost() {
        return mysqlhost;
    }

    public static String getMysqluser() {
        return mysqluser;
    }

    public static String getMysqldatabase() {
        return mysqldatabase;
    }

    public static String getMysqlpassword() {
        return mysqlpassword;
    }

    public static String getMysqlprefix() {
        return mysqlprefix;
    }

    public static int getMysqlport() {
        return mysqlport;
    }
}
