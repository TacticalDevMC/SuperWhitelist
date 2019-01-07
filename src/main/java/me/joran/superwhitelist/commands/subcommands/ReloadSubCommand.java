package me.joran.superwhitelist.commands.subcommands;

import me.joran.superwhitelist.SuperWhitelist;
import me.joran.superwhitelist.managers.FileManager;
import me.joran.superwhitelist.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ReloadSubCommand {

    private Plugin plugin;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        FileManager.reload(SuperWhitelist.getInstance(), "config.yml");
        FileManager.reload(SuperWhitelist.getInstance(), "messages.yml");
        FileManager.reload(SuperWhitelist.getInstance(), "whitelist/config.yml");
        FileManager.reload(SuperWhitelist.getInstance(), "whitelist/users.yml");

        String filesReloaded = FileManager.get("messages.yml").get("reload-message").toString().replace('&','§').replace("{prefix}", ChatUtils.prefix);

        player.sendMessage(filesReloaded);
        return false;
    }
}
