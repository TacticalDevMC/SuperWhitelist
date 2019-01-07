package me.joran.superwhitelist.commands.subcommands;

import me.joran.superwhitelist.SuperWhitelist;
import me.joran.superwhitelist.managers.FileManager;
import me.joran.superwhitelist.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

@SuppressWarnings("ALL")
public class AddSubCommand {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if (!(Bukkit.getServer().getConsoleSender() instanceof Player)) {

            if (args.length == 1) {
                Bukkit.getConsoleSender().sendMessage(ChatUtils.prefix + ChatUtils.format("&cGebruik /superwhitelist add <player>"));
                return false;
            }

            Player onlineTarget = Bukkit.getServer().getPlayer(args[1]);
            OfflinePlayer offlineTarget = Bukkit.getOfflinePlayer(args[1]);


            List<String> whitelist2 = FileManager.get("whitelist/users.yml").getStringList("User.Whitelisted");
            whitelist2.add(args[1].toLowerCase());

            String added = FileManager.get("whitelist/users.yml").get("User.Whitelisted").toString().toLowerCase();

            if (!added.contains(args[1])) {

                FileManager.get("whitelist/users.yml").set("User.Whitelisted", whitelist2);
                FileManager.save(SuperWhitelist.getInstance(), "whitelist/users.yml");

                String addedTo = FileManager.get("messages.yml").get("added-to-whitelist").toString().replace('&', '§').replace("{prefix}", ChatUtils.prefix).replace("{player}", args[1]);

                Bukkit.getConsoleSender().sendMessage(addedTo);
            } else {
                String alreadyAdded = FileManager.get("messages.yml").get("al-in-whitelist").toString().replace('&', '§').replace("{prefix}", ChatUtils.prefix).replace("{player}", args[1]);
                Bukkit.getConsoleSender().sendMessage(alreadyAdded);
                return false;
            }
        } else {
            if (args.length == 1) {
                player.sendMessage(ChatUtils.prefix + ChatUtils.format("&cGebruik /superwhitelist add <player>"));
                return false;
            }

            Player onlineTarget = Bukkit.getServer().getPlayer(args[1]);
            OfflinePlayer offlineTarget = Bukkit.getOfflinePlayer(args[1]);


            List<String> whitelist2 = FileManager.get("whitelist/users.yml").getStringList("User.Whitelisted");
            whitelist2.add(args[1].toLowerCase());

            String added = FileManager.get("whitelist/users.yml").get("User.Whitelisted").toString().toLowerCase();

            if (!added.contains(args[1])) {

                FileManager.get("whitelist/users.yml").set("User.Whitelisted", whitelist2);
                FileManager.save(SuperWhitelist.getInstance(), "whitelist/users.yml");

                String addedTo = FileManager.get("messages.yml").get("added-to-whitelist").toString().replace('&', '§').replace("{prefix}", ChatUtils.prefix).replace("{player}", args[1]);

                player.sendMessage(addedTo);
            } else {
                String alreadyAdded = FileManager.get("messages.yml").get("al-in-whitelist").toString().replace('&', '§').replace("{prefix}", ChatUtils.prefix).replace("{player}", args[1]);
                player.sendMessage(alreadyAdded);
                return false;
            }
        }
        return false;
    }
}
