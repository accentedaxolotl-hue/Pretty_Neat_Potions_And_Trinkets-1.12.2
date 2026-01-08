package net.itwaskairo.lepton;

import net.itwaskairo.lepton.effect.ModEffects;
import net.itwaskairo.lepton.item.ModItems;
import net.itwaskairo.lepton.server.ai.MobSetup;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Lepton.MODID, name = "Lepton", version = "1.0", acceptableRemoteVersions = "*")
public class Lepton {
    public static final String MODID = "lepton";

    @Mod.Instance(MODID)
    public static Lepton instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        ModItems.preInit();
        ModEffects.preInit();

        MinecraftForge.EVENT_BUS.register(new MobSetup());
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(
                ModItems.catnipPotion,
                0,
                new ModelResourceLocation(
                        ModItems.catnipPotion.getRegistryName(),
                        "inventory"
                )
        );
    }
}
