package me.joran.superwhitelist.utils;

import me.joran.superwhitelist.managers.FileManager;
import org.bukkit.ChatColor;

public class ChatUtils {

    public static String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String prefix = FileManager.get("config.yml").get("prefix").toString().replace('&', '§');

//    public static String debug(String debuged) {
//        return Bukkit.getConsoleSender().sendMessage("[DEBUG] Message: " + debuged);
//    }
}
