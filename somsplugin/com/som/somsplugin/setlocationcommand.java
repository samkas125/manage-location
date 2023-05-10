package com.som.somsplugin;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
 
public class setlocationcommand implements CommandExecutor {
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
     try {
       if ((sender instanceof Player)) {
         Player player = (Player)sender;
         String locname = args[0];
 
         Map locmap = player.getLocation().serialize();
         String loc = locmap.toString();
         System.out.println("loc = " + loc);
         List Locs = Main.plugin.getConfig().getStringList("Locs");
         if (Locs.contains(locname)) {
           int index = Locs.indexOf(locname);
           Locs.remove(index);
           Locs.remove(index + 1);
         }
         Locs.add(locname);
         Locs.add(loc);
         Main.plugin.getConfig().set("Locs", Locs);
         Main.plugin.getConfig().save("config.yml");
         Main.plugin.saveConfig();
         player.sendMessage(ChatColor.GRAY + "New location has been set as " + ChatColor.GREEN + args[0]);
       }
     }
     catch (Exception e) {
       System.out.println(e.getMessage());
     }
     return false;
   }
 }