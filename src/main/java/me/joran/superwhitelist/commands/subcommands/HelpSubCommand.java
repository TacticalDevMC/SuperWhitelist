package me.joran.superwhitelist.commands.subcommands;

import me.joran.superwhitelist.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpSubCommand {


    public void onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        player.sendMessage("");
        player.sendMessage("");
        player.sendMessage(ChatUtils.format("&7---------&3&lHELP &8(1/1)&7-------------"));
        player.sendMessage(ChatUtils.format("&7Aliases: [spwh, superw]"));
        player.sendMessage(ChatUtils.format("&7- &c/superwhitelist help : &6&lKrijg deze lijst."));
            player.sendMessage(ChatUtils.format("&7- &c/superwhitelist <add, remove, list, message, aan, uit, reload, result> <value> : &6&lVerander de whitelist."));
        player.sendMessage(ChatUtils.format("&7---------&3&lHELP&7-------------"));

    }
}
