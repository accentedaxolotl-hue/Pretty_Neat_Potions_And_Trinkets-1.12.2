package net.itwaskairo.lepton.server.ai;

import com.google.common.base.Predicate;
import net.itwaskairo.lepton.config.LeptonConfig;
import net.itwaskairo.lepton.effect.ModEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MobSetup {

    @SubscribeEvent
    public void onEntityJoin(EntityJoinWorldEvent event) {
        if (event.getWorld().isRemote) return;
        Entity ent = event.getEntity();

        if (!(ent instanceof EntityCreature)) return;
        EntityCreature mob = (EntityCreature) ent;

        if (mob instanceof EntityCreeper && LeptonConfig.mobBehavior.catnip_creeper_avoidance) {
            mob.tasks.addTask(2, new AvoidPlayerWithEffectGoal(
                    mob,
                    LeptonConfig.mobBehavior.mob_avoid_value,
                    1.0D,
                    1.2D,
                    ModEffects.catnipEffect
            ));
        }
    }

    private static class AvoidPlayerWithEffectGoal
            extends EntityAIAvoidEntity<EntityPlayer> {

        private final Potion effect;

        public AvoidPlayerWithEffectGoal(
                EntityCreature creature,
                float avoidDist,
                double farSpeed,
                double nearSpeed,
                Potion effect
        ) {
            super(
                    creature,
                    EntityPlayer.class,
                    (Predicate<EntityPlayer>) player ->
                            player != null && player.isPotionActive(effect),
                    avoidDist,
                    farSpeed,
                    nearSpeed
            );
            this.effect = effect;
        }
    }
}