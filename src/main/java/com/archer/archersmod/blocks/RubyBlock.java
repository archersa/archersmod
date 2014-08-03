package com.archer.archersmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

import com.archer.archersmod.ArchersMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RubyBlock extends Block {

	public RubyBlock(Material material) {
		super(material);
		this.setBlockName("ruby_block");
		this.setHardness(10F);
		this.setBlockTextureName(ArchersMod.modid + ":" + "ruby_block");
		this.setCreativeTab(CreativeTabs.tabBlock);

	}

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon(ArchersMod.modid + ':'
				+ "ruby_block");
	}
}
