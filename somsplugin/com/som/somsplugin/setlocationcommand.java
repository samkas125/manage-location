/*    */ package com.som.somsplugin;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class setlocationcommand
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
/* 27 */         if (Locs.contains(locname)) {
/* 28 */           int index = Locs.indexOf(locname);
/* 29 */           Locs.remove(index);
/* 30 */           Locs.remove(index + 1);
/*    */         }
/* 32 */         Locs.add(locname);
/* 33 */         Locs.add(loc);
/* 34 */         Main.plugin.getConfig().set("Locs", Locs);
/* 35 */         Main.plugin.getConfig().save("config.yml");
/* 36 */         Main.plugin.saveConfig();
/* 37 */         player.sendMessage(ChatColor.GRAY + "New location has been set as " + ChatColor.GREEN + args[0]);
/*    */       }
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 42 */       System.out.println(e.getMessage());
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */ }

/* Location:           D:\sompo\somsplugin.jar
 * Qualified Name:     com.som.somsplugin.setlocationcommand
 * JD-Core Version:    0.6.2
 */