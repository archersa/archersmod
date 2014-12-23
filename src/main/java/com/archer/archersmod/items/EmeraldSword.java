package com.archer.archersmod.items;

import com.archer.archersmod.ArchersMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class EmeraldSword extends ItemSword {
	public EmeraldSword(ToolMaterial material) {
		super(material);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setTextureName(ArchersMod.modid + ":" + "emerald_sword");
		this.setUnlocalizedName("emerald_sword");
	}

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	private IIcon itemIcon2;
	private IIcon itemIcon1;
	private IIcon itemIcon3;

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon1 = par1IconRegister.registerIcon(ArchersMod.modid + ':'
				+ "emerald_sword");
		this.itemIcon2 = par1IconRegister.registerIcon(ArchersMod.modid + ':'
				+ "emerald_sword_alt");
		this.itemIcon3 = par1IconRegister.registerIcon(ArchersMod.modid + ':'
				+ "emerald_sword_blue");

		this.itemIcon = this.itemIcon1;
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		swingCounter++;
		if (swingCounter % 2 == 0) {
			swapIcon();
		} 
		return super.onEntitySwing(entityLiving, stack);
	}

	int swingCounter;

	private void swapIcon() {
		if (this.itemIcon == this.itemIcon1) {
			this.itemIcon = this.itemIcon2;
		} else if (itemIcon == this.itemIcon2) {
			this.itemIcon = this.itemIcon3;
		} else {
			this.itemIcon = this.itemIcon1;
		}
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {
		swapIcon();
		return super.onDroppedByPlayer(item, player);
	}
}
