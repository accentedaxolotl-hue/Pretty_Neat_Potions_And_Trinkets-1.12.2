package net.itwaskairo.lepton.config;

import net.minecraftforge.common.config.Config;

@Config(modid = "lepton")
public class LeptonConfig {

    @Config.Name("Mob Behavior")
    public static MobBehavior mobBehavior = new MobBehavior();

    public static class MobBehavior {

        @Config.Comment("If creepers avoid players with Catnip")
        public boolean catnip_creeper_avoidance = true;

        @Config.Comment("The radius in which mobs avoid blessed, haunted, or catnip players")
        @Config.RangeInt(min = 1, max = 99)
        public int mob_avoid_value = 4;

    }
}