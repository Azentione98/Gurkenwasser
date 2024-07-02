package wurstwasser.gurkenwassertest.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import wurstwasser.gurkenwassertest.messages.messages;

public class cmdRepair implements CommandExecutor
{
    public static final String CMD_REPAIR_HAND = "repair";
    public static final String CMD_REPAIR_ALL = "repairall";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase(CMD_REPAIR_HAND)) {
                repairHand(player);
            } else if (command.getName().equalsIgnoreCase(CMD_REPAIR_ALL)) {
                repairAll(player);
            }
            return true;
        } else {
            sender.sendMessage(messages.PREFIX+ "Dieser Befehl kann nur von einem Spieler ausgeführt werden.");
            return false;
        }
    }

    private void repairHand(Player player) {
        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        if (itemInHand != null && itemInHand.getType().isItem()) {
            itemInHand.setDurability((short) 0);
            player.sendMessage(messages.PREFIX+ "Der Gegenstand in deiner Hand wurde repariert!");
        } else {
            player.sendMessage(messages.PREFIX+ "Du hältst keinen reparierbaren Gegenstand in der Hand.");
        }
    }

    private void repairAll(Player player) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (item != null && item.getType().isItem()) {
                item.setDurability((short) 0);
            }
        }
        player.sendMessage(messages.PREFIX+ "Alle Gegenstände in deinem Inventar wurden repariert!");
    }
}