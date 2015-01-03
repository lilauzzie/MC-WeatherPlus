package com.lilauzzie.weatherplus.init;

import com.lilauzzie.weatherplus.item.ItemBucketIron;
import com.lilauzzie.weatherplus.item.ItemBucketIronWater;
import com.lilauzzie.weatherplus.item.ItemModIcon;
import com.lilauzzie.weatherplus.item.ItemWP;
import com.lilauzzie.weatherplus.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;

/**
 * Created by lilauzzie on 30/12/2014.
 * This file is used in the MC-WeatherPlus project.
 */

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {

    public static final ItemWP bucketWP = new ItemBucketIron(Blocks.air, 1);
    public static final ItemWP bucketWaterWP = new ItemBucketIronWater(ModBlocks.waterWP, 1);

    public static final ItemWP modIconWP = new ItemModIcon();

    public static void init() {
        GameRegistry.registerItem(bucketWP, "bucketIron");
        GameRegistry.registerItem(bucketWaterWP, "bucketIronWater");

        GameRegistry.registerItem(modIconWP, "modIconWP");
    }

}
