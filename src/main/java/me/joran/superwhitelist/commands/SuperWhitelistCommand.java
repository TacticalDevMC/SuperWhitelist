package me.joran.superwhitelist.commands;

import me.joran.superwhitelist.commands.subcommands.*;
import me.joran.superwhitelist.managers.FileManager;
import me.joran.superwhitelist.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SuperWhitelistCommand implements CommandExecutor {

    HelpSubCommand help = new HelpSubCommand();
    AddSubCommand add = new AddSubCommand();
    RemoveSubCommand remove = new RemoveSubCommand();
    ListSubCommand list = new ListSubCommand();
    AanSubCommand aan = new AanSubCommand();
    UitSubCommand uit = new UitSubCommand();
    MessageSubCommand message = new MessageSubCommand();
    ResultSubCommand result = new ResultSubCommand();
    ReloadSubCommand reload = new ReloadSubCommand();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if (player.hasPermission("superwhitelist.main")) {

            if (args.length == 0) {
                player.sendMessage(ChatUtils.prefix + ChatUtils.format("&cGebruik /superwhitelist help"));
                return false;
            }

            switch (args[0]) {
                case "add":
                    this.add.onCommand(sender, cmd, label, args);
                    break;
                case "remove":
                    this.remove.onCommand(sender, cmd, label, args);
                    break;
                case "help":
                    this.help.onCommand(sender, cmd, label, args);
                    break;
                case "list":
                    this.list.onCommand(sender, cmd, label, args);
                    break;
                case "aan":
                    this.aan.onCommand(sender, cmd, label, args);
                    break;
                case "uit":
                    this.uit.onCommand(sender, cmd, label, args);
                    break;
                case "message":
                    this.message.onCommand(sender, cmd, label, args);
                    break;
                case "result":
                    this.result.onCommand(sender, cmd, label, args);
                    break;
                case "reload":
                    this.reload.onCommand(sender, cmd, label, args);
                    break;
                default:
                    player.sendMessage(ChatUtils.prefix + ChatUtils.format("&c&lGebruik /superwhitelist help"));
            }
        } else {
            player.sendMessage(FileManager.get("messages.yml").get("geen-permissions-message").toString().replace('&', '§').replace("{prefix}", ChatUtils.prefix));
        }
        return false;
    }
}
