package org.ik26w30.staffwarn.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.ik26w30.staffwarn.Config.SetupConfig;
import org.ik26w30.staffwarn.StaffWarn;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StaffWarnCommands implements CommandExecutor {
    private static FileConfiguration config = SetupConfig.getYaml();
    private static List<String> arrayList;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Hi");
            return true;
        }

        if(!(sender.hasPermission("staffwarn.use"))){
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(StaffWarn.getInstance().getConfig().getString("lang.no-perms-msg"))));
            return true;
        }

        if(args.length == 2){
            Player target = Bukkit.getPlayer(args[0]);
            arrayList = config.getStringList("Warned");
            if(target != null){
                if(target != sender){
                    String reason = args[1];
                    if(reason != null){
                        arrayList.add(args[0]);
                        config.set("Warned", arrayList);
                        config.set(args[0] + ".name", args[0]);
                        config.set(args[0] + ".reason", args[1]);
                        SetupConfig.saveFile();
                        sender.sendMessage("DO!");
                    }
                }else {
                  sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(StaffWarn.getInstance().getConfig().getString("lang.staff-warn-yourself"))));
                   return true;
                }
            }else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(StaffWarn.getInstance().getConfig().getString("lang.target-not-found"))));
                return true;
            }
        }else{
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(StaffWarn.getInstance().getConfig().getString("lang.args-wronged"))));
            return true;
        }
        return false;
    }
}
