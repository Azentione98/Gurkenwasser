package wurstwasser.gurkenwassertest.startup;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import wurstwasser.gurkenwassertest.commands.*;
import wurstwasser.gurkenwassertest.messages.messages;

public final class Gurkenwasser extends JavaPlugin {

    @Override
    public void onEnable() {

        //Plugin activated Console Notification
        for(int i = 0; i < 10; i++)
        {
            Bukkit.getLogger().info(messages.PREFIX + "Plugin activated!");
        }

        cmdDay cmdDay = new cmdDay();
        this.getCommand(cmdDay.CMD_DAY).setExecutor(cmdDay);

        cmdNight cmdNight = new cmdNight();
        this.getCommand(cmdNight.CMD_NIGHT).setExecutor(cmdNight);

        cmdSun cmdSun = new cmdSun();
        this.getCommand(cmdSun.CMD_SUN).setExecutor(cmdSun);

        cmdRain cmdRain = new cmdRain();
        this.getCommand(cmdRain.CMD_RAIN).setExecutor(cmdRain);

        cmdFly cmdFly = new cmdFly();
        this.getCommand(cmdFly.CMD_FLY).setExecutor(cmdFly);

        cmdEnderchest cmdEnderchest = new cmdEnderchest();
        this.getCommand(cmdEnderchest.CMD_ENDERCHEST).setExecutor(cmdEnderchest);

        this.getCommand("gm").setExecutor(new cmdGamemode());

        this.getCommand("anvil").setExecutor(new cmdAnvil());

        cmdTimeWeatherMenu cmdTimeWeatherMenu = new cmdTimeWeatherMenu();
        this.getCommand(cmdTimeWeatherMenu.CMD_MENU).setExecutor(cmdTimeWeatherMenu);
        getServer().getPluginManager().registerEvents(new cmdTimeWeatherMenu(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
