package com.som.somsplugin;
import java.io.PrintStream;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
public class gotolocationcommand implements CommandExecutor {
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
     try {
       if ((sender instanceof Player)) {

         Player player = (Player)sender;
         String locname = args[0];
 
         List Locs = Main.plugin.getConfig().getStringList("Locs");
         int index = Locs.indexOf(locname);
         if (index == -1) {
           player.sendMessage(ChatColor.RED + "This is an invalid Location!");
         }
         else {
           String strloc = (String)Locs.get(index + 1);
 
           strloc = strloc.replace('{', ' ');
           strloc = strloc.replace('}', ' ');
           strloc = strloc.replaceAll("\\s", "");
           System.out.println("strloc : " + strloc);
           String[] arrayloc = strloc.split(",");
           System.out.println("arrayloc is equal to " + arrayloc);
           System.out.println("arrayloc 1 " + arrayloc[1]);
 
           World w = Bukkit.getWorld(arrayloc[0].split("=")[1]);
           double x = Double.parseDouble(arrayloc[1].split("=")[1]);
           double y = Double.parseDouble(arrayloc[2].split("=")[1]);
           double z = Double.parseDouble(arrayloc[3].split("=")[1]);
 
           Location locloc = new Location(w, x, y, z);
           System.out.println("locloc serialize = " + locloc.serialize());
           boolean teleported = player.teleport(locloc);
 
           if (teleported) {
             player.sendMessage(ChatColor.GRAY + "You have been teleported to " + ChatColor.GREEN + locname);
           }
           else {
             player.sendMessage(ChatColor.GRAY + "Teleportation to " + ChatColor.GREEN + locname + ChatColor.GRAY + " failed.:(");
           }
         }
 
       }
 
     }
     catch (Exception e) {
       System.out.println(e.getMessage());
     }
     return false;
   }
 }
