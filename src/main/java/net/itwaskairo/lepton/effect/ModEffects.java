package net.itwaskairo.lepton.effect;

import net.itwaskairo.lepton.effect.custom.CatnipEffect;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModEffects {
    public static Potion catnipEffect;
    public static void preInit() {
        catnipEffect = new CatnipEffect();
        ForgeRegistries.POTIONS.register(catnipEffect);
    }
}