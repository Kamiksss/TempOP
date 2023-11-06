package me.kamiksss.tempop;

import me.kamiksss.tempop.commands.TempOPCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class TempOP extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("tempop").setExecutor(new TempOPCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
