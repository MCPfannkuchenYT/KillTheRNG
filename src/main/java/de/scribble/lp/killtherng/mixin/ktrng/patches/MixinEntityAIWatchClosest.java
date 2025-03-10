package de.scribble.lp.killtherng.mixin.ktrng.patches;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import de.scribble.lp.killtherng.KillTheRNG;
import net.minecraft.entity.ai.EntityAIWatchClosest;

@Mixin(EntityAIWatchClosest.class)
public class MixinEntityAIWatchClosest {

	/**
	* If the entity should look at another entity
	*/
	@Redirect(method = "shouldExecute()Z", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F", ordinal = 0))
	public float redirect_aiWatchClosestStart_1(Random rand) {
		return KillTheRNG.randomness.aiWatchClosestStart.nextFloat();
//		KillTheRNG.randomness.aiWatchClosestStart.nextFloat();
//		return rand.nextFloat();
	}

	/**
	* How long the entity should look at another entity
	*/
	@Redirect(method = "startExecuting()V", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 0))
	public int redirect_aiWatchClosestDuration_2(Random rand, int i) {
		return KillTheRNG.randomness.aiWatchClosestDuration.nextInt(i);
//		KillTheRNG.randomness.aiWatchClosestDuration.nextInt(i);
//		return rand.nextInt(i);
	}

}
