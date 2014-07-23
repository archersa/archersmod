package com.archer.archersmod.blocks;

import com.archer.archersmod.ArchersMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class archersore extends Block{
	
	public archersore(Material material){
		super(material);
		this.setBlockName("archers_ore");
		this.slipperiness = 0F;
		this.setHardness(5F);
		this.setBlockTextureName(ArchersMod.modid + ":" + "archers_ore");
		this.setCreativeTab(CreativeTabs.tabBlock);
	
	}
		
		@SideOnly(Side.CLIENT)
		private IIcon[] icons;
		@SideOnly(Side.CLIENT)
		public void registerIcons(IIconRegister par1IconRegister)
		{
			this.blockIcon = par1IconRegister.registerIcon(ArchersMod.modid + 
					':'+"archers_ore");
		}
	
}


