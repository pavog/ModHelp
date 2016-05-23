package me.paulvogel.modhelp;

import org.bukkit.plugin.java.JavaPlugin;

public class ModHelp extends JavaPlugin {

  @Override
  public void onEnable() {
    System.out.println("Enabled ModHelp");
  }

  @Override
  public void onDisable() {
    System.out.println("Disabled ModHelp");
  }

}
