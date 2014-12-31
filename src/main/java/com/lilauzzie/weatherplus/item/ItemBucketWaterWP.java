package com.lilauzzie.weatherplus.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

/**
 * Created by lilauzzie on 30/12/2014.
 * This file is used in the MC-WeatherPlus project.
 */
public class ItemBucketWaterWP extends ItemWP {

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public ItemBucketWaterWP() {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName("bucketWaterWP");
    }

    /*
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta)
    {
        return icons[MathHelper.clamp_int(meta, 0, Names.Items.ALCHEMICAL_FUEL_SUBTYPES.length - 1)];
    }
    */

}
