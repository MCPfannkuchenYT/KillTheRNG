package de.scribble.lp.killtherng.mixin.ktrng.patches;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import de.scribble.lp.killtherng.KillTheRNG;
import net.minecraft.client.gui.GuiIngame;

@Mixin(GuiIngame.class)
public class MixinGuiIngame {

	/**
	* Sets the random seed in GuiIngame
	*/
	@Redirect(method = "renderPlayerStats(Lnet/minecraft/client/gui/ScaledResolution;)V", at = @At(value = "INVOKE", target = "Ljava/util/Random;setSeed(J)V", ordinal = 0))
	public void redirect_guiIngameSetRandomSeed_1(Random rand, long seed) {
		KillTheRNG.randomness.guiIngameSetRandomSeed.setSeed(seed, true);
		rand.setSeed(seed);
	}

	/**
	* Pattern of hearts shaking
	*/
	@Redirect(method = "renderPlayerStats(Lnet/minecraft/client/gui/ScaledResolution;)V", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 0))
	public int redirect_guiIngameShakeHearts_2(Random rand, int i) {
//		return KillTheRNG.randomness.guiIngameShakeHearts.nextInt(i);
		KillTheRNG.randomness.guiIngameShakeHearts.nextInt(i);
		return rand.nextInt(i);
	}

	/**
	* Pattern of hunger bars shaking
	*/
	@Redirect(method = "renderPlayerStats(Lnet/minecraft/client/gui/ScaledResolution;)V", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 1))
	public int redirect_guiIngameShakeHunger_3(Random rand, int i) {
//		return KillTheRNG.randomness.guiIngameShakeHunger.nextInt(i);
		KillTheRNG.randomness.guiIngameShakeHunger.nextInt(i);
		return rand.nextInt(i);
	}

}
