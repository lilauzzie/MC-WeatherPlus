package com.lilauzzie.weatherplus.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

/**
 * Created by lilauzzie on 30/12/2014.
 * This file is used in the MC-WeatherPlus project.
 */

public class ItemBucketIronWater extends ItemBucketBase {

    public ItemBucketIronWater(Block block, float f) {
        super(block, f);
        this.setMaxStackSize(1);
        this.setUnlocalizedName("bucketIronWater");
    }

}
