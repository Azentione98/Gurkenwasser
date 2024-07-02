package wurstwasser.gurkenwassertest.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class cmdAnvil implements CommandExecutor
{


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            openAnvil(player);
            return true;
        } else {
            sender.sendMessage("Dieser Befehl kann nur von einem Spieler ausgeführt werden.");
            return false;
        }
    }

    private void openAnvil(Player player) {
        Inventory anvilInventory = Bukkit.createInventory((InventoryHolder) player, InventoryType.ANVIL, "Anvil");
        player.openInventory(anvilInventory);
    }
}