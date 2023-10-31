package me.nova.freezetag;

import me.nova.freezetag.Commands.StartCommand;
import me.nova.freezetag.Controllers.GameController;
import me.nova.freezetag.Events.OnPlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

public final class FreezeTag extends JavaPlugin {

    public static final int INITIAL_SIZE = 200;
    public static final int X_MIN = -5000, X_MAX = 5000, Z_MIN = -5000, Z_MAX = 5000;

    public static GameController gc;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);

        getCommand("start").setExecutor(new StartCommand());

        gc = new GameController();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
