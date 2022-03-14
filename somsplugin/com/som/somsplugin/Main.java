/*    */ package com.som.somsplugin;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import org.bukkit.command.PluginCommand;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.configuration.file.FileConfigurationOptions;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public class Main extends JavaPlugin
/*    */   implements Listener
/*    */ {
/*    */   public static Main plugin;
/*    */ 
/*    */   public void onEnable()
/*    */   {
/* 12 */     System.out.println("PLUGIN HAS BEEN ENABLED!");
/* 13 */     getConfig().options().copyDefaults();
/* 14 */     saveDefaultConfig();
/* 15 */     getCommand("setloc").setExecutor(new setlocationcommand());
/* 16 */     getCommand("gotoloc").setExecutor(new gotolocationcommand());
/* 17 */     getCommand("clearloc").setExecutor(new clearlocationcommand());
/* 18 */     plugin = this;
/*    */   }
/*    */ 
/*    */   public void onDisable()
/*    */   {
/* 25 */     System.out.println("PLUGIN HAS BEEN DISABLED!");
/*    */   }
/*    */ }

/* Location:           D:\sompo\somsplugin.jar
 * Qualified Name:     com.som.somsplugin.Main
 * JD-Core Version:    0.6.2
 */