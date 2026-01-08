package net.itwaskairo.lepton.item.base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public abstract class ThrowableBase extends Item {
    public ThrowableBase() {
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(
            World world,
            EntityPlayer player,
            EnumHand hand
    ) {

        ItemStack stack = player.getHeldItem(hand);

        if (!world.isRemote) {
            EntityThrowable entity = createProjectile(world, player);
            entity.shoot(
                    player,
                    player.rotationPitch,
                    player.rotationYaw,
                    0.0F,
                    1.5F,
                    1.0F
            );
            world.spawnEntity(entity);
        }

        if (!player.capabilities.isCreativeMode) {
            stack.shrink(1);
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }

    protected abstract EntityThrowable createProjectile(World world, EntityPlayer player);
}
