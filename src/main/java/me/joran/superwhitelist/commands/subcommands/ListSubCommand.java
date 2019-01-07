package me.joran.superwhitelist.commands.subcommands;

import me.joran.superwhitelist.managers.FileManager;
import me.joran.superwhitelist.utils.ChatUtils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class ListSubCommand {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        List<String> whitelisted = FileManager.get("whitelist/users.yml").getStringList("User.Whitelisted");

        player.sendMessage(ChatUtils.format("&e&lWhitelisted spelers"));
        player.sendMessage(ChatUtils.format("&7&m-------------------"));
        player.sendMessage(ChatUtils.format("&6&l" + StringUtils.join(whitelisted, "&7&l, &6&l")));
        player.sendMessage(ChatUtils.format("&7&m-------------------"));

        return false;
    }
}
