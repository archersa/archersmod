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
import com.archer.archersmod.blocks.ZagOre;
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
import com.archer.archersmod.items.ZagArmor;
import com.archer.archersmod.items.ZagAxe;
import com.archer.archersmod.items.ZagBlade;
import com.archer.archersmod.items.ZagHoe;
import com.archer.archersmod.items.ZagIngot;
import com.archer.archersmod.items.ZagPickaxe;
import com.archer.archersmod.items.ZagSpade;
import com.archer.archersmod.items.ZagSword;

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

	public static final Item zagHelmetArmor = new ZagArmor(RUBY3, 5, 0)
			.setUnlocalizedName("zag_helmet_armor");
	public static final Item zagChestplateArmor = new ZagArmor(RUBY3, 5, 1)
			.setUnlocalizedName("zag_chestplate_armor");
	public static final Item zagLeggingsArmor = new ZagArmor(RUBY3, 5, 2)
			.setUnlocalizedName("zag_leggings_armor");
	public static final Item zagBootsArmor = new ZagArmor(RUBY3, 5, 3)
			.setUnlocalizedName("zag_boots_armor");

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

	public static final Item withersEndPick = new WithersEndPick(RUBY2);
	public static final Block zagOre = new ZagOre(Material.ground);
	public static final Item zagIngot = new ZagIngot();
	public static final Item zagSword = new ZagSword(RUBY);
	// public static final Item itemBlasterRifle = new ItemBlasterRifle(null);
	public static final Item zagBlade = new ZagBlade();
	public static final Item zagAxe = new ZagAxe(RUBY);
	public static final Item zagPickaxe = new ZagPickaxe(RUBY);
	public static final Item zagSpade = new ZagSpade(RUBY);
	public static final Item zagHoe = new ZagHoe(RUBY);

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
		GameRegistry.addRecipe(new ItemStack(rubyAxe), new Object[] {
				"BB ", "BA "," A ", 'A', Items.stick, 'B', rubyIngot });
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
		GameRegistry.addRecipe(new ItemStack(zagSword), new Object[] { " A ",
				" B ", 'A', zagBlade, 'B', swordHandle });
		GameRegistry.addRecipe(new ItemStack(zagAxe), new Object[] {
			"BB ", "BA "," A ", 'A', Items.stick, 'B', zagIngot });
		GameRegistry.addRecipe(new ItemStack(zagPickaxe), new Object[] {
			"BBB", " A "," A ", 'A', Items.stick, 'B', zagIngot });
		GameRegistry.addRecipe(new ItemStack(zagSpade), new Object[] {
			" B ", " A "," A ", 'A', Items.stick, 'B', zagIngot });
		GameRegistry.addRecipe(new ItemStack(zagHoe), new Object[] {
			"BB ", " A "," A ", 'A', Items.stick, 'B', zagIngot });
		GameRegistry.addRecipe(new ItemStack(zagBlade), new Object[] {
			 " AA"," AA", 'A', zagIngot });
		GameRegistry.addRecipe(new ItemStack(withersEndPick), new Object[] {
			"CAB", " D "," D ", 'A', Items.diamond, 'B', Items.nether_star, 'C', Blocks.dragon_egg, 'D', Items.stick });
		GameRegistry.addRecipe(new ItemStack(zagChestplateArmor), new Object[] {
			"B B", "BBB","BBB", 'B', zagIngot });
		GameRegistry.addRecipe(new ItemStack(zagLeggingsArmor), new Object[] {
			"BBB", "B B","B B", 'B', zagIngot });
		GameRegistry.addRecipe(new ItemStack(zagHelmetArmor), new Object[] {
			"BBB", "B B", 'B', zagIngot });
		GameRegistry.addRecipe(new ItemStack(zagBootsArmor), new Object[] {
			"B B", "B B", 'B', zagIngot });


		GameRegistry.addSmelting(rubyOre, new ItemStack(rubyIngot), 1000F);
		GameRegistry.addSmelting(zagOre, new ItemStack(zagIngot), 1000F);

		ItemStack PointedSword = new ItemStack(zagIngot);

		PointedSword.addEnchantment(Enchantment.sharpness, 5);

		GameRegistry
				.addShapelessRecipe(PointedSword, new Object[] { zagIngot });

	}

	public void MyBlocks() {
		Block blackIce = new BlackIce(Material.ground);
		GameRegistry.registerBlock(blackIce, "black_ice");
		GameRegistry.registerBlock(rubyOre, "ruby_ore");
		GameRegistry.registerBlock(rubyBlock, "ruby_block");
		GameRegistry.registerBlock(zagOre, "zag_ore");
	}

	public void MyItems() {
		// Zag items
		GameRegistry.registerItem(zagAxe, "zag_axe");
		GameRegistry.registerItem(zagBlade, "zag_blade");
		GameRegistry.registerItem(zagPickaxe, "zag_pickaxe");
		GameRegistry.registerItem(zagIngot, "zag_ingot");
		GameRegistry.registerItem(zagSword, "zag_sword");
		GameRegistry.registerItem(zagSpade, "zag_spade");
		GameRegistry.registerItem(zagHoe, "zag_Hoe");

		// Zag armor
		GameRegistry.registerItem(zagBootsArmor, "zag_boots_armor");
		GameRegistry.registerItem(zagChestplateArmor, "zag_chestplate_armor");
		GameRegistry.registerItem(zagHelmetArmor, "zag_helmet_armor");
		GameRegistry.registerItem(zagLeggingsArmor, "zag_leggings_armor");

		// Miscellaneous custom stuff
		GameRegistry.registerItem(swordHandle, "sword_handle");
		GameRegistry.registerItem(withersEndPick, "withers_end_pick");

		// Ruby items
		GameRegistry.registerItem(rubyAxe, "ruby_axe");
		GameRegistry.registerItem(rubyBlade, "ruby_blade");
		GameRegistry.registerItem(rubyHoe, "ruby_hoe");
		GameRegistry.registerItem(rubyIngot, "ruby_ingot");
		GameRegistry.registerItem(rubyPickaxe, "ruby_pickaxe");
		GameRegistry.registerItem(rubySpade, "ruby_spade");
		GameRegistry.registerItem(rubySword, "ruby_sword");

		// Ruby armor
		GameRegistry.registerItem(rubyBootsArmor, "ruby_boots_armor");
		GameRegistry.registerItem(rubyChestplateArmor, "ruby_chestplate_armor");
		GameRegistry.registerItem(rubyHelmetArmor, "ruby_helmet_armor");
		GameRegistry.registerItem(rubyLeggingsArmor, "ruby_leggings_armor");
	}
}
