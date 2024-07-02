package wurstwasser.gurkenwassertest.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import wurstwasser.gurkenwassertest.messages.messages;

public class cmdTimeWeatherMenu implements Listener, CommandExecutor {

    public static final String CMD_MENU = "menu";

    public static void main(String[] args) {
        // Hier könntest du den Listener manuell registrieren, wenn nicht als Plugin verwendet
        Bukkit.getServer().getPluginManager().registerEvents(new cmdTimeWeatherMenu(),null); /* hier den Plugin-Handler oder null */
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(messages.PREFIX + "Menu")) {
            event.setCancelled(true);

            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem == null || !clickedItem.hasItemMeta()) {
                return;
            }

            ItemMeta meta = clickedItem.getItemMeta();
            if (meta == null || meta.getDisplayName() == null) {
                return;
            }

            switch (meta.getDisplayName()) {
                case "Tag":
                    player.performCommand(cmdDay.CMD_DAY);
                    break;
                case "Nacht":
                    player.performCommand(cmdNight.CMD_NIGHT);
                    break;
                case "Regen":
                    player.performCommand(cmdRain.CMD_RAIN);
                    break;
                case "Sonne":
                    player.performCommand(cmdSun.CMD_SUN);
                    break;
            }

            player.closeInventory();
        }
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase(CMD_MENU)) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                openMenu(player);
                return true;
            } else {
                sender.sendMessage("Dieser Befehl kann nur von einem Spieler ausgeführt werden.");
                return true;
            }
        }
        return false;
    }

    private void openMenu(Player player) {
        Inventory menu = Bukkit.createInventory(null, 27, messages.PREFIX + "Menu");

        // Tag Item
        ItemStack tagItem = new ItemStack(Material.YELLOW_CONCRETE);
        ItemMeta tagMeta = tagItem.getItemMeta();
        tagMeta.setDisplayName("§rTag");
        tagItem.setItemMeta(tagMeta);

        // Nacht Item
        ItemStack nachtItem = new ItemStack(Material.BLACK_CONCRETE);
        ItemMeta nachtMeta = nachtItem.getItemMeta();
        nachtMeta.setDisplayName("§rNacht");
        nachtItem.setItemMeta(nachtMeta);

        // Regen Item
        ItemStack regenItem = new ItemStack(Material.WATER_BUCKET);
        ItemMeta regenMeta = regenItem.getItemMeta();
        regenMeta.setDisplayName("§rRegen");
        regenItem.setItemMeta(regenMeta);

        // Sonne Item
        ItemStack sonneItem = new ItemStack(Material.SUNFLOWER);
        ItemMeta sonneMeta = sonneItem.getItemMeta();
        sonneMeta.setDisplayName("§rSonne");
        sonneItem.setItemMeta(sonneMeta);

        ItemStack glasItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

        menu.setItem(10, tagItem);    // Setze Tag Item in Slot 3 (Index 2, da Arrays bei 0 beginnen)
        menu.setItem(11, nachtItem);  // Setze Nacht Item in Slot 5 (Index 4)
        menu.setItem(15, regenItem);  // Setze Regen Item in Slot 7 (Index 6)
        menu.setItem(16, sonneItem);  // Setze Sonne Item in Slot 9 (Index 8)

        menu.setItem(0, glasItem);
        menu.setItem(1, glasItem);
        menu.setItem(2, glasItem);
        menu.setItem(3, glasItem);
        menu.setItem(4, glasItem);
        menu.setItem(5, glasItem);
        menu.setItem(6, glasItem);
        menu.setItem(7, glasItem);
        menu.setItem(8, glasItem);

        menu.setItem(9, glasItem);
        menu.setItem(12, glasItem);
        menu.setItem(13, glasItem);
        menu.setItem(14, glasItem);
        menu.setItem(17, glasItem);

        menu.setItem(18, glasItem);
        menu.setItem(19, glasItem);
        menu.setItem(20, glasItem);
        menu.setItem(21, glasItem);
        menu.setItem(22, glasItem);
        menu.setItem(23, glasItem);
        menu.setItem(24, glasItem);
        menu.setItem(25, glasItem);
        menu.setItem(26, glasItem);



        player.openInventory(menu);
    }
}