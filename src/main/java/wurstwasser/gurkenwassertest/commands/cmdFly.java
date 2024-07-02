package wurstwasser.gurkenwassertest.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import wurstwasser.gurkenwassertest.messages.messages;

public class cmdFly implements CommandExecutor
{
    public static final String CMD_FLY = "fly";

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player p = null;
        if (commandSender instanceof Player)
        {
            p = (Player) commandSender;
            boolean isFlying = p.getAllowFlight();

            p.setAllowFlight(!isFlying);  // Flug erlauben oder verbieten
            p.setFlying(!isFlying);  // Spieler in den Flugmodus versetzen oder zurücksetzen
            p.sendMessage(messages.PREFIX + "Flugmodus " + (isFlying ? "deaktiviert" : "aktiviert") + "!");
        }
        return true;
    }
}
