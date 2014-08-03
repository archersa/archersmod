package com.archer.archersmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlackIce extends Block {

	public BlackIce(Material material) {
		super(material);
		this.setBlockName("Black Ice");
		this.slipperiness = 10F;
		this.setHardness(2F);
		this.setBlockTextureName("cactus_side");
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

}
