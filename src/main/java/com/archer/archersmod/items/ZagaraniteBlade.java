package com.archer.archersmod.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import com.archer.archersmod.ArchersMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ZagaraniteBlade extends Item {

	public ZagaraniteBlade() {
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setTextureName(ArchersMod.modid + ":" + "zagaranite_blade");
		this.setUnlocalizedName("Zagaranite Blade");
	}

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(ArchersMod.modid + ':'
				+ "zagaranite_blade");
	}
}
