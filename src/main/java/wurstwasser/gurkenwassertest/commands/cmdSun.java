package wurstwasser.gurkenwassertest.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import wurstwasser.gurkenwassertest.messages.messages;

public class cmdSun implements CommandExecutor

{
    public static final String CMD_SUN = "sun";

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player p = null;
        if (commandSender instanceof Player)
        {
            p = (Player) commandSender;
        }

        //Command = /sun
        if(command.getName().equals(CMD_SUN))
        {
            p.getWorld().setStorm(false);
            p.getWorld().setThundering(false);
            p.getWorld().setWeatherDuration(0);
            p.sendMessage(messages.PREFIX + "Wetter in der Welt (" + p.getWorld().getName() + ") zu Sonne geändert!");
            return true;
        }

        return false;
    }
}
