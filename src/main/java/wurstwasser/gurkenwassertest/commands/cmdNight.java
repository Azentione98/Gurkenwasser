package wurstwasser.gurkenwassertest.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import wurstwasser.gurkenwassertest.messages.messages;

public class cmdNight implements CommandExecutor
{

    public static final String CMD_NIGHT = "night";

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings)
    {
        Player p = null;
        if (commandSender instanceof Player)
        {
            p = (Player) commandSender;
        }


        //Command = /night
        if(command.getName().equals(CMD_NIGHT))
        {
            p.getWorld().setTime(1000000);
            p.sendMessage(messages.PREFIX + "Zeit in der Welt (" + p.getWorld().getName() + ") zu Nacht geändert!");
            return true;
        }

        return false;
    }
}
