package me.joran.superwhitelist.commands.subcommands;

import me.joran.superwhitelist.SuperWhitelist;
import me.joran.superwhitelist.managers.FileManager;
import me.joran.superwhitelist.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UitSubCommand {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        String statusFromWhitelist = FileManager.get("whitelist/config.yml").get("status").toString();
        String whitelistSetToOffMessage = FileManager.get("messages.yml").get("whitelist-gezet-naar-uit").toString().replace('&', '§').replace("{prefix}", ChatUtils.prefix);

        if (statusFromWhitelist.equals("aan") || statusFromWhitelist.equals("Aan")) {
            FileManager.get("whitelist/config.yml").set("status", "Uit");
            FileManager.save(SuperWhitelist.getInstance(), "whitelist/config.yml");
            player.sendMessage(whitelistSetToOffMessage);

        } else if (statusFromWhitelist.equals("uit") || statusFromWhitelist.equals("Uit")) {
            player.sendMessage(FileManager.get("messages.yml").get("whitelist-already-uit").toString().replace('&', '§').replace("{prefix}", ChatUtils.prefix));
        }

        return false;
    }
}
