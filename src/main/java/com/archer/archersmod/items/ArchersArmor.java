package com.archer.archersmod.items;

import com.archer.archersmod.ArchersMod;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ArchersArmor extends ItemArmor {

	private String[] armorTypes = { "rubyHelm", "rubyChest", "rubyLegs",
			"rubyBoots" };

	public ArchersArmor(ArmorMaterial material, int armorIndex, int armorType) {
		super(material, armorIndex, armorType);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String layer) {
		if (stack.getItem().equals(ArchersMod.rubyHelm)
				|| stack.getItem().equals(ArchersMod.rubyChest)
				|| stack.getItem().equals(ArchersMod.rubyBoots)) {
			return ("archersmod:textures/models/armor/ArchersArmorLayer1.png");
		} else if (stack.getItem().equals(ArchersMod.rubyLegs)) {
			return ("archersmod:textures/models/armor/ArchersArmorLayer2.png");
		} else
			return null;
	}

	@Override
	public void registerIcons(IIconRegister reg) {
		if (this == ArchersMod.rubyHelm)
			this.itemIcon = reg.registerIcon(ArchersMod.modid + ":"
					+ "archersHelmet");
		else if (this == ArchersMod.rubyChest)
			this.itemIcon = reg.registerIcon(ArchersMod.modid + ":"
					+ "archersChestplate");
		else if (this == ArchersMod.rubyLegs)
			this.itemIcon = reg.registerIcon(ArchersMod.modid + ":"
					+ "archers Leggings");
		else if (this == ArchersMod.rubyBoots)
			this.itemIcon = reg.registerIcon(ArchersMod.modid + ":"
					+ "archersBoots");
	}
}
