package de.scribble.lp.killtherng.mixin.ktrng.patches;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import de.scribble.lp.killtherng.KillTheRNG;
import net.minecraft.world.gen.feature.WorldGenFossils;

@Mixin(WorldGenFossils.class)
public class MixinWorldGenFossils {

	/**
	* Random Position, Rotation and type of Fossil
	*/
	@Redirect(method = "generate(Lnet/minecraft/world/World;Ljava/util/Random;Lnet/minecraft/util/math/BlockPos;)Z", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 0))
	public int redirect_fossilGenRandom_1(Random rand, int i) {
//		return KillTheRNG.randomness.fossilGenRandom.nextInt(i);
		KillTheRNG.randomness.fossilGenRandom.nextInt(i);
		return rand.nextInt(i);
	}

	/**
	* Random Position, Rotation and type of Fossil
	*/
	@Redirect(method = "generate(Lnet/minecraft/world/World;Ljava/util/Random;Lnet/minecraft/util/math/BlockPos;)Z", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 1))
	public int redirect_fossilGenRandom_2(Random rand, int i) {
//		return KillTheRNG.randomness.fossilGenRandom.nextInt(i);
		KillTheRNG.randomness.fossilGenRandom.nextInt(i);
		return rand.nextInt(i);
	}

	/**
	* Random Position, Rotation and type of Fossil
	*/
	@Redirect(method = "generate(Lnet/minecraft/world/World;Ljava/util/Random;Lnet/minecraft/util/math/BlockPos;)Z", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 2))
	public int redirect_fossilGenRandom_3(Random rand, int i) {
//		return KillTheRNG.randomness.fossilGenRandom.nextInt(i);
		KillTheRNG.randomness.fossilGenRandom.nextInt(i);
		return rand.nextInt(i);
	}

	/**
	* Random Position, Rotation and type of Fossil
	*/
	@Redirect(method = "generate(Lnet/minecraft/world/World;Ljava/util/Random;Lnet/minecraft/util/math/BlockPos;)Z", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 3))
	public int redirect_fossilGenRandom_4(Random rand, int i) {
//		return KillTheRNG.randomness.fossilGenRandom.nextInt(i);
		KillTheRNG.randomness.fossilGenRandom.nextInt(i);
		return rand.nextInt(i);
	}

	/**
	* Random Position, Rotation and type of Fossil
	*/
	@Redirect(method = "generate(Lnet/minecraft/world/World;Ljava/util/Random;Lnet/minecraft/util/math/BlockPos;)Z", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 4))
	public int redirect_fossilGenRandom_5(Random rand, int i) {
//		return KillTheRNG.randomness.fossilGenRandom.nextInt(i);
		KillTheRNG.randomness.fossilGenRandom.nextInt(i);
		return rand.nextInt(i);
	}

}
