package org.ik26w30.staffwarn.Config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.ik26w30.staffwarn.StaffWarn;

import java.io.File;
import java.io.IOException;

public class SetupConfig {
    public SetupConfig instanceconfig;

    private static File file = new File(StaffWarn.getInstance().getDataFolder(), "playerData.yml");
    public static FileConfiguration customFile = (FileConfiguration) YamlConfiguration.loadConfiguration(file);

    public static void setupConfig(){
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                //
            }
        }
    }

    public static FileConfiguration getYaml(){
        return customFile;
    }

    public static void saveFile(){
        try {
            customFile.save(file);
        } catch (IOException e) {
            //
        }
    }

    public static void reloadFile(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }
}
