package com.lilauzzie.weatherplus.item;

import net.minecraft.block.Block;

/**
 * Created by lilauzzie on 30/12/2014.
 * This file is used in the MC-WeatherPlus project.
 */

public class ItemBucketIron extends ItemBucketBase {

    public ItemBucketIron(Block block, float f) {
        super(block, f);
        this.setMaxStackSize(1);
        this.setUnlocalizedName("bucketIron");
    }

}
