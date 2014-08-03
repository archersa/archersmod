package com.archer.archersmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import com.archer.archersmod.blocks.BlackIce;
import com.archer.archersmod.blocks.RubyBlock;
import com.archer.archersmod.blocks.RubyOre;
import com.archer.archersmod.blocks.ZagraniteOre;
import com.archer.archersmod.items.RubyArmor;
import com.archer.archersmod.items.RubyAxe;
import com.archer.archersmod.items.RubyBlade;
import com.archer.archersmod.items.RubyHoe;
import com.archer.archersmod.items.RubyIngot;
import com.archer.archersmod.items.RubyPickaxe;
import com.archer.archersmod.items.RubySpade;
import com.archer.archersmod.items.RubySword;
import com.archer.archersmod.items.SwordHandle;
import com.archer.archersmod.items.WithersEndPick;
import com.archer.archersmod.items.ZagraniteArmor;
import com.archer.archersmod.items.ZagraniteAxe;
import com.archer.archersmod.items.ZagraniteBlade;
import com.archer.archersmod.items.ZagraniteChestplate;
import com.archer.archersmod.items.ZagraniteHelmet;
import com.archer.archersmod.items.ZagraniteIngot;
import com.archer.archersmod.items.ZagranitePickaxe;
import com.archer.archersmod.items.ZagraniteSword;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ArchersMod.modid, name = ArchersMod.name, version = ArchersMod.version)
public class ArchersMod {
	public static final String modid = "archersmod";
	public static final String name = "Archer's Mod";
	public static final String version = "0.0.1";

	public static final ToolMaterial RUBY = EnumHelper.addToolMaterial("RUBY",
			3, 2000, 30.0F, 8.0F, 20);
	public static final ToolMaterial RUBY2 = EnumHelper.addToolMaterial(
			"RUBY2", 3, 20000, 1000.0F, 8.0F, 20);
	public static final ArmorMaterial RUBY3 = EnumHelper.addArmorMaterial(
			"RUBY3", 50, new int[] { 4, 10, 8, 6 }, 40);

	public static final Item rubyHelmetArmor = new RubyArmor(RUBY3, 5, 0)
			.setUnlocalizedName("ruby_helmet_armor");
	public static final Item rubyChestplateArmor = new RubyArmor(RUBY3, 5, 1)
			.setUnlocalizedName("ruby_chestplate_armor");
	public static final Item rubyLeggingsArmor = new RubyArmor(RUBY3, 5, 2)
			.setUnlocalizedName("ruby_leggings_armor");
	public static final Item rubyBootsArmor = new RubyArmor(RUBY3, 5, 3)
			.setUnlocalizedName("ruby_boots_armor");

	public static final Item zagraniteHelmetArmor = new ZagraniteArmor(RUBY3,
			5, 0).setUnlocalizedName("zagranite_helmet_armor");
	public static final Item zagraniteChestplateArmor = new ZagraniteArmor(
			RUBY3, 5, 1).setUnlocalizedName("zagranite_chestplate_armor");
	public static final Item zagraniteLeggingsArmor = new ZagraniteArmor(RUBY3,
			5, 2).setUnlocalizedName("zagranite_leggings_armor");
	public static final Item zagraniteBootsArmor = new ZagraniteArmor(RUBY3, 5,
			3).setUnlocalizedName("zagranite_boots_armor");

	public static final Block rubyOre = new RubyOre(Material.ground);
	public static final Item rubyIngot = new RubyIngot();
	public static final Item rubyPickaxe = new RubyPickaxe(RUBY);
	public static final Item rubySword = new RubySword(RUBY);
	public static final Item rubyAxe = new RubyAxe(RUBY);
	public static final Item rubySpade = new RubySpade(RUBY);
	public static final Item rubyHoe = new RubyHoe(RUBY);
	public static final Block rubyBlock = new RubyBlock(Material.ground);
	public static final Item swordHandle = new SwordHandle();
	public static final Item rubyBlade = new RubyBlade();
	// public static final Item archersHelmet = new RubyHelmet(
	// ArmorMaterial.DIAMOND, 3, 0);
	// public static final Item rubyChestplate = new RubyChestplate(
	// ArmorMaterial.DIAMOND, 3, 1);
	// public static final Item rubyLeggings = new RubyLeggings(
	// ArmorMaterial.DIAMOND, 3, 2);
	// public static final Item archersBoots = new RubyBoots(
	// ArmorMaterial.DIAMOND, 3, 3);

	public static final Item withersEndPick = new WithersEndPick(RUBY2);
	public static final Block zagraniteOre = new ZagraniteOre(Material.ground);
	public static final Item zagraniteIngot = new ZagraniteIngot();
	public static final Item zagraniteSword = new ZagraniteSword(RUBY);
	// public static final Item itemBlasterRifle = new ItemBlasterRifle(null);
	public static final Item zagraniteBlade = new ZagraniteBlade();
	public static final Item zagraniteAxe = new ZagraniteAxe(RUBY);
	public static final Item zagranitePickaxe = new ZagranitePickaxe(RUBY);
	// public static final Item zagraniteHelmet = new ZagraniteHelmet(
	// ArmorMaterial.DIAMOND, 3, 0);
	// public static final Item zagraniteChestplate = new ZagraniteChestplate(
	// ArmorMaterial.DIAMOND, 3, 0);

	@Instance(value = "ArchersMod")
	public static ArchersMod instance;

	@SidedProxy(clientSide = "com.archer.client.ArchersClientProxy", serverSide = "com.archer.archersmod.ArchersCommonProxy")
	public static ArchersCommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.addNewArmourRendererPrefix("5");
		RenderingRegistry.addNewArmourRendererPrefix("6");
		MyBlocks();
		MyRecipes();
		MyItems();
	}

	@EventHandler
	public void Init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new ArchersOreGenerator(), 1);

		proxy.registerRenderers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}

	public void MyRecipes() {
		GameRegistry.addShapelessRecipe(
				new ItemStack(Blocks.mossy_cobblestone), new Object[] {
						Blocks.cobblestone, Blocks.vine });
		GameRegistry.addRecipe(new ItemStack(rubyAxe), new Object[] { "AA ",
				"BA ", "B  ", 'A', rubyIngot, 'B', Items.stick });
		GameRegistry.addRecipe(new ItemStack(rubyPickaxe), new Object[] {
				"AAA", " B ", " B ", 'A', rubyIngot, 'B', Items.stick });
		GameRegistry.addRecipe(new ItemStack(rubySpade), new Object[] { " A ",
				" B ", " B ", 'A', rubyIngot, 'B', Items.stick });
		GameRegistry.addRecipe(new ItemStack(rubyHoe), new Object[] { "AA ",
				" B ", " B ", 'A', rubyIngot, 'B', Items.stick });
		GameRegistry.addRecipe(new ItemStack(swordHandle), new Object[] {
				"A  ", " B ", "A A", 'A', Items.stick, 'B',
				(new ItemStack(Items.skull, 1, 1)) });
		GameRegistry.addRecipe(new ItemStack(rubyBlade), new Object[] { " A ",
				"CAC", " B ", 'A', rubyIngot, 'B', rubyBlock, 'C',
				Items.diamond });
		GameRegistry.addRecipe(new ItemStack(rubySword), new Object[] { " A ",
				" B ", 'A', rubyBlade, 'B', swordHandle });
		GameRegistry.addRecipe(new ItemStack(rubyBlock), new Object[] { "AAA",
				"AAA", "AAA", 'A', rubyIngot });
		GameRegistry.addRecipe(new ItemStack(rubyHelmetArmor), new Object[] {
				"AAA", "A A", 'A', rubyIngot });
		GameRegistry.addRecipe(new ItemStack(rubyChestplateArmor),
				new Object[] { "A A", "AAA", "AAA", 'A', rubyIngot });
		GameRegistry.addRecipe(new ItemStack(rubyLeggingsArmor), new Object[] {
				"AAA", "A A", "A A", 'A', rubyIngot });
		GameRegistry.addRecipe(new ItemStack(rubyBootsArmor), new Object[] {
				"A A", "A A", 'A', rubyIngot });
		GameRegistry.addRecipe(new ItemStack(zagraniteSword), new Object[] {
				" A ", " B ", 'A', zagraniteBlade, 'B', swordHandle });

		GameRegistry.addSmelting(rubyOre, new ItemStack(rubyIngot), 1000F);
		GameRegistry.addSmelting(zagraniteOre, new ItemStack(zagraniteIngot),
				1000F);

		ItemStack PointedSword = new ItemStack(zagraniteIngot);

		PointedSword.addEnchantment(Enchantment.sharpness, 5);

		GameRegistry.addShapelessRecipe(PointedSword,
				new Object[] { zagraniteIngot });

	}

	public void MyBlocks() {
		Block blackIce = new BlackIce(Material.ground);
		GameRegistry.registerBlock(blackIce, "Black Ice");
		GameRegistry.registerBlock(rubyOre, "archersore");
		GameRegistry.registerBlock(rubyBlock, "archersBlock");
		GameRegistry.registerBlock(zagraniteOre, "zagraniteore");
	}

	public void MyItems() {
		// Zagranite items
		GameRegistry.registerItem(zagraniteAxe, "Zagranite Axe");
		GameRegistry.registerItem(zagraniteBlade, "Zagranite Blade");
		GameRegistry.registerItem(zagranitePickaxe, "Zagranite Pickaxe");
		GameRegistry.registerItem(zagraniteIngot, "Zagranite Ingot");
		GameRegistry.registerItem(zagraniteSword, "Zagranite Sword");

		// Zagranite armor
		GameRegistry.registerItem(zagraniteBootsArmor, "Zagranite Boots");
		GameRegistry.registerItem(zagraniteChestplateArmor, "Zagranite Chest");
		GameRegistry.registerItem(zagraniteHelmetArmor, "Zagranite Helmet");
		GameRegistry.registerItem(zagraniteLeggingsArmor, "Zagranite Legs");

		// Miscellaneous custom stuff
		GameRegistry.registerItem(swordHandle, "Sword Handle");
		GameRegistry.registerItem(withersEndPick, "Wither's End Pick");

		// Ruby items
		GameRegistry.registerItem(rubyAxe, "Ruby Axe");
		GameRegistry.registerItem(rubyBlade, "Ruby Blade");
		GameRegistry.registerItem(rubyHoe, "Ruby Hoe");
		GameRegistry.registerItem(rubyIngot, "Ruby Ingot");
		GameRegistry.registerItem(rubyPickaxe, "Ruby Pickaxe");
		GameRegistry.registerItem(rubySpade, "Ruby Spade");
		GameRegistry.registerItem(rubySword, "Ruby Sword");

		// Ruby armor
		GameRegistry.registerItem(rubyBootsArmor, "Ruby Boots ARMOR");
		GameRegistry
				.registerItem(rubyChestplateArmor, "Ruby Chest Plate ARMOR");
		GameRegistry.registerItem(rubyHelmetArmor, "Ruby Helmet ARMOR");
		GameRegistry.registerItem(rubyLeggingsArmor, "Ruby Legs ARMOR");

		// GameRegistry.registerItem(rubyBoots, "Ruby Boots ITEM");
		// GameRegistry.registerItem(rubyChestplate, "Ruby Chest Plate ITEM");
		// GameRegistry.registerItem(rubyHelmet, "Ruby Helmet ITEM");
		// GameRegistry.registerItem(rubyLeggings, "Ruby Leggings ITEM");
	}
}
