package com.archer.archersmod.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import com.archer.archersmod.ArchersMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RubyIngot extends Item {
	public RubyIngot() {
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setTextureName(ArchersMod.modid + ":" + "ruby_ingot");
		this.setUnlocalizedName("ruby_ingot");
	}

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(ArchersMod.modid + ':'
				+ "ruby_ingot");
	}

}
