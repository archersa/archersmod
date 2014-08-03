package com.archer.archersmod.items;

import com.archer.archersmod.ArchersMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSword;
import net.minecraft.util.IIcon;

public class ZagaranitePick extends ItemPickaxe {

	public ZagaranitePick(ToolMaterial material) {
		super(material);
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setTextureName(ArchersMod.modid + ":" + "zagaranitepick");
		this.setUnlocalizedName("Zagaranite Pickaxe");
	}

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(ArchersMod.modid + ':'
				+ "zagaranite_pickaxe");
	}
}
