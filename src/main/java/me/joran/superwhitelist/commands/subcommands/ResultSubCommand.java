package me.joran.superwhitelist.commands.subcommands;

import me.joran.superwhitelist.managers.FileManager;
import me.joran.superwhitelist.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResultSubCommand {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if (args.length == 1) {
            player.sendMessage(ChatUtils.prefix + ChatUtils.format("&cGebruik /superwhitelist result <message, status>"));
            return false;
        }

        if (args[1].equalsIgnoreCase("message")) {
            String whitelistMessage = FileManager.get("whitelist/config.yml").get("message").toString().replaceAll("&", "§");
            String message = FileManager.get("messages.yml").get("resultbericht-message").toString().replace('&', '§').replace("{prefix}", ChatUtils.prefix).replace("{message}", whitelistMessage);

            player.sendMessage(message);
        } else if (args[1].equalsIgnoreCase("status")) {
            String whitelistStatus = FileManager.get("whitelist/config.yml").get("status").toString();
            String status = FileManager.get("messages.yml").get("resultbericht-status").toString().replace('&', '§').replace("{prefix}", ChatUtils.prefix).replace("{status}", whitelistStatus);

            player.sendMessage(status);
        }
        return false;
    }
}
