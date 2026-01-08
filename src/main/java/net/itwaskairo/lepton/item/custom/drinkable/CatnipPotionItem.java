package net.itwaskairo.lepton.item.custom.drinkable;

import net.itwaskairo.lepton.effect.ModEffects;
import net.itwaskairo.lepton.item.base.PotionBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class CatnipPotionItem extends PotionBase {

    public CatnipPotionItem() {
        super();
    }

    @Override
    protected void applyEffect(EntityPlayer player, World world) {
        player.addPotionEffect(
                new PotionEffect(ModEffects.catnipEffect, 1800)
        );
    }
}
