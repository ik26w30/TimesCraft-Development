package org.ik26w30.staffwarn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.ik26w30.staffwarn.Commands.StaffWarnCommands;
import org.ik26w30.staffwarn.Config.SetupConfig;

public class StaffWarn extends JavaPlugin {
    private static StaffWarn instance;

    @Override
    public void onLoad() {
        instance = this;
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerCommands();
        startup();
        customConfigSetup();
    }

    private void customConfigSetup() {
        SetupConfig.setupConfig();
        SetupConfig.customFile.addDefault("Warned", "");
        SetupConfig.customFile.options().copyDefaults(true);
        SetupConfig.saveFile();
    }

    private void startup() {
        getLogger().info("Plugin loaded...");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Plugin developed by @ik26w30");
    }

    private void registerCommands() {
        this.getCommand("staffwarn").setExecutor(new StaffWarnCommands());
    }

    public static StaffWarn getInstance(){
        return instance;
    }

}
