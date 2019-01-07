package me.joran.superwhitelist.events.inventory;

import me.joran.superwhitelist.SuperWhitelist;
import me.joran.superwhitelist.commands.subcommands.MessageSubCommand;
import me.joran.superwhitelist.managers.FileManager;
import me.joran.superwhitelist.utils.ChatUtils;
import me.joran.superwhitelist.utils.ISGen;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class AnvilPlayerInventoryClickEvent implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String title = event.getClickedInventory().getTitle();

        event.setCancelled(true);

        Bukkit.getConsoleSender().sendMessage("[DEBUG] TEST");

//        String signwithdisplayname = event.getClickedInventory().getItem(event.getSlot()).getItemMeta().getDisplayName();

//        if (event.getClickedInventory().getItem(event.getSlot()).isSimilar(new ISGen(Material.SIGN).getItem().getItemMeta().getLore().equals(new MessageSubCommand().loree)) {
        if(event.getClickedInventory().getItem(0).getType().getData().getName().equals("test")){
            Bukkit.getConsoleSender().sendMessage("[DEBUG] TEST2");
            if (event.getClickedInventory().getItem(2).getType().equals(new ISGen(Material.SIGN).getItem().getItemMeta().getDisplayName())) {
                Bukkit.getConsoleSender().sendMessage("[DEBUG] TEST3");
                FileManager.get("whitelist/config.yml").set("message", event.getClickedInventory().getItem(2).getItemMeta().getDisplayName());
                Bukkit.getConsoleSender().sendMessage("[DEBUG] TEST4");
                FileManager.save(SuperWhitelist.getInstance(), "whitelist/config.yml");
            }
        }
//
//        Inventory inv = event.getInventory();
//
//        if(inv instanceof AnvilInventory) {
//            InventoryView view = event.getView();
//            int rawSlot = event.getRawSlot();
//
//            if (rawSlot == view.convertSlot(rawSlot)) {
//
//            }
//            if (rawSlot == 2) {
//
//                ItemStack item = event.getCurrentItem();
//
//                if (item != null) {
//                    ItemMeta meta = item.getItemMeta();
//
//                    if (meta != null) {
//                        if (meta.hasDisplayName()) {
//                            String displayName = meta.getDisplayName();
//                            FileManager.get("whitelist/config.yml").set("message", displayName);
//                            FileManager.save(SuperWhitelist.getInstance(), "whitelist/config.yml");
//                        }
//                    }
//                }
//            }
//        }
    }
}
