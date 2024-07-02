package wurstwasser.gurkenwassertest.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import wurstwasser.gurkenwassertest.messages.messages;

public class cmdRain implements CommandExecutor

{
    public static final String CMD_RAIN = "rain";

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player p = null;
        if (commandSender instanceof Player)
        {
            p = (Player) commandSender;
        }

        //Command = /rain
        if(command.getName().equals(CMD_RAIN))
        {
            p.getWorld().setStorm(true);
            p.getWorld().setThundering(true);
            p.getWorld().setWeatherDuration(12000);
            p.sendMessage(messages.PREFIX + "Wetter in der Welt (" + p.getWorld().getName() + ") zu Regen geändert!");
            return true;
        }

        return false;
    }
}
