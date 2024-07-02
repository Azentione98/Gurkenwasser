package wurstwasser.gurkenwassertest.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import wurstwasser.gurkenwassertest.messages.messages;

public class cmdGamemode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0) {
                switch (args[0]) {
                    case "1":
                    case "creative":
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(messages.PREFIX+ "Gamemode auf Kreativ gesetzt!");
                        break;
                    case "0":
                    case "survival":
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(messages.PREFIX+ "Gamemode auf Überleben gesetzt!");
                        break;
                    case "2":
                    case "adventure":
                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage(messages.PREFIX+ "Gamemode auf Abenteuer gesetzt!");
                        break;
                    case "3":
                    case "spectator":
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(messages.PREFIX+ "Gamemode auf Zuschauer gesetzt!");
                        break;
                    default:
                        player.sendMessage(messages.PREFIX+ "Ungültiger Gamemode!");
                        return false;
                }
                return true;
            } else {
                player.sendMessage(messages.PREFIX+ "Bitte gib einen Gamemode an.");
                return false;
            }
        } else {
            sender.sendMessage(messages.PREFIX+ "Dieser Befehl kann nur von einem Spieler ausgeführt werden.");
            return false;
        }
    }
}