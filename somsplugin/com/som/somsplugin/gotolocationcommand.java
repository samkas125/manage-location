/*    */ package com.som.somsplugin;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.List;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class gotolocationcommand
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/*    */     try
/*    */     {
/* 21 */       if ((sender instanceof Player)) {
/* 22 */         Player player = (Player)sender;
/* 23 */         String locname = args[0];
/*    */ 
/* 25 */         List Locs = Main.plugin.getConfig().getStringList("Locs");
/* 26 */         int index = Locs.indexOf(locname);
/* 27 */         if (index == -1) {
/* 28 */           player.sendMessage(ChatColor.RED + "This is an invalid Location!");
/*    */         }
/*    */         else {
/* 31 */           String strloc = (String)Locs.get(index + 1);
/*    */ 
/* 34 */           strloc = strloc.replace('{', ' ');
/* 35 */           strloc = strloc.replace('}', ' ');
/* 36 */           strloc = strloc.replaceAll("\\s", "");
/* 37 */           System.out.println("strloc : " + strloc);
/* 38 */           String[] arrayloc = strloc.split(",");
/* 39 */           System.out.println("arrayloc is equal to " + arrayloc);
/* 40 */           System.out.println("arrayloc 1 " + arrayloc[1]);
/*    */ 
/* 42 */           World w = Bukkit.getWorld(arrayloc[0].split("=")[1]);
/* 43 */           double x = Double.parseDouble(arrayloc[1].split("=")[1]);
/* 44 */           double y = Double.parseDouble(arrayloc[2].split("=")[1]);
/* 45 */           double z = Double.parseDouble(arrayloc[3].split("=")[1]);
/*    */ 
/* 47 */           Location locloc = new Location(w, x, y, z);
/* 48 */           System.out.println("locloc serialize = " + locloc.serialize());
/* 49 */           boolean teleported = player.teleport(locloc);
/*    */ 
/* 52 */           if (teleported) {
/* 53 */             player.sendMessage(ChatColor.GRAY + "You have been teleported to " + ChatColor.GREEN + locname);
/*    */           }
/*    */           else {
/* 56 */             player.sendMessage(ChatColor.GRAY + "Teleportation to " + ChatColor.GREEN + locname + ChatColor.GRAY + " failed.:(");
/*    */           }
/*    */         }
/*    */ 
/*    */       }
/*    */ 
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 65 */       System.out.println(e.getMessage());
/*    */     }
/*    */ 
/* 68 */     return false;
/*    */   }
/*    */ }

/* Location:           D:\sompo\somsplugin.jar
 * Qualified Name:     com.som.somsplugin.gotolocationcommand
 * JD-Core Version:    0.6.2
 */