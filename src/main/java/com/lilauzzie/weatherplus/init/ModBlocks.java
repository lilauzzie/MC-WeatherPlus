package com.lilauzzie.weatherplus.init;

import com.lilauzzie.weatherplus.block.BlockDirtPuddleWP;
import com.lilauzzie.weatherplus.block.BlockLiquidWP;
import com.lilauzzie.weatherplus.block.BlockWP;
import com.lilauzzie.weatherplus.block.BlockWaterWP;
import com.lilauzzie.weatherplus.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;

/**
 * Created by lilauzzie on 30/12/2014.
 * This file is used in the MC-WeatherPlus project.
 */

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {
    public static final BlockWP dirtPuddle = new BlockDirtPuddleWP();
    public static final BlockWaterWP waterWP = new BlockWaterWP(Material.water, 0);

    public static void init() {
        GameRegistry.registerBlock(dirtPuddle, "dirtPuddle");
        GameRegistry.registerBlock(waterWP, "waterWP");
    }
}
