package com.archer.archersmod.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.IIcon;

import com.archer.archersmod.ArchersMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArchersLeggings extends ItemArmor{

	public ArchersLeggings (ArmorMaterial material, int diamond, int leggings){
		super(material, diamond, leggings);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setTextureName(ArchersMod.modid + ":"+"archersleggings");
		this.setUnlocalizedName("Archers Leggings");
	}
	
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(ArchersMod.modid + 
				':'+"archersleggings");
	}
}
