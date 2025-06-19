package pickupextender.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pickupextender.config.ModConfig;

@Mixin(InGameHud.class)
public class HudMixin {
    
    @Inject(method = "render", at = @At("TAIL"))
    private void renderHud(DrawContext context, Object tickDelta, CallbackInfo ci) {
        try {
            MinecraftClient client = MinecraftClient.getInstance();
            
            if (client == null || client.player == null || client.options.hudHidden) {
                return;
            }
            
            ModConfig config = ModConfig.getInstance();
            
            // Show status in top-right corner
            String status = String.format("PickUp: %s (%d)", 
                config.enabled ? "ON" : "OFF", 
                config.pickupRange);
            
            int x = client.getWindow().getScaledWidth() - 10;
            int y = 10;
            
            // Background
            context.fill(x - 120, y - 2, x + 2, y + 12, 0x80000000);
            
            // Text
            context.drawText(client.textRenderer, 
                Text.literal(status), 
                x - 118, y, 
                config.enabled ? 0x55FF55 : 0xFF5555, 
                true);
        } catch (Exception e) {
            // Silently fail if there's an issue with HUD rendering
        }
    }
} 