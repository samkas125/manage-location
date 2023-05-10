package com.som.somsplugin;

import java.io.PrintStream;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
 
 public class Main extends JavaPlugin implements Listener {
   public static Main plugin;
 
   public void onEnable() {
     System.out.println("PLUGIN HAS BEEN ENABLED!");
     getConfig().options().copyDefaults();
     saveDefaultConfig();
     getCommand("setloc").setExecutor(new setlocationcommand());
     getCommand("gotoloc").setExecutor(new gotolocationcommand());
     getCommand("clearloc").setExecutor(new clearlocationcommand());
     plugin = this;
   }
 
   public void onDisable() {
     System.out.println("PLUGIN HAS BEEN DISABLED!");
   }
 }