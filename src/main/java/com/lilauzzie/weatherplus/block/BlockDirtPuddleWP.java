package com.lilauzzie.weatherplus.block;

import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by lilauzzie on 30/12/2014.
 * This file is used in the MC-WeatherPlus project.
 */
public class BlockDirtPuddleWP extends BlockWP {

    public BlockDirtPuddleWP () {
        this.setBlockName("dirtPuddle");
        this.setHardness(0.5F);
        this.setStepSound(soundTypeGravel);
        this.setHarvestLevel("shovel", 0);
    }

    @Override
    public Item getItemDropped(int metadata, Random rand, int fortune) {
        return Item.getItemById(3);
    };

}
