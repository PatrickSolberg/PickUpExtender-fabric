package pickupextender.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pickupextender.PickUpExtender;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String CONFIG_FILE = "config/pickupextender.json";
    
    public int pickupRange = 4;
    public boolean enabled = true;
    
    private static ModConfig instance;
    
    public static ModConfig getInstance() {
        if (instance == null) {
            instance = load();
        }
        return instance;
    }
    
    private static ModConfig load() {
        File configFile = new File(CONFIG_FILE);
        if (configFile.exists()) {
            try (FileReader reader = new FileReader(configFile)) {
                return GSON.fromJson(reader, ModConfig.class);
            } catch (IOException e) {
                PickUpExtender.LOGGER.error("Failed to load config", e);
            }
        }
        
        // Create default config
        ModConfig config = new ModConfig();
        config.save();
        return config;
    }
    
    public void save() {
        File configFile = new File(CONFIG_FILE);
        configFile.getParentFile().mkdirs();
        
        try (FileWriter writer = new FileWriter(configFile)) {
            GSON.toJson(this, writer);
        } catch (IOException e) {
            PickUpExtender.LOGGER.error("Failed to save config", e);
        }
    }
} 