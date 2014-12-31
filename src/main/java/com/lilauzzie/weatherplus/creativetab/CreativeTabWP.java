package com.lilauzzie.weatherplus.creativetab;

import com.lilauzzie.weatherplus.init.ModItems;
import com.lilauzzie.weatherplus.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by lilauzzie on 30/12/2014.
 * This file is used in the MC-WeatherPlus project.
 */
public class CreativeTabWP {
    public static final CreativeTabs WP_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
            return ModItems.modIconWP;
        }
    };
}
