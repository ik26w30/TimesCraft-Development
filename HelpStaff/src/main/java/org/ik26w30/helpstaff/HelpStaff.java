package org.ik26w30.helpstaff;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.ik26w30.helpstaff.Commands.HelpListCommand;
import org.ik26w30.helpstaff.Commands.HelpStaffCommand;

public final class HelpStaff extends JavaPlugin {
    private static HelpStaff instance;

    @Override
    public void onLoad() {
        instance = this;
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        registerCommands();
        startup();
    }

    private void startup() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Plugin developed by @ik26w30");
    }

    private void registerCommands() {
        this.getCommand("helpstaff").setExecutor(new HelpStaffCommand());
        this.getCommand("helplist").setExecutor(new HelpListCommand());
    }

    public static HelpStaff getInstance(){
        return instance;
    }

}
