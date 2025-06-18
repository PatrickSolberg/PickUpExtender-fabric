package pickupextender;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import pickupextender.config.ModConfig;

public class PickUpExtenderClient implements ClientModInitializer, ModMenuApi {
	
	private static KeyBinding toggleKey;
	private static KeyBinding increaseRangeKey;
	private static KeyBinding decreaseRangeKey;
	
	@Override
	public void onInitializeClient() {
		// Register keybindings
		toggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
			"key.pickupextender.toggle",
			InputUtil.Type.KEYSYM,
			GLFW.GLFW_KEY_P,
			"category.pickupextender.general"
		));
		
		increaseRangeKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
			"key.pickupextender.increase_range",
			InputUtil.Type.KEYSYM,
			GLFW.GLFW_KEY_RIGHT_BRACKET,
			"category.pickupextender.general"
		));
		
		decreaseRangeKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
			"key.pickupextender.decrease_range",
			InputUtil.Type.KEYSYM,
			GLFW.GLFW_KEY_LEFT_BRACKET,
			"category.pickupextender.general"
		));
	}
	
	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return parent -> AutoConfig.getConfigScreen(ModConfig.class, parent).get();
	}
	
	// Method to handle keybinding logic (called from mixin)
	public static void handleKeybindings() {
		ModConfig config = ModConfig.getInstance();
		
		if (toggleKey.wasPressed()) {
			config.enabled = !config.enabled;
			AutoConfig.getConfigHolder(ModConfig.class).save();
			
			// Show feedback message
			if (net.minecraft.client.MinecraftClient.getInstance().player != null) {
				net.minecraft.client.MinecraftClient.getInstance().player.sendMessage(
					Text.literal("§6[PickUp Extender] §f" + (config.enabled ? "Enabled" : "Disabled")),
					false
				);
			}
		}
		
		if (increaseRangeKey.wasPressed() && config.pickupRange < 20) {
			config.pickupRange++;
			AutoConfig.getConfigHolder(ModConfig.class).save();
			showRangeMessage(config.pickupRange);
		}
		
		if (decreaseRangeKey.wasPressed() && config.pickupRange > 1) {
			config.pickupRange--;
			AutoConfig.getConfigHolder(ModConfig.class).save();
			showRangeMessage(config.pickupRange);
		}
	}
	
	private static void showRangeMessage(int range) {
		if (net.minecraft.client.MinecraftClient.getInstance().player != null) {
			net.minecraft.client.MinecraftClient.getInstance().player.sendMessage(
				Text.literal("§6[PickUp Extender] §fPickup range: §e" + range + " blocks"),
				false
			);
		}
	}
}