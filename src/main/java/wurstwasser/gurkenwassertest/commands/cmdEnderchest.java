package wurstwasser.gurkenwassertest.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import wurstwasser.gurkenwassertest.messages.messages;



public class cmdEnderchest implements CommandExecutor

{
    public static final String CMD_ENDERCHEST = "enderchest";

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = null;
        if (commandSender instanceof Player)
        {
            p = (Player) commandSender;
            p.openInventory(p.getEnderChest());
            p.sendMessage(messages.PREFIX + "Enderchest geöffnet!");
            return true;
        } else {

            return false;
        }
    }
}
