package pickupextender.mixin.client;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pickupextender.PickUpExtenderClient;
import pickupextender.config.ModConfig;

import java.util.List;

@Mixin(ItemEntity.class)
public abstract class PickupRangeMixin extends Entity {
    @Shadow public abstract void onPlayerCollision(PlayerEntity player);

    public PickupRangeMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("TAIL"), method = "tick")
    private void tick(CallbackInfo ci) {
        // Handle keybindings
        PickUpExtenderClient.handleKeybindings();
        
        ModConfig config = ModConfig.getInstance();
        
        if (!config.enabled) {
            return; // Use vanilla behavior
        }
        
        int radius = Math.max(1, config.pickupRange);
        Vec3d itemPos = this.getPos();
        BlockPos blockPos = new BlockPos((int) itemPos.getX(), (int) itemPos.getY(), (int) itemPos.getZ());
        Box box = new Box(blockPos).expand(radius);
        List<PlayerEntity> players = this.getWorld().getNonSpectatingEntities(PlayerEntity.class, box);

        if (!players.isEmpty()) {
            this.onPlayerCollision(players.get(0));
        }
    }
} 