package wurstwasser.gurkenwassertest.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import wurstwasser.gurkenwassertest.messages.messages;

public class cmdCraft implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            openCrafting(player);
            return true;
        } else {
            sender.sendMessage(messages.PREFIX+ "Dieser Befehl kann nur von einem Spieler ausgeführt werden.");
            return false;
        }
    }

    private void openCrafting(Player player) {
        Inventory craftingInventory = Bukkit.createInventory((InventoryHolder) player, InventoryType.WORKBENCH, "Crafting Table");
        player.openInventory(craftingInventory);
    }
}
