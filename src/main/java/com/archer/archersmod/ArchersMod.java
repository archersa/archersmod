package com.archer.archersmod;

import net.minecraft.block.material.Material;

import com.archer.archersmod.blocks.ArchersBlock;
import com.archer.archersmod.blocks.BlackIce;
import com.archer.archersmod.blocks.HardDirt;
import com.archer.archersmod.blocks.Zagaraniteore;
import com.archer.archersmod.blocks.archersore;
import com.archer.archersmod.items.ArchersArmor;
import com.archer.archersmod.items.ArchersAxe;
import com.archer.archersmod.items.ArchersBoots;
import com.archer.archersmod.items.ArchersChestplate;
import com.archer.archersmod.items.ArchersHelmet;
import com.archer.archersmod.items.ArchersHoe;
import com.archer.archersmod.items.ArchersIngot;
import com.archer.archersmod.items.ArchersLeggings;
import com.archer.archersmod.items.ArchersPick;
import com.archer.archersmod.items.ArchersSpade;
import com.archer.archersmod.items.ArchersSword;
import com.archer.archersmod.items.RubyBlade;
import com.archer.archersmod.items.SwordHandle;
import com.archer.archersmod.items.WithersEndPick;
import com.sun.j3d.utils.scenegraph.io.state.javax.media.j3d.MaterialState;

import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
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
	
	public static final ToolMaterial RUBY =
			EnumHelper.addToolMaterial("RUBY", 3, 2000, 30.0F, 8.0F, 20);
	public static final ToolMaterial RUBY2 =
			EnumHelper.addToolMaterial("RUBY2", 3, 20000, 1000.0F, 8.0F, 20);
	public static final ArmorMaterial RUBY3 =
			EnumHelper.addArmorMaterial("RUBY3", 50, new int[]{4, 10, 8, 6}, 40);
	
	
	public static final Item rubyHelm = 
			new ArchersArmor(RUBY3, 5, 0).setUnlocalizedName("Ruby Helm");
	public static final Item rubyChest = 
		new ArchersArmor(RUBY3, 5, 1).setUnlocalizedName("Ruby Chest");
	public static final Item rubyLegs = 
		new ArchersArmor(RUBY3, 5, 2).setUnlocalizedName("Ruby Legs");
	public static final Item rubyBoots = 
			new ArchersArmor(RUBY3, 3, 3).setUnlocalizedName("Ruby Boots");
	

	
	public static final Block archersOre = new archersore(Material.ground);
	public static final Item archersIngot = new ArchersIngot();
	public static final Item archersPick = new ArchersPick(RUBY);
	public static final Item archersSword = new ArchersSword(RUBY);
	public static final Item archersAxe = new ArchersAxe(RUBY);
	public static final Item archersSpade = new ArchersSpade(RUBY);
	public static final Item archersHoe = new ArchersHoe(RUBY);
	public static final Block archersBlock = new ArchersBlock(Material.ground);
	public static final Item swordHandle = new SwordHandle();
	public static final Item rubyBlade = new RubyBlade();
	public static final Item archersHelmet = new ArchersHelmet(ArmorMaterial.DIAMOND, 3, 0);
	public static final Item archersChestplate = new ArchersChestplate(ArmorMaterial.DIAMOND, 3, 1);
	public static final Item archersLeggings = new ArchersLeggings(ArmorMaterial.DIAMOND, 3, 2);
	public static final Item archersBoots = new ArchersBoots(ArmorMaterial.DIAMOND, 3, 3);
	public static final Item withersEndPick = new WithersEndPick(RUBY2);
	public static final Block zagaraniteOre = new Zagaraniteore(Material.ground);
	
	
	
	
	
	@Instance(value = "ArchersMod")
	public static ArchersMod instance;
	@SidedProxy(clientSide = "com.archer.client.ClientProxy", serverSide = "com.archer.archersmod.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		RenderingRegistry.addNewArmourRendererPrefix("5");
		MyBlocks();
		MyRecipes();
		MyItems();
	}

	@EventHandler
	public void Init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new MyOreGenerator(), 1);
		
		proxy.registerRenderers();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	public void MyRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.activator_rail),
				new Object[] {Blocks.acacia_stairs, Blocks.vine});
		GameRegistry.addRecipe(new ItemStack(archersAxe), new Object[]
				{"AA ", "BA ", "B  ", 'A', archersIngot, 'B', Items.stick});
		GameRegistry.addRecipe(new ItemStack(archersPick), new Object []
				{"AAA"," B "," B ", 'A', archersIngot, 'B', Items.stick});
		GameRegistry.addRecipe(new ItemStack(archersSpade), new Object []
				{" A "," B "," B ", 'A', archersIngot, 'B', Items.stick});
		GameRegistry.addRecipe(new ItemStack(archersHoe), new Object []
				{"AA "," B "," B ", 'A', archersIngot, 'B', Items.stick});
		GameRegistry.addRecipe(new ItemStack(swordHandle), new Object []
				{"A  "," B ","A A", 'A', Items.stick, 'B', (new ItemStack(Items.skull, 1, 1))});
		GameRegistry.addRecipe(new ItemStack(rubyBlade), new Object []
				{" A ","CAC"," B ", 'A', archersIngot, 'B', archersBlock, 'C', Items.diamond});
		GameRegistry.addRecipe(new ItemStack(archersSword), new Object []
				{" A "," B ", 'A', rubyBlade, 'B', swordHandle});
		GameRegistry.addRecipe(new ItemStack(archersBlock), new Object []
				{"AAA","AAA","AAA", 'A', archersIngot});
		GameRegistry.addRecipe(new ItemStack(rubyHelm), new Object []
				{"AAA","A A", 'A', archersIngot});
		GameRegistry.addRecipe(new ItemStack(rubyChest), new Object []
				{"A A","AAA","AAA", 'A', archersIngot});
		GameRegistry.addRecipe(new ItemStack(rubyLegs), new Object []
				{"AAA","A A","A A",  'A', archersIngot});
		GameRegistry.addRecipe(new ItemStack(rubyBoots), new Object []
				{"A A","A A", 'A', archersIngot});



		
		
		
		
		GameRegistry.addSmelting(Items.beef,new ItemStack(Items.spawn_egg,1,90), 1000F);
		
		GameRegistry.addSmelting(archersOre,new ItemStack(archersIngot,1,90), 1000F);
		
		
		ItemStack Fishis = new ItemStack(Items.stick);
	
		Fishis.addEnchantment(Enchantment.knockback, 100);
	
		GameRegistry.addShapelessRecipe(Fishis, new Object[]{Items.stick});
		
		
	}
			
		public void MyBlocks()
		{
			Block blackIce = new BlackIce(Material.ground);
			GameRegistry.registerBlock(blackIce, "Black Ice");
			
			
			GameRegistry.registerBlock(archersOre, "archersore");
			
			GameRegistry.registerBlock(archersBlock, "archersBlock");
			
			GameRegistry.registerBlock(zagaraniteOre, "zagaraniteore");
			
			
			
			
		}
		public void MyItems()
		{
			
			GameRegistry.registerItem(archersIngot, "archersingot");
			
			GameRegistry.registerItem(archersPick, "archerspick");
			
			GameRegistry.registerItem(archersSword, "archerssword");
			
			GameRegistry.registerItem(archersAxe, "archersaxe");
			
			GameRegistry.registerItem(archersSpade, "archersspade");
			
			GameRegistry.registerItem(archersHoe, "archershoe");
			
			GameRegistry.registerItem(swordHandle, "swordhandle");
			
			GameRegistry.registerItem(rubyBlade, "rubyblade");
			
//			GameRegistry.registerItem(archersHelmet, "archershelmet");
//			
//			GameRegistry.registerItem(archersChestplate, "archerchestplate");
//			
//			GameRegistry.registerItem(archersLeggings, "archersleggings");
//			
//			GameRegistry.registerItem(archersBoots, "archersboots");
			
			GameRegistry.registerItem(withersEndPick, "withersendpick");
			
			GameRegistry.registerItem(rubyHelm, "Ruby Helmet");
			GameRegistry.registerItem(rubyChest, "Ruby Chest");
			GameRegistry.registerItem(rubyLegs, "Ruby Legs");
			GameRegistry.registerItem(rubyBoots, "Ruby Boots");
			
			
			

		}
		
	}


