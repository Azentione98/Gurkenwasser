package wurstwasser.gurkenwassertest.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import wurstwasser.gurkenwassertest.messages.messages;

public class cmdBack implements CommandExecutor, @NotNull Listener {
    private final Map<UUID, Location> previousLocations = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            UUID playerUUID = player.getUniqueId();

            if (previousLocations.containsKey(playerUUID)) {
                player.teleport(previousLocations.get(playerUUID));
                player.sendMessage(messages.PREFIX+ "Du wurdest zu deiner vorherigen Position teleportiert!");
            } else {
                player.sendMessage(messages.PREFIX+ "Es gibt keine vorherige Position, zu der du zurückkehren kannst.");
            }
            return true;
        } else {
            sender.sendMessage(messages.PREFIX+ "Dieser Befehl kann nur von einem Spieler ausgeführt werden.");
            return false;
        }
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        Player player = event.getPlayer();
        Location from = event.getFrom();
        Location to = event.getTo();

        // Speichere die vorherige Position, bevor der Spieler teleportiert wird
        if (!from.equals(to)) {
            previousLocations.put(player.getUniqueId(), from);
        }
    }
}
