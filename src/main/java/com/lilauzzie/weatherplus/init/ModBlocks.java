package com.lilauzzie.weatherplus.init;

import com.lilauzzie.weatherplus.block.BlockDirtPuddleWP;
import com.lilauzzie.weatherplus.block.BlockWP;
import com.lilauzzie.weatherplus.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by lilauzzie on 30/12/2014.
 * This file is used in the MC-WeatherPlus project.
 */

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {
    public static final BlockWP dirtPuddle = new BlockDirtPuddleWP();

    public static void init() {
        GameRegistry.registerBlock(dirtPuddle, "dirtPuddle");
    }
}
