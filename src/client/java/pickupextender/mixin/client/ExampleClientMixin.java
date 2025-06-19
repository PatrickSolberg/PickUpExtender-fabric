package pickupextender.mixin.client;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pickupextender.PickUpExtenderClient;

@Mixin(MinecraftClient.class)
public class KeyBindingMixin {
	
	@Inject(at = @At("HEAD"), method = "tick")
	private void onClientTick(CallbackInfo info) {
		// Handle keybindings every client tick
		PickUpExtenderClient.handleKeybindings();
	}
}