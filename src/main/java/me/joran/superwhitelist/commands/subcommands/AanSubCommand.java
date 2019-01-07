package me.joran.superwhitelist.commands.subcommands;

import me.joran.superwhitelist.SuperWhitelist;
import me.joran.superwhitelist.managers.FileManager;
import me.joran.superwhitelist.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AanSubCommand {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        String statusFromWhitelist = FileManager.get("whitelist/config.yml").get("status").toString();
        String whitelistSetToOnMessage = FileManager.get("messages.yml").get("whitelist-gezet-naar-aan").toString().replace('&', '§').replace("{prefix}", ChatUtils.prefix);

        if (statusFromWhitelist.equals("uit") || statusFromWhitelist.equals("Uit")) {
            FileManager.get("whitelist/config.yml").set("status", "Aan");
            FileManager.save(SuperWhitelist.getInstance(), "whitelist/config.yml");
            player.sendMessage(whitelistSetToOnMessage);

        } else if (statusFromWhitelist.equals("aan") || statusFromWhitelist.equals("Aan")) {
            player.sendMessage(FileManager.get("messages.yml").get("whitelist-already-aan").toString().replace('&', '§').replace("{prefix}", ChatUtils.prefix));
        }

        return false;
    }
}
