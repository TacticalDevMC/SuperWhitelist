package me.joran.superwhitelist.commands.subcommands;

import me.joran.superwhitelist.SuperWhitelist;
import me.joran.superwhitelist.managers.FileManager;
import me.joran.superwhitelist.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageSubCommand {


    String whitelistMessage = FileManager.get("whitelist/config.yml").get("message").toString().replaceAll("&", "§");
    String whitelistSetMessage = FileManager.get("messages.yml").get("whitelist-message-set").toString().replace('&', '§').replace("{prefix}", ChatUtils.prefix);

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if (args.length == 1) {
            player.sendMessage(ChatUtils.prefix + ChatUtils.format("&a&lDe whitelist message is op dit moment: " + whitelistMessage));
            return false;
        }

        args[0] = "";
        StringBuilder stringbuilder = new StringBuilder();

        for(String arg : args) {
            stringbuilder.append(arg).append(" ");
        }

        String message = stringbuilder.toString();

        message.replace(" ", "");

        FileManager.get("whitelist/config.yml").set("message", message);
        FileManager.save(SuperWhitelist.getInstance(), "whitelist/config.yml");
        player.sendMessage(whitelistSetMessage);
        return false;
    }
}
