package de.scribble.lp.killtherng.mixin.ktrng.patches;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import de.scribble.lp.killtherng.KillTheRNG;

@Mixin(targets="net.minecraft.entity.monster.EntitySilverfish$AIHideInStone")
public class MixinEntitySilverfish$AIHideInStone {

	/**
	* null
	*/
	@Redirect(method = "shouldExecute()Z", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 0))
	public int redirect_random_890_1(Random rand, int i) {
		return KillTheRNG.randomness.random_890.nextInt(i);
//		KillTheRNG.randomness.random_890.nextInt(i);
//		return rand.nextInt(i);
	}

}
