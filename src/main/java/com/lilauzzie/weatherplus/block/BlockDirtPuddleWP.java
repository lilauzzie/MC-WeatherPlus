package com.lilauzzie.weatherplus.block;

import com.lilauzzie.weatherplus.creativetab.CreativeTabWP;

/**
 * Created by lilauzzie on 30/12/2014.
 * This file is used in the MC-WeatherPlus project.
 */
public class BlockDirtPuddleWP extends BlockWP {

    public BlockDirtPuddleWP () {
        this.setBlockName("dirtPuddle");
        this.setHardness(0.5F);
        this.setStepSound(soundTypeGravel);
        this.setCreativeTab(CreativeTabWP.WP_TAB);
    }
}
