package com.archer.archersmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

import com.archer.archersmod.ArchersMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RubyOre extends Block {

	public RubyOre(Material material) {
		super(material);
		this.setBlockName("ruby_ore");
		this.setStepSound(soundTypeMetal);
		this.setHardness(5F);
		this.setBlockTextureName(ArchersMod.modid + ":" + "ruby_ore");
		this.setCreativeTab(CreativeTabs.tabBlock);

	}

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon(ArchersMod.modid + ':'
				+ "ruby_ore");
	}

}
