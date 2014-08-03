package com.archer.archersmod.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.IIcon;

import com.archer.archersmod.ArchersMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ZagaraniteHelmet extends ItemArmor {

	public ZagaraniteHelmet(ArmorMaterial material, int diamond, int helmet) {
		super(material, diamond, helmet);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setTextureName(ArchersMod.modid + ":" + "ZHelmet");
		this.setUnlocalizedName("Zagaranite Helmet");
	}

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(ArchersMod.modid + ':'
				+ "zagaranite_helmet");
	}
}
