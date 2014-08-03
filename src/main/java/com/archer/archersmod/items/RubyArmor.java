package com.archer.archersmod.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.archer.archersmod.ArchersMod;

public class RubyArmor extends ItemArmor {

//	private String[] armorTypes = { "rubyHelm", "rubyChest", "rubyLegs",
//			"rubyBoots" };

	public RubyArmor(ArmorMaterial material, int armorIndex, int armorType) {
		super(material, armorIndex, armorType);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String layer) {
		if (stack.getItem().equals(ArchersMod.rubyHelmetArmor)
				|| stack.getItem().equals(ArchersMod.rubyChestplateArmor)
				|| stack.getItem().equals(ArchersMod.rubyBootsArmor)) {
			return ("archersmod:textures/models/armor/ruby_armor_layer1.png");
		} else if (stack.getItem().equals(ArchersMod.rubyLeggingsArmor)) {
			return ("archersmod:textures/models/armor/ruby_armor_layer2.png");
		} else
			return null;
	}

	@Override
	public void registerIcons(IIconRegister reg) {
		if (this == ArchersMod.rubyHelmetArmor)
			this.itemIcon = reg.registerIcon(ArchersMod.modid + ":"
					+ "ruby_helmet");
		else if (this == ArchersMod.rubyChestplateArmor)
			this.itemIcon = reg.registerIcon(ArchersMod.modid + ":"
					+ "ruby_chestplate");
		else if (this == ArchersMod.rubyLeggingsArmor)
			this.itemIcon = reg.registerIcon(ArchersMod.modid + ":"
					+ "ruby_leggings");
		else if (this == ArchersMod.rubyBootsArmor)
			this.itemIcon = reg.registerIcon(ArchersMod.modid + ":"
					+ "ruby_boots");
	}
}
