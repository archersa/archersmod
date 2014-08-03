package com.archer.archersmod.items;

import com.archer.archersmod.ArchersMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class ArchersIngot extends Item {
	public ArchersIngot() {
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setTextureName(ArchersMod.modid + ":" + "archersIngot");
		this.setUnlocalizedName("Archer's Ingot");
	}

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(ArchersMod.modid + ':'
				+ "archers_ingot");
	}

}
