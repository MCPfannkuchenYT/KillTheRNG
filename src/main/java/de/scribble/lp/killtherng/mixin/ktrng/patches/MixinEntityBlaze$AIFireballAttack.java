package de.scribble.lp.killtherng.mixin.ktrng.patches;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import de.scribble.lp.killtherng.KillTheRNG;

@Mixin(targets="net.minecraft.entity.monster.EntityBlaze$AIFireballAttack")
public class MixinEntityBlaze$AIFireballAttack {

	/**
	* null
	*/
	@Redirect(method = "updateTask()V", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextGaussian()D", ordinal = 0))
	public double redirect_random_898_1(Random rand) {
		return KillTheRNG.randomness.random_898.nextGaussian();
//		KillTheRNG.randomness.random_898.nextGaussian();
//		return rand.nextGaussian();
	}

	/**
	* null
	*/
	@Redirect(method = "updateTask()V", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextGaussian()D", ordinal = 1))
	public double redirect_random_899_2(Random rand) {
		return KillTheRNG.randomness.random_899.nextGaussian();
//		KillTheRNG.randomness.random_899.nextGaussian();
//		return rand.nextGaussian();
	}

}
