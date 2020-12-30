package org.ik26w30.helpstaff.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpStaffCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage("Hi!");
            return true;
        }

        if(args.length == 1){
            String reason = args[0];
            Bukkit
                    .getOnlinePlayers()
                    .stream()
                    .filter(player1 -> player1.hasPermission("helpstaff.msg"))
                    .forEach(player1 -> player1.sendMessage("§c" + sender.getName()+ "§c ha richiesto assistensa per: " + args[0]));
            sender.sendMessage("§4Richiesta §6inviata con successo");
        }else {
            sender.sendMessage("§e§l[§f!§e§l] §eErrore: utilizza /helpstaff <motivazione della richiesta d'aiuto>");
            return true;
        }

        return false;
    }
}
