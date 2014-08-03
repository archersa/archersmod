package com.archer.archersmod.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.archer.archersmod.ArchersMod;

public class ZagArmor extends ItemArmor {

	// private String[] armorTypes = { "zagHelm", "zagChest",
	// "zagLegs", "zagBoots" };

	public ZagArmor(ArmorMaterial material, int armorIndex, int armorType) {
		super(material, armorIndex, armorType);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String layer) {
		if (stack.getItem().equals(ArchersMod.zagHelmetArmor)
				|| stack.getItem().equals(ArchersMod.zagChestplateArmor)
				|| stack.getItem().equals(ArchersMod.zagBootsArmor)) {
			return ("archersmod:textures/models/armor/zag_armor_layer1.png");
		} else if (stack.getItem().equals(ArchersMod.zagLeggingsArmor)) {
			return ("archersmod:textures/models/armor/zag_armor_layer2.png");
		} else
			return null;
	}

	@Override
	public void registerIcons(IIconRegister reg) {
		if (this == ArchersMod.zagHelmetArmor)
			this.itemIcon = reg.registerIcon(ArchersMod.modid + ":"
					+ "zag_helmet");
		else if (this == ArchersMod.zagChestplateArmor)
			this.itemIcon = reg.registerIcon(ArchersMod.modid + ":"
					+ "zag_chestplate");
		else if (this == ArchersMod.zagLeggingsArmor)
			this.itemIcon = reg.registerIcon(ArchersMod.modid + ":"
					+ "zag_leggings");
		else if (this == ArchersMod.zagBootsArmor)
			this.itemIcon = reg.registerIcon(ArchersMod.modid + ":"
					+ "zag_boots");
	}
}
