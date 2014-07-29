package com.archer.archersmod.blocks;

import com.archer.archersmod.ArchersMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class Zagaraniteore extends Block{
	
	public Zagaraniteore(Material material){
		super(material);
		this.setBlockName("zagaranite_ore");
		this.setLightLevel(255F);
		this.setLightOpacity(0);
		this.setHardness(5F);
		this.setBlockTextureName(ArchersMod.modid + ":" + "zagaranite_ore");
		this.setCreativeTab(CreativeTabs.tabBlock);
	
	}
		
		@SideOnly(Side.CLIENT)
		private IIcon[] icons;
		@SideOnly(Side.CLIENT)
		public void registerIcons(IIconRegister par1IconRegister)
		{
			this.blockIcon = par1IconRegister.registerIcon(ArchersMod.modid + 
					':'+"zagarnite_ore");
		}

}