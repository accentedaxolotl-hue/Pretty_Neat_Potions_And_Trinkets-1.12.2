package net.itwaskairo.lepton.effect.custom;

import net.minecraft.potion.Potion;

public class CatnipEffect extends Potion {
    public CatnipEffect() {
        super(false, 0xFBB701);
        setPotionName("effect.lepton.catnip");
        setRegistryName("lepton", "catnip");
    }
}