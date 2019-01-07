package me.joran.superwhitelist.events.player;

import me.joran.superwhitelist.managers.FileManager;
import me.joran.superwhitelist.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        String added = FileManager.get("whitelist/users.yml").get("User.Whitelisted").toString().toLowerCase();
        String whitelistMessage = FileManager.get("whitelist/config.yml").get("message").toString().replaceAll("&", "§");
        String statusFromWhitelist = FileManager.get("whitelist/config.yml").get("status").toString();

        if (statusFromWhitelist.equals("Aan")) {
            if (!added.contains(player.getName().toLowerCase())) {
                player.kickPlayer(whitelistMessage);
                for (Player allStaff : Bukkit.getOnlinePlayers()) {
                    String tryToJoinServerMessage = FileManager.get("messages.yml").get("trytojoinserver-message").toString().replace('&', '§').replace("{prefix}", ChatUtils.prefix).replace("{player}", player.getName());

                    allStaff.sendMessage(tryToJoinServerMessage);
                }
            }
        } else if (statusFromWhitelist.equals("Aan")) {
            return;
        }
    }
}
