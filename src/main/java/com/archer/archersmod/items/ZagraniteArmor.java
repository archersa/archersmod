package com.archer.archersmod.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.archer.archersmod.ArchersMod;

public class ZagraniteArmor extends ItemArmor {

	// private String[] armorTypes = { "zagraniteHelm", "zagraniteChest",
	// "zagraniteLegs", "zagraniteBoots" };

	public ZagraniteArmor(ArmorMaterial material, int armorIndex, int armorType) {
		super(material, armorIndex, armorType);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String layer) {
		if (stack.getItem().equals(ArchersMod.zagraniteHelmetArmor)
				|| stack.getItem().equals(ArchersMod.zagraniteChestplateArmor)
				|| stack.getItem().equals(ArchersMod.zagraniteBootsArmor)) {
			return ("archersmod:textures/models/armor/zagranite_armor_layer1.png");
		} else if (stack.getItem().equals(ArchersMod.zagraniteLeggingsArmor)) {
			return ("archersmod:textures/models/armor/zagranite_armor_layer2.png");
		} else
			return null;
	}

	@Override
	public void registerIcons(IIconRegister reg) {
		if (this == ArchersMod.zagraniteHelmetArmor)
			this.itemIcon = reg.registerIcon(ArchersMod.modid + ":"
					+ "zagranite_helmet");
		else if (this == ArchersMod.zagraniteChestplateArmor)
			this.itemIcon = reg.registerIcon(ArchersMod.modid + ":"
					+ "zagranite_chestplate");
		else if (this == ArchersMod.zagraniteLeggingsArmor)
			this.itemIcon = reg.registerIcon(ArchersMod.modid + ":"
					+ "zagranite_leggings");
		else if (this == ArchersMod.zagraniteBootsArmor)
			this.itemIcon = reg.registerIcon(ArchersMod.modid + ":"
					+ "zagranite_boots");
	}
}
