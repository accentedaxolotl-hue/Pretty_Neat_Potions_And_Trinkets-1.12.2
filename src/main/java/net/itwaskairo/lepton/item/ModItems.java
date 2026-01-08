package net.itwaskairo.lepton.item;

import net.itwaskairo.lepton.Lepton;
import net.itwaskairo.lepton.item.custom.drinkable.CatnipPotionItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModItems {
    public static Item catnipPotion;

    public static void preInit() {
        catnipPotion = new CatnipPotionItem()
                .setRegistryName(Lepton.MODID, "catnippotion")
                .setUnlocalizedName("lepton.catnipotion")
                .setMaxStackSize(1);
        ForgeRegistries.ITEMS.register(catnipPotion);
    }
}