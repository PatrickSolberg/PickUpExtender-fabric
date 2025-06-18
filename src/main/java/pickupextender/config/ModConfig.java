package pickupextender.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import pickupextender.PickUpExtender;

@Config(name = PickUpExtender.MOD_ID)
public class ModConfig implements ConfigData {
    
    @ConfigEntry.Gui.Tooltip(count = 3)
    @ConfigEntry.BoundedDiscrete(min = 1, max = 20)
    public int pickupRange = 4;
    
    @ConfigEntry.Gui.Tooltip(count = 2)
    public boolean enabled = true;
    
    public static ModConfig getInstance() {
        return AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }
    
    public static void init() {
        AutoConfig.register(ModConfig.class, (definition, configClass) -> new GsonConfigSerializer<>(definition, configClass));
    }
} 