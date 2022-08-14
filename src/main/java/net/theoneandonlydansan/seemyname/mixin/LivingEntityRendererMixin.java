package net.theoneandonlydansan.seemyname.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntityRenderer.class)
public class LivingEntityRendererMixin {
	@Inject(at = @At("HEAD"), method = "hasLabel", cancellable = true)
	private void hasLabel(LivingEntity livingEntity, CallbackInfoReturnable<Boolean> ci) {
		if (livingEntity == MinecraftClient.getInstance().cameraEntity) ci.setReturnValue(MinecraftClient.isHudEnabled() && !livingEntity.isInvisibleTo(MinecraftClient.getInstance().player) && !livingEntity.hasPassengers());
	}
}
