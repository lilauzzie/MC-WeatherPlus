package com.lilauzzie.weatherplus.item;

import com.lilauzzie.weatherplus.init.ModItems;
import com.lilauzzie.weatherplus.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;

/**
 * Created by lilauzzie on 31/12/2014.
 * This file is used in the MC-WeatherPlus project.
 */

public class ItemBucketBase extends ItemWP  {
    private Block isFull;
    private int metaL;

    public ItemBucketBase(Block block, float f) {
        this.setMaxStackSize(1);
        this.setMaxDamage(0);
        this.isFull = block;
    }

    public ItemStack onItemRightClick(final ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        boolean flag = this.isFull == Blocks.air;
        final MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, entityPlayer, flag);

        if (movingobjectposition == null) {
            return itemStack;
        } else {
            FillBucketEvent event = new FillBucketEvent(entityPlayer, itemStack, world, movingobjectposition);
            if (MinecraftForge.EVENT_BUS.post(event)) {
                return itemStack;
            }

            if (event.getResult() == Event.Result.ALLOW) {
                if (entityPlayer.capabilities.isCreativeMode) {
                    return itemStack;
                }

                if (--itemStack.stackSize <= 0) {
                    return event.result;
                }

                if (!entityPlayer.inventory.addItemStackToInventory(event.result)) {
                    entityPlayer.dropPlayerItemWithRandomChoice(event.result, false);
                }

                return itemStack;
            }

            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                if (!world.canMineBlock(entityPlayer, i, j, k)) {
                    return itemStack;
                }

                if (flag) {
                    if (!entityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemStack)) {
                        return itemStack;
                    }

                    Material material = world.getBlock(i, j, k).getMaterial();
                    int l = world.getBlockMetadata(i, j, k);
                    metaL = l;

                    if (material == Material.water && l == 0) {
                        world.setBlockToAir(i, j, k);
                        return this.tryPickupLiquid(itemStack, entityPlayer, ModItems.bucketWaterWP, l);
                    }

                    /*
                    if (material == Material.lava && l = 0) {
                        world.setBlockToAir(i, j, k);
                        return this.tryPickupLiquid(itemStack, entityPlayer, Items.lava_bucket);
                    } */
                } else {
                    if (this.isFull == Blocks.air) {
                        return new ItemStack(ModItems.bucketWP);
                    }

                    if (movingobjectposition.sideHit == 0) {
                        --j;
                    }

                    if (movingobjectposition.sideHit == 1) {
                        ++j;
                    }

                    if (movingobjectposition.sideHit == 2) {
                        --k;
                    }

                    if (movingobjectposition.sideHit == 3) {
                        ++k;
                    }

                    if (movingobjectposition.sideHit == 4) {
                        --i;
                    }

                    if (movingobjectposition.sideHit == 5) {
                        ++i;
                    }

                    if (!entityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemStack)) {
                        return itemStack;
                    }

                    if (this.tryPlaceContainedLiquid(world, i, j, k, metaL) && !entityPlayer.capabilities.isCreativeMode) {
                        return new ItemStack(ModItems.bucketWP);
                    }

                }
            }
        };

        return itemStack;
    }

    private ItemStack tryPickupLiquid(ItemStack itemStack, EntityPlayer entityPlayer, Item item, int meta) {
        if (entityPlayer.capabilities.isCreativeMode) {
            return itemStack;
        }
        else if (--itemStack.stackSize <= 0) {
            return new ItemStack(item);
        }
        else {
            if (!entityPlayer.inventory.addItemStackToInventory(new ItemStack(item))) {
                entityPlayer.dropPlayerItemWithRandomChoice(new ItemStack(item, 1, meta), false);
            }

            return itemStack;
        }
    }

    public boolean tryPlaceContainedLiquid(World world, int i, int j, int k, int meta) {
        if (this.isFull == Blocks.air) {
            return false;
        }
        else {
            Material material = world.getBlock(i, j, k).getMaterial();
            boolean flag = !material.isSolid();

            if (!world.isAirBlock(i, j, k) && !flag) {
                return false;
            }
            else {
                if (world.provider.isHellWorld && this.isFull == Blocks.flowing_water) {
                    world.playSoundEffect((double)((float)i + 0.5F), (double)((float)j + 0.5F), (double)((float)k + 0.5F), "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

                    for (int l = 0; l < 8; ++l) {
                        world.spawnParticle("largesmoke", (double)i + Math.random(), (double)j + Math.random(), (double)k + Math.random(), 0.0D, 0.0D, 0.0D);
                    }
                }
                else {
                    if (!world.isRemote && flag && !material.isLiquid()) {
                        world.func_147480_a(i, j, k, true);
                    }

                    world.setBlock(i, j, k, this.isFull, meta, 3);
                }

                return true;
            }
        }
    }
}
