package de.scribble.lp.killtherng.mixin.ktrng.patches;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import de.scribble.lp.killtherng.KillTheRNG;
import net.minecraft.item.ItemMonsterPlacer;

@Mixin(ItemMonsterPlacer.class)
public class MixinItemMonsterPlacer {

	/**
	* null
	*/
	@Redirect(method = "spawnCreature(Lnet/minecraft/world/World;Lnet/minecraft/util/ResourceLocation;DDD)Lnet/minecraft/entity/Entity;", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F", ordinal = 0))
	private static float redirect_random_655_1(Random rand) {
		return KillTheRNG.randomness.random_655.nextFloat();
//		KillTheRNG.randomness.random_655.nextFloat();
//		return rand.nextFloat();
	}

}
