package com.archer.archersmod.items;

import com.archer.archersmod.ArchersMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.util.IIcon;

public class ZagaraniteSword extends ItemSword {

	public ZagaraniteSword(ToolMaterial material) {
		super(material);
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setPotionEffect(Potion.moveSpeed.getName());
		this.setTextureName(ArchersMod.modid + ":" + "zagaranite_sword.png");
		this.setUnlocalizedName("Zagaranite Sword");
	}

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(ArchersMod.modid + ':'
				+ "zagaranite_sword");
	}
}
