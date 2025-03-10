package de.scribble.lp.killtherng.mixin.ktrng.patches;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import de.scribble.lp.killtherng.KillTheRNG;
import net.minecraft.entity.monster.EntityMob;

@Mixin(EntityMob.class)
public class MixinEntityMob {

	/**
	* Whether there will be a cooldown applied when using a shield and getting attacked
	*/
	@Redirect(method = "attackEntityAsMob(Lnet/minecraft/entity/Entity;)Z", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F", ordinal = 0))
	public float redirect_mobPlayerShieldCooldown_1(Random rand) {
		return KillTheRNG.randomness.mobPlayerShieldCooldown.nextFloat();
//		KillTheRNG.randomness.mobPlayerShieldCooldown.nextFloat();
//		return rand.nextFloat();
	}

	/**
	* If a mob should spawn below a certain light level
	*/
	@Redirect(method = "isValidLightLevel()Z", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 0))
	public int redirect_mobSpawningLightLevel_2(Random rand, int i) {
		return KillTheRNG.randomness.mobSpawningLightLevel.nextInt(i);
//		KillTheRNG.randomness.mobSpawningLightLevel.nextInt(i);
//		return rand.nextInt(i);
	}

	/**
	* If a mob should spawn below a certain light level
	*/
	@Redirect(method = "isValidLightLevel()Z", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 1))
	public int redirect_mobSpawningLightLevel_3(Random rand, int i) {
		return KillTheRNG.randomness.mobSpawningLightLevel.nextInt(i);
//		KillTheRNG.randomness.mobSpawningLightLevel.nextInt(i);
//		return rand.nextInt(i);
	}

}
