package de.scribble.lp.killtherng.mixin.ktrng.patches;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import de.scribble.lp.killtherng.KillTheRNG;
import net.minecraft.block.BlockTripWireHook;

@Mixin(BlockTripWireHook.class)
public class MixinBlockTripWireHook {

	/**
	* null
	*/
	@Redirect(method = "playSound(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;ZZZZ)V", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F", ordinal = 0))
	public float redirect_random_510_1(Random rand) {
		return KillTheRNG.randomness.random_510.nextFloat();
//		KillTheRNG.randomness.random_510.nextFloat();
//		return rand.nextFloat();
	}

}
