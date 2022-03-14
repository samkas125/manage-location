/*    */ package com.som.somsplugin;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class clearlocationcommand
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/*    */     try
/*    */     {
/* 18 */       if ((sender instanceof Player)) {
/* 19 */         Player player = (Player)sender;
/* 20 */         String locname = args[0];
/*    */ 
/* 23 */         Map locmap = player.getLocation().serialize();
/* 24 */         String loc = locmap.toString();
/* 25 */         System.out.println("loc = " + loc);
/* 26 */         List Locs = Main.plugin.getConfig().getStringList("Locs");
/* 27 */         int index = Locs.indexOf(locname);
/* 28 */         Locs.remove(index);
/* 29 */         Locs.remove(index + 1);
/*    */ 
/* 31 */         Main.plugin.getConfig().set("Locs", Locs);
/* 32 */         Main.plugin.getConfig().save("config.yml");
/* 33 */         Main.plugin.saveConfig();
/*    */       }
/*    */ 
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 39 */       System.out.println(e.getMessage());
/*    */     }
/* 41 */     return false;
/*    */   }
/*    */ }

/* Location:           D:\sompo\somsplugin.jar
 * Qualified Name:     com.som.somsplugin.clearlocationcommand
 * JD-Core Version:    0.6.2
 */