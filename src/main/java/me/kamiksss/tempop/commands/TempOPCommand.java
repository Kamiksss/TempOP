package me.kamiksss.tempop.commands;

import io.papermc.paper.text.PaperComponents;
import me.kamiksss.tempop.TempOP;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class TempOPCommand implements CommandExecutor {

    private TempOP PL;

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if((commandSender instanceof BlockCommandSender)) {
            Bukkit.getLogger().warning("This command isn't acceptable in Command Blocks");
            return true;
        }

        if(strings.length != 2) return false;


        Player target = Bukkit.getPlayer(strings[0]);

            long[] time = {Long.parseLong(strings[1])};


            if(commandSender.isOp()) {

                target.setOp(true);
                if(commandSender instanceof ConsoleCommandSender) commandSender.sendMessage("Made " + target.getDisplayName() + " a server operator for "+time[0] +" seconds");
                target.sendMessage(ChatColor.GREEN + "You are now temporarily an Operator for " + time[0] + " seconds");


                Bukkit.getScheduler().runTaskTimer(JavaPlugin.getPlugin(TempOP.class), () -> {

                    if (time[0] > 0) {
                        time[0]--;
                    } else {
                        target.setOp(false);
                        target.sendMessage(ChatColor.RED + "You are no longer a server Operator");
                        Bukkit.getScheduler().cancelTasks(JavaPlugin.getPlugin(TempOP.class));
                    }
                }, 0L, 20L);
            }else{
                commandSender.sendMessage(ChatColor.DARK_RED + "You don't have permission to use this command ");
            }








        return true;
    }
}
