package com.lilauzzie.weatherplus.block;

import com.lilauzzie.weatherplus.creativetab.CreativeTabWP;
import com.lilauzzie.weatherplus.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;

/**
 * Created by lilauzzie on 30/12/2014.
 * This file is used in the MC-WeatherPlus project.
 */
public class BlockWP extends Block {
    public BlockWP(Material material) {
        super(material);
        this.setCreativeTab(CreativeTabWP.WP_TAB);
    }

    public BlockWP() {
        this(Material.ground);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }
}
