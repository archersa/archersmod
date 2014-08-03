package com.archer.archersmod.items;

import com.archer.archersmod.ArchersMod;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ZagaraniteArmor extends ItemArmor {

//	private String[] armorTypes = { "zagraniteHelm", "zagaraniteChest",
//			"zagaraniteLegs", "zagaraniteBoots" };

	public ZagaraniteArmor(ArmorMaterial material, int armorIndex, int armorType) {
		super(material, armorIndex, armorType);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String layer) {
		if (stack.getItem().equals(ArchersMod.zagaraniteHelm)
				|| stack.getItem().equals(ArchersMod.zagaraniteChest)
				|| stack.getItem().equals(ArchersMod.zagaraniteBoots)) {
			return ("archersmod:textures/models/armor/zArmorLayer1.png");
		} else if (stack.getItem().equals(ArchersMod.zagaraniteLegs)) {
			return ("archersmod:textures/models/armor/zArmorLayer2.png");
		} else
			return null;
	}

	@Override
	public void registerIcons(IIconRegister reg) {
		if (this == ArchersMod.zagaraniteHelm)
			this.itemIcon = reg.registerIcon(ArchersMod.modid + ":" + "ZHelmet");
		else if (this == ArchersMod.zagaraniteChest)
			this.itemIcon = reg.registerIcon(ArchersMod.modid + ":"
					+ "ZChestplate");
		else if (this == ArchersMod.zagaraniteLegs)
			this.itemIcon = reg.registerIcon(ArchersMod.modid + ":"
					+ "archersLeggings");
		else if (this == ArchersMod.zagaraniteBoots)
			this.itemIcon = reg.registerIcon(ArchersMod.modid + ":"
					+ "archersBoots");
	}
}
