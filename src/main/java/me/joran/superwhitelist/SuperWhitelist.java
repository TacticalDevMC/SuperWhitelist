package me.joran.superwhitelist;

import me.joran.superwhitelist.commands.SuperWhitelistCommand;
import me.joran.superwhitelist.events.player.JoinEvent;
import me.joran.superwhitelist.managers.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SuperWhitelist extends JavaPlugin {

    private static SuperWhitelist instance;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage("De SuperWhitelist plugin is aan. Author " + this.getDescription().getAuthors() + " V" + this.getDescription().getVersion());

        registerFiles();
        registerCommands();
        registerEvents(getServer().getPluginManager());

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("De SuperWhitelist plugin is uit. Author " + this.getDescription().getAuthors() + " V" + this.getDescription().getVersion());
    }

    private void registerFiles() {
        // default
        FileManager.load(this, "config.yml");
        FileManager.load(this, "messages.yml");

        // whitelist
        FileManager.load(this, "whitelist/config.yml");
        FileManager.load(this, "whitelist/users.yml");
    }

    private void registerCommands() {
        getCommand("superwhitelist").setExecutor(new SuperWhitelistCommand());
    }

    private void registerEvents(PluginManager pm) {
//        pm.registerEvents(new AnvilPlayerInventoryClickEvent(), this);
        pm.registerEvents(new JoinEvent(), this);
    }

    public static SuperWhitelist getInstance() {
        return instance;
    }
}
