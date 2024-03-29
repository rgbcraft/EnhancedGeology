package enhancedgeology.main.handlers;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import enhancedgeology.main.blocks.Blocks;
import enhancedgeology.main.items.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CraftingHandler {

	public static void AggiungiCrafting() {
			
		
		// QUARZO (Stack)
		ItemStack quarzoStack = appeng.api.Materials.matQuartzDust;
		ItemStack quarzoCristalloStack = appeng.api.Materials.matQuartz;
		
		
		ItemStack cell = ic2.api.Items.getItem("cell").copy();

			
		
		//Crafting con Ore Dictionary per la Bateia
		List <ItemStack> ores = OreDictionary.getOres("ingotRefinedIron");
		if ( ores.size() > 0 ) {
			ItemStack inox = ores.get(0);
			GameRegistry.addRecipe(new ItemStack(Items.Bateia), new Object[] {"   ", "# #", "###", '#', inox});
		} else {
			System.err.println("[EnhancedGeology] Impossibile registrare refinedIron, disabilitata bateia");
		}
		
		//Crafting con Ore Dictionary per l'acido solforico
		ores = OreDictionary.getOres("sulfuricAcid");
		if ( ores.size() > 0 ) {
			ItemStack H2SO4 = ores.get(0);
			GregtechCompat.addChemicalRecipe(new ItemStack(Items.U3O8, 1), H2SO4,
					new ItemStack(Items.UO2), 3600);
		} else {
			System.err.println("[EnhancedGeology] Impossibile registrare acido solforico, disabilitata recipe secondaria UO2");
		}
		
		//Crafting con Ore Dictionary per la fiamma ossidrica e il CuSO4
		ores = OreDictionary.getOres("ingotCopper");
		
		if ( ores.size() > 0 ) {
			ItemStack copper = ores.get(0);
					CraftingHelpers.addShapedOreRecipe(new ItemStack(Items.OxyFuelTorch, 1, 0), new Object[] { " C ", " I ", "AIO", 'C', "ingotCopper", 'I', Item.ingotIron, 'A', Items.AcetyleneCell, 'O', Items.OxygenCell});
					//Termite
					copper.stackSize = 3;
					GregtechCompat.addAlloySmelterRecipe(new ItemStack(Items.CopperOxide, 3), GregtechCompat.getGregTechItem(1, 2, 18), copper, 40, 3);
		} else {
			System.err.println("[EnhancedGeology] Impossibile registrare copperIngot, disabilitata fiamma ossidrica e Termite");
		}
		
		
		
		//BASIC OXYGEN STEELMAKING
		
		//Ossigeno Liquido
		ores = OreDictionary.getOres("molecule_2o");
		if ( ores.size() > 0 ) {
			ItemStack O2 = ores.get(0);
			GregtechCompat.addVacuumFreezerRecipe(O2, new ItemStack(Items.LOXCell), 600);
		} else {
			System.err.println("[EnhancedGeology] Impossibile registrare cella aria, disabilitate recipe per il BOS");
		}
		
		ores = OreDictionary.getOres("ingotSteel");
		if ( ores.size() > 0 ) {
			ItemStack steel = ores.get(0);
			steel.stackSize = 64;
			GregtechCompat.addBlastRecipe(new ItemStack(Item.ingotIron, 64), new ItemStack(Items.LOXCell, 10), steel, GregtechCompat.getGregTechItem(1, 10, 63), 2500, 1408, 1825);
			steel.stackSize = 1;
			GameRegistry.addRecipe(new ItemStack(Items.GlassHammer), new Object[] { "SIS", " I ", " I ", 'S', steel, 'I', Item.ingotIron});
		} else {
			System.err.println("[EnhancedGeology] Impossibile registrare acciaio, disabilitate recipe per il BOS");
		}
		
		//Ferro
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.IronScraps, 3), new Object[] {new ItemStack(Items.Ematite, 1), new ItemStack(Items.Magnetite, 1), GregtechCompat.getGregTechItem(1, 1, 3)});
		
		GregtechCompat.addBlastRecipe(new ItemStack(Items.IronScraps, 64), GregtechCompat.getGregTechItem(1, 16, 4), new ItemStack(Item.ingotIron, 64), GregtechCompat.getGregTechItem(1, 2, 63), 900, 1280, 1900);
		
		
		//ALLUMINIO
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.AlloyMixture2014, 1), new Object[] {
			GregtechCompat.getGregTechItem(1, 1, 243), 
			GregtechCompat.getGregTechItem(1, 1, 13),
			GregtechCompat.getGregTechItem(1, 1, 12),
			GregtechCompat.getGregTechItem(1, 1, 241),
			GregtechCompat.getGregTechItem(1, 1, 4)
		});
				
		
		GregtechCompat.addBlastRecipe(GregtechCompat.getGregTechItem(1, 64, 18),
				new ItemStack(Items.AlloyMixture2014, 5),
				new ItemStack(Items.Duralumin, 64),
				GregtechCompat.getGregTechItem(1, 5, 63),
				400, 1600, 950);
		ItemStack inox = ic2.api.Items.getItem("refinedIronIngot").copy();
		inox.stackSize = 64;
		
		GregtechCompat.addVacuumFreezerRecipe(new ItemStack(Items.Duralumin, 64), inox, 1500);
		
		//
		// RECIPE CRAFTING
		//

		/*
		 * STRUMENTI
		 */
		GameRegistry.addShapedRecipe(new ItemStack(Items.MartelloGeologo, 1),
				new Object[] { "III", " SI", " S ", 'S', Item.stick, 'I', ic2.api.Items.getItem("iridiumPlate") });

		GameRegistry.addShapedRecipe(new ItemStack(Items.Gravimetro),
				new Object[] { "CPC", "BGB", "ACW", 'C', ic2.api.Items.getItem("electronicCircuit"), 'P',
						GregtechCompat.getGregTechItem(3, 1, 1), 'B', Block.stoneButton, 'G', Block.thinGlass, 'A',
						ic2.api.Items.getItem("advancedCircuit"), 'W', ic2.api.Items.getItem("tinCableItem") });

		GameRegistry.addShapedRecipe(new ItemStack(Items.Conduttimetro),
				new Object[] { "CPC", "BGB", "ATW", 'C', ic2.api.Items.getItem("electronicCircuit"), 'P',
						GregtechCompat.getGregTechItem(3, 1, 1), 'B', Block.stoneButton, 'G', Block.thinGlass, 'A',
						ic2.api.Items.getItem("advancedCircuit"), 'T', ic2.api.Items.getItem("transformerUpgrade"), 'W',
						ic2.api.Items.getItem("tinCableItem") });

		GameRegistry.addShapedRecipe(new ItemStack(Items.ContatoreGeiger),
				new Object[] { "CPC", "LGM", "ATW", 'C', ic2.api.Items.getItem("electronicCircuit"), 'P',
						GregtechCompat.getGregTechItem(3, 1, 1), 'L', Block.lever, 'G', Block.thinGlass, 'A',
						ic2.api.Items.getItem("advancedCircuit"), 'T', ic2.api.Items.getItem("transformerUpgrade"), 'M',
						Items.Biotite, 'W', ic2.api.Items.getItem("tinCableItem") });
		/*
		 * BLOCCHI DECORATIVI
		 */

		// Quarziti e affini
		// Quarzite stock
		quarzoCristalloStack.stackSize = 1;
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.materiale, 1, 4),
				new Object[] { "   ", "QQ ", "QQ ", 'Q', quarzoCristalloStack });
		// Colonna di quarzite
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.materiale, 2, 6),
				new Object[] { "   ", " Q ", " Q ", 'Q', new ItemStack(Blocks.materiale, 1, 4) });
		// Mattone di quarzite
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.materiale, 4, 5),
				new Object[] { "   ", "QQ ", "QQ ", 'Q', new ItemStack(Blocks.materiale, 1, 4) });
		// Quarzite incisa
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.materiale, 4, 7),
				new Object[] { "   ", "Q Q", "Q Q", 'Q', new ItemStack(Blocks.materiale, 1, 4) });

		// Mattoni di tufo
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.materiale, 1, 3),
				new Object[] { "   ", "TT ", "TT ", 'T', new ItemStack(Blocks.roccia, 1, 6) });

		// Andesite levigata
		ic2.api.Ic2Recipes.addCompressorRecipe(new ItemStack(Blocks.roccia, 1, 0),
				new ItemStack(Blocks.materiale, 1, 0));

		// Diorite levigata
		ic2.api.Ic2Recipes.addCompressorRecipe(new ItemStack(Blocks.roccia, 1, 1),
				new ItemStack(Blocks.materiale, 1, 1));

		// Granito levigato
		ic2.api.Ic2Recipes.addCompressorRecipe(new ItemStack(Blocks.roccia, 1, 2),
				new ItemStack(Blocks.materiale, 1, 2));

		// Tetto Amianto
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.TettoAmianto, 16),
				new Object[] { "ACA", "CAC", "ACA", 'C', Items.Crisotilo, 'A', Item.clay });

		
		//Bateia 
		
		GameRegistry.addShapelessRecipe(new ItemStack(Item.goldNugget, 2), new Object[] {new ItemStack(Items.Bateia, 1, 100)});
		
		
	
		/*
		 * GREGTECH SINTASSI
		 * 
		 * getGregTechItem(TIPO, QTA, META)
		 * 
		 * TIPO: 1. Polveri 2. Celle
		 */
		
		//COMPATIBILITÀ PER IDIOZIE FATTE DAL CHICCO
		GameRegistry.addShapelessRecipe(new ItemStack(Block.oreGold, 1), new ItemStack(Block.oreGold, 1, 5));
		GameRegistry.addShapelessRecipe(new ItemStack(Block.oreIron, 1), new ItemStack(Block.oreIron, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.redstone, 1), new ItemStack(Item.redstone, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.diamond, 1), new ItemStack(Item.diamond, 1, 6));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.emerald, 1), new ItemStack(Item.emerald, 1, 4));

		
		/*
		 * RICETTE DECOMPOSIZIONE ROCCE
		 */

		// Stone -> CaCO3, SiO2
		GregtechCompat.addGrinderRecipe(new ItemStack(Block.stone, 64), 0, GregtechCompat.getGregTechItem(1, 50, 4),
				GregtechCompat.getGregTechItem(1, 13, 7), new ItemStack(Items.Ematite, 1), null);

		// Peridotite -> Olivina (37)
		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Blocks.roccia, 1, 3),
				GregtechCompat.getGregTechItem(1, 1, 37));

		// Peridotite -> 70% 44 Olivina, 20% 12 Alluminio, 10% 6 ematite, 1% 1 piropo
		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 64, 3), 0,
				GregtechCompat.getGregTechItem(1, 44, 37), GregtechCompat.getGregTechItem(1, 12, 18),
				new ItemStack(Items.Ematite, 6), GregtechCompat.getGregTechItem(1, 1, 56));

		// Serpentinite -> Serpentino
		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Blocks.roccia, 1, 7), new ItemStack(Items.Serpentino));

		// Serpentinite -> 60% 38 Serpentino, 15% 10 brucite, 20% 13 magnetite, 5% 3
		// Crisotilo
		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 64, 7), 0, new ItemStack(Items.Serpentino, 38),
				new ItemStack(Items.Brucite, 10), new ItemStack(Items.Magnetite, 13),
				new ItemStack(Items.Crisotilo, 3));

		// Kimberlite -> Olivina (37)
		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Blocks.roccia, 1, 9),
				GregtechCompat.getGregTechItem(1, 1, 37));

		// Kimberlite -> 85% 54 Olivina, 6% 4 almandino, 6% 4 piropo, 3% 2 diamante
		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 64, 9), 0,
				GregtechCompat.getGregTechItem(1, 54, 37), GregtechCompat.getGregTechItem(1, 4, 54),
				GregtechCompat.getGregTechItem(1, 4, 55), new ItemStack(Item.diamond, 3));

		// Diaspro -> Silice (7)
		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Blocks.roccia, 1, 5),
				GregtechCompat.getGregTechItem(1, 1, 7));

		// Diaspro -> 85% 54 silice, 9% 5 ematite, 4% 4 manganese, 2% 1 oro
		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 64, 5), 0,
				GregtechCompat.getGregTechItem(1, 54, 7), new ItemStack(Items.Ematite, 5),
				GregtechCompat.getGregTechItem(1, 4, 12), GregtechCompat.getGregTechItem(1, 1, 242));

		// Tufo -> Quarzo e Fluorite
		quarzoStack.stackSize = 60;
		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 64, 6), 0, new ItemStack(Items.Fluorite, 4),
				quarzoStack, null, null);

		quarzoStack.stackSize = 1;
		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Blocks.roccia, 1, 6), quarzoStack);

		// Ardesia -> Quarzo

		quarzoStack.stackSize = 30;
		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 64, 4), 0, quarzoStack,
				new ItemStack(Items.Muscovite, 12), new ItemStack(Items.Ematite, 20),
				GregtechCompat.getGregTechItem(1, 2, 4));

		quarzoStack.stackSize = 1;
		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Blocks.roccia, 1, 4), quarzoStack);

		// Diorite -> Feldspato

		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Blocks.roccia, 1, 3), new ItemStack(Items.Feldspato, 1));

		// Diorite -> 90% 59 Feldspato, 5% 3 Olivina, 2% 1 Magnetite, 2% 1 Titanio

		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 64, 1), 0, new ItemStack(Items.Feldspato, 59),
				GregtechCompat.getGregTechItem(1, 3, 37), new ItemStack(Items.Magnetite, 1),
				GregtechCompat.getGregTechItem(1, 1, 19));

		// Granito -> Ghiaia

		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Blocks.roccia, 1, 2), new ItemStack(Block.gravel, 1));

		// Granito -> 40% 26 di Silice, 40%, 26 Feldspato, 10% 6 biotite, 10% 6
		// orneblenda

		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 64, 2), 0, new ItemStack(Items.Feldspato, 26),
				GregtechCompat.getGregTechItem(1, 26, 7), new ItemStack(Items.Biotite, 6),
				new ItemStack(Items.Orneblenda, 6));

		// Gneiss -> Ghiaia

		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Blocks.roccia, 1, 8), new ItemStack(Block.gravel, 1));

		// Gneiss -> 40% 26 di Silice, 40%, 26 Feldspato, 10% 6 biotite, 10% 6
		// orneblenda

		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 64, 8), 0, new ItemStack(Items.Feldspato, 26),
				GregtechCompat.getGregTechItem(1, 26, 7), new ItemStack(Items.Biotite, 6),
				new ItemStack(Items.Orneblenda, 6));

		// Andesite -> Ghiaia

		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Blocks.roccia, 1, 0), new ItemStack(Block.gravel, 1));

		// Andesite -> 70% 47 di Feldspato,20% 12 di Silice, 5% 3 Magnetite, 2% 1
		// zircone

		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 64, 0), 0, new ItemStack(Items.Feldspato, 47),
				GregtechCompat.getGregTechItem(1, 12, 7), new ItemStack(Items.Magnetite, 3),
				new ItemStack(Items.Zircone, 1));

		/*
		 * METAMORFOSI DI ROCCE SEDIMENTARIE
		 */

		// Stone -> Ardesia (63: Dark Ashes)
		GregtechCompat.addImplosionRecipe(new ItemStack(Block.stone, 64), 2, new ItemStack(Blocks.roccia, 64, 4),
				GregtechCompat.getGregTechItem(1, 1, 63));

		// Peridotite -> Serpentinite (63: Dark Ashes)
		GregtechCompat.addImplosionRecipe(new ItemStack(Blocks.roccia, 64, 3), 2, new ItemStack(Blocks.roccia, 64, 7),
				GregtechCompat.getGregTechItem(1, 1, 63));

		// Granito -> Gneiss (63: Dark Ashes)
		GregtechCompat.addImplosionRecipe(new ItemStack(Blocks.roccia, 64, 2), 8, new ItemStack(Blocks.roccia, 64, 8),
				GregtechCompat.getGregTechItem(1, 1, 63));

		/*
		 * DECOMPOSIZIONE DI MINERALI
		 */

		// Serpentino -> 90% magnesio, 10% crisotilo
		GregtechCompat.addElectrolyzerRecipe(new ItemStack(Items.Serpentino, 64), 0,
				GregtechCompat.getGregTechItem(1, 51, 13), new ItemStack(Items.Crisotilo, 12), null, null, 160, 110);

		// Muscovite/Biotite -> 33% 22 Al, 33% 21 Si, 33% 21 K
		GregtechCompat.addElectrolyzerRecipe(new ItemStack(Items.Biotite, 64), 21,
				GregtechCompat.getGregTechItem(1, 22, 18), GregtechCompat.getGregTechItem(1, 21, 7),
				GregtechCompat.getGregTechItem(2, 21, 14), null, 1160, 110);
		GregtechCompat.addElectrolyzerRecipe(new ItemStack(Items.Muscovite, 64), 21,
				GregtechCompat.getGregTechItem(1, 22, 18), GregtechCompat.getGregTechItem(1, 21, 7),
				GregtechCompat.getGregTechItem(2, 21, 14), null, 1160, 110);

		// Feldspato -> 60% Si, 20% K, 20% Al

		GregtechCompat.addElectrolyzerRecipe(new ItemStack(Items.Feldspato, 64), 13,
				GregtechCompat.getGregTechItem(1, 13, 18), GregtechCompat.getGregTechItem(1, 38, 7),
				GregtechCompat.getGregTechItem(2, 13, 14), null, 1220, 95);

		// Orneblenda: 25% Mg, 25% Fe, 25% Al, 25% Ca.

		GregtechCompat.addElectrolyzerRecipe(new ItemStack(Items.Orneblenda, 64), 16,
				GregtechCompat.getGregTechItem(1, 16, 241), GregtechCompat.getGregTechItem(1, 16, 13),
				GregtechCompat.getGregTechItem(2, 16, 11), GregtechCompat.getGregTechItem(1, 16, 18), 1290, 90);

		// Brucite: 63 Mg, 1 Ir

		GregtechCompat.addElectrolyzerRecipe(new ItemStack(Items.Brucite, 32), 0,
				GregtechCompat.getGregTechItem(1, 63, 13), GregtechCompat.getGregTechItem(5, 1, 16), null, null, 10460,
				65);

		// Magnetite:

		GregtechCompat.addElectrolyzerRecipe(new ItemStack(Items.Magnetite, 64), 0,
				GregtechCompat.getGregTechItem(1, 46, 241), GregtechCompat.getGregTechItem(1, 18, 63), null, null, 1400,
				70);

		// Ematite:

		GregtechCompat.addElectrolyzerRecipe(new ItemStack(Items.Ematite, 64), 0,
				GregtechCompat.getGregTechItem(1, 30, 241), GregtechCompat.getGregTechItem(1, 34, 63), null, null, 1400,
				70);

		// Fluorite:

		GregtechCompat.addElectrolyzerRecipe(new ItemStack(Items.Fluorite, 3), 4, new ItemStack(Items.Fluoro, 2),
				GregtechCompat.getGregTechItem(2, 2, 11), null, null, 6500, 45);

		//Decomposizione CuSO4
		
		GameRegistry.addSmelting(Items.CopperSulfate.itemID, new ItemStack(Items.CopperOxide, 1), 0.30f);
		
		/*
		 * PARTE RADIOLOGICA
		 */
		
		
		// SVUOTAMENTO CELLE TRAMITE REAZIONE DI IDROLISI IN EAF (con produzione di Idrogeno)
		
		//NON DOCUMENTATO: reactorUraniumSimple, Dual e Quad
		//HEU
		ItemStack waterCellStack = ic2.api.Items.getItem("waterCell").copy();				
		GregtechCompat.addBlastRecipe(new ItemStack(Items.HECell, 1), waterCellStack, new ItemStack(Items.HEU, 1), GregtechCompat.getGregTechItem(2, 1, 0), 700, 440, 1060);
		waterCellStack.stackSize = 2;
		GregtechCompat.addBlastRecipe(new ItemStack(Items.HECellx2, 1), waterCellStack, new ItemStack(Items.HEU, 2), GregtechCompat.getGregTechItem(2, 2, 0), 600, 440, 1060);
		waterCellStack.stackSize = 4;
		GregtechCompat.addBlastRecipe(new ItemStack(Items.HECellx4, 1), waterCellStack, new ItemStack(Items.HEU, 4), GregtechCompat.getGregTechItem(2, 4, 0), 500, 440, 1060);
		
		//LEU e naturali con ricetta con dissoluzione di Cu in H2SO4
		GregtechCompat.addBlastRecipe(new ItemStack(Items.LECell, 1), GregtechCompat.getGregTechItem(2, 1, 40), new ItemStack(Items.LEU, 1), new ItemStack(Items.CopperSulfate, 2), 700, 20, 400);
		GregtechCompat.addBlastRecipe(new ItemStack(Items.LECellx2, 1), GregtechCompat.getGregTechItem(2, 2, 40), new ItemStack(Items.LEU, 2), new ItemStack(Items.CopperSulfate, 4), 600, 20, 400);
		GregtechCompat.addBlastRecipe(new ItemStack(Items.LECellx4, 1), GregtechCompat.getGregTechItem(2, 4, 40), new ItemStack(Items.LEU, 4), new ItemStack(Items.CopperSulfate, 6), 500, 20, 400);
		
		ItemStack uraniumIngot = ic2.api.Items.getItem("uraniumIngot").copy();				
		GregtechCompat.addBlastRecipe(ic2.api.Items.getItem("reactorUraniumSimple"), GregtechCompat.getGregTechItem(2, 1, 40), uraniumIngot, new ItemStack(Items.CopperSulfate, 2), 700, 20, 400);
		uraniumIngot.stackSize = 2;
		GregtechCompat.addBlastRecipe(ic2.api.Items.getItem("reactorUraniumDual"), GregtechCompat.getGregTechItem(2, 4, 40), uraniumIngot, new ItemStack(Items.CopperSulfate, 8), 600, 20, 400);
		uraniumIngot.stackSize = 4;
		GregtechCompat.addBlastRecipe(ic2.api.Items.getItem("reactorUraniumQuad"), GregtechCompat.getGregTechItem(2, 12, 40), uraniumIngot, new ItemStack(Items.CopperSulfate, 24), 500, 20, 400);
	
		
		// Uranite -> U3O8
		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 5, 10), 0,
				GregtechCompat.getGregTechItem(1, 2, 244), GregtechCompat.getGregTechItem(1, 2, 23),
				new ItemStack(Items.U3O8, 1), null);

		// U3O8 -> UO2
		GregtechCompat.addChemicalRecipe(new ItemStack(Items.U3O8, 1), GregtechCompat.getGregTechItem(2, 1, 40),
				new ItemStack(Items.UO2), 3600);
		
		// ULE + Pu dust -> MOXIngot
		
		GregtechCompat.addBlastRecipe(new ItemStack(Items.LEU, 44), GregtechCompat.getGregTechItem(1,  20, 81), new ItemStack(Items.MOX, 64), GregtechCompat.getGregTechItem(1, 1, 62), 600, 3100, 1400);

		// U naturale -> UO2
		GregtechCompat.addBlastRecipe(ic2.api.Items.getItem("uraniumIngot"), GregtechCompat.getGregTechItem(1, 1, 4),
				new ItemStack(Items.UO2), null, 1200, 95, 973);		
		GregtechCompat.addBlastRecipe(new ItemStack(Items.LEU), GregtechCompat.getGregTechItem(1, 1, 4),
				new ItemStack(Items.UO2), null, 1200, 95, 973);
		GregtechCompat.addBlastRecipe(new ItemStack(Items.HEU), GregtechCompat.getGregTechItem(1, 1, 4),
				new ItemStack(Items.UO2), null, 1200, 95, 973);

		// UO2 -> U naturale
		GregtechCompat.addBlastRecipe(new ItemStack(Items.UO2, 1), GregtechCompat.getGregTechItem(2, 1, 0),
				ic2.api.Items.getItem("uraniumIngot"), ic2.api.Items.getItem("waterCell"), 1200, 95, 973);
		
		// UO2 -> UF6
	
		
		GregtechCompat.addChemicalRecipe(new ItemStack(Items.UO2, 64), new ItemStack(Items.Fluoro, 1),
				new ItemStack(Items.UF6Nat, 64), 3100);

		// UF6 -> UF6LE
		GregtechCompat.addCentrifugeRecipe(new ItemStack(Items.UF6Nat, 1), 0, new ItemStack(Items.UF6LE), null, null,
				null, 6000);

		// UF6LE -> UF6HE
		GregtechCompat.addCentrifugeRecipe(new ItemStack(Items.UF6LE, 1), 0, new ItemStack(Items.UF6HE), null, null,
				null, 72000);
		
		// UF6LE -> UF6MGE
		GregtechCompat.addCentrifugeRecipe(new ItemStack(Items.UF6HE, 1), 0, new ItemStack(Items.UF6MGE), null, null,
				null, 10000);
		
		
		// UF6LE -> LEU

		ic2.api.Ic2Recipes.addExtractorRecipe(new ItemStack(Items.UF6LE), new ItemStack(Items.LEU));

		// UF6HE -> HEU

		ic2.api.Ic2Recipes.addExtractorRecipe(new ItemStack(Items.UF6HE), new ItemStack(Items.HEU));

		// UF6MGE -> MGEU
		
		ic2.api.Ic2Recipes.addExtractorRecipe(new ItemStack(Items.UF6MGE), new ItemStack(Items.MGEU));

		
		// LEU -> LECell

		GregtechCompat.addCannerRecipe(new ItemStack(Items.LEU), ic2.api.Items.getItem("cell"),
				new ItemStack(Items.LECell), null, 150, 45);

		// HEU -> HECell

		GregtechCompat.addCannerRecipe(new ItemStack(Items.HEU), ic2.api.Items.getItem("cell"),
				new ItemStack(Items.HECell), null, 150, 45);
		
		// MGEU -> MGECell
		
		GregtechCompat.addCannerRecipe(new ItemStack(Items.MGEU), ic2.api.Items.getItem("cell"),
				new ItemStack(Items.MGECell), null, 150, 70);
		
		// MOX -> MOXCell
		
		GregtechCompat.addCannerRecipe(new ItemStack(Items.MOX), ic2.api.Items.getItem("cell"),
				new ItemStack(Items.MOXCell), null, 150, 110);

		// Zircone -> Zirconio
		GregtechCompat.addElectrolyzerRecipe(new ItemStack(Items.Zircone, 3), 0, new ItemStack(Items.Zirconio, 1),
				GregtechCompat.getGregTechItem(1, 2, 7), null, null, 4800, 95);

		// Zirconio -> Zircaloy
		GregtechCompat.addBlastRecipe(new ItemStack(Items.Zirconio, 63), GregtechCompat.getGregTechItem(1, 1, 244),
				new ItemStack(Items.Zircaloy, 64), null, 6500, 20, 2250);

		// Zircaloy -> ZircaloyPlate
		GregtechCompat.addBenderRecipe(new ItemStack(Items.Zircaloy, 1), new ItemStack(Items.ZircaloyPlate, 8), 800,
				32);

		// LECell -> LECellx2
		GameRegistry.addShapedRecipe(new ItemStack(Items.LECellx2, 1),
				new Object[] { "CPC", "   ", "   ", 'C', Items.LECell, 'P', GregtechCompat.getGregTechItem(0, 1, 68) });

		// LECellx2 -> LECellx4
		GameRegistry.addShapedRecipe(new ItemStack(Items.LECellx4, 1), new Object[] { " C ", "PPP", " C ", 'C',
				Items.LECellx2, 'P', GregtechCompat.getGregTechItem(0, 1, 68) });

		// HECell -> HECellx2
		GameRegistry.addShapedRecipe(new ItemStack(Items.HECellx2, 1),
				new Object[] { "CPC", "   ", "   ", 'C', Items.HECell, 'P', Items.ZircaloyPlate });

		// HECellx2 -> HECellx4
		GameRegistry.addShapedRecipe(new ItemStack(Items.HECellx4, 1),
				new Object[] { " C ", "PPP", " C ", 'C', Items.HECellx2, 'P', Items.ZircaloyPlate });
		
		// MGECell -> MGECellx2
				GameRegistry.addShapedRecipe(new ItemStack(Items.MGECellx2, 1),
						new Object[] { "CPC", "   ", "   ", 'C', Items.MGECell, 'P', Items.ZircaloyPlate });

		// MGECellx2 -> MGECellx4
		GameRegistry.addShapedRecipe(new ItemStack(Items.MGECellx4, 1),
						new Object[] { " C ", "PPP", " C ", 'C', Items.MGECellx2, 'P', Items.ZircaloyPlate });
		
		// MOXCell -> MOXCellx2
		GameRegistry.addShapedRecipe(new ItemStack(Items.MOXCellx2, 1),
				new Object[] { "CPC", "   ", "   ", 'C', Items.MOXCell, 'P', Items.ZircaloyPlate });

		// MOXCellx2 -> MOXCellx4
		GameRegistry.addShapedRecipe(new ItemStack(Items.MOXCellx4, 1),
				new Object[] { " C ", "PPP", " C ", 'C', Items.MOXCellx2, 'P', Items.ZircaloyPlate });
		
		//TRAPANO A BENZINA
		
		GameRegistry.addShapedRecipe(new ItemStack(Items.GasDrill, 1, Items.GasDrill.getMaxDamage() - 1),
				new Object [] { 
					" # ", "#C#", "#P#",
					'#', GregtechCompat.getGregTechItem(0, 1, 83),
					'C', ic2.api.Items.getItem("electronicCircuit"),
					'P', Block.pistonBase
				});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.GasDrill, 1, 0), new Object[] {new ItemStack(Items.Miscela, 1), new ItemStack(Items.GasDrill, 1, Items.GasDrill.getMaxDamage() - 1)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.OxyFuelTorch, 1, 0), new Object[] {new ItemStack(Items.AcetyleneCell), new ItemStack(Items.OxygenCell), new ItemStack(Items.OxyFuelTorch, 1, Items.OxyFuelTorch.getMaxDamage() - 1)});

		GameRegistry.addSmelting(Items.LOXCell.itemID, new ItemStack(Items.OxygenCell, 4, 0), 0.3f);
		
		GregtechCompat.addChemicalRecipe(GregtechCompat.getGregTechItem(2, 1, 9), GregtechCompat.getGregTechItem(2, 1, 9), new ItemStack(Items.AcetyleneCell), 100);
		
		
		
	
		
		// TRAPANO 
		
		ic2.api.Ic2Recipes.addCraftingRecipe(new ItemStack(Items.HammerDrill, 1),
				new Object [] {
						" S ", "S# ", " S ",
						'#', ic2.api.Items.getItem("miningDrill"),
						'S', GregtechCompat.getGregTechItem(0, 1, 6) 
				});
		
		ic2.api.Ic2Recipes.addCraftingRecipe(new ItemStack(Items.SDSHammerDrill, 1),
				new Object [] {
						" S ", "S# ", " S ",
						'#', ic2.api.Items.getItem("diamondDrill"),
						'S', GregtechCompat.getGregTechItem(0, 1, 6) 
				});
		
		cell.stackSize = 1;	
		GregtechCompat.addCannerRecipe(ic2.api.Items.getItem("filledFuelCan"), GregtechCompat.getGregTechItem(2, 1, 24),
		new ItemStack(Items.Miscela, 1), cell, 100, 1);
		
		cell.stackSize = 8;
		GregtechCompat.addCannerRecipe(ic2.api.Items.getItem("fuelCan"),
				GregtechCompat.getGregTechItem(2, 8, 35),
		new ItemStack(Items.Miscela, 1), cell, 100, 1);
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.stoneStairs, 4), new Object[] {
				"  #", " ##", "###",
				'#', new ItemStack(Block.stone, 1)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.andesiteStairs, 4), new Object[] {
				"  #", " ##", "###",
				'#', new ItemStack(Blocks.roccia, 1, 0)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.dioriteStairs, 4), new Object[] {
				"  #", " ##", "###",
				'#', new ItemStack(Blocks.roccia, 1, 1)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.graniteStairs, 4), new Object[] {
				"  #", " ##", "###",
				'#', new ItemStack(Blocks.roccia, 1, 2)
		});
		
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.polishedAndesiteStairs, 4), new Object[] {
				"  #", " ##", "###",
				'#', new ItemStack(Blocks.materiale, 1, 0)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.polishedDioriteStairs, 4), new Object[] {
				"  #", " ##", "###",
				'#', new ItemStack(Blocks.materiale, 1, 1)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.polishedGraniteStairs, 4), new Object[] {
				"  #", " ##", "###",
				'#', new ItemStack(Blocks.materiale, 1, 2)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.ardesiaStairs, 4), new Object[] {
				"  #", " ##", "###",
				'#', new ItemStack(Blocks.roccia, 1, 4)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.quarziteStairs, 4), new Object[] {
				"  #", " ##", "###",
				'#', new ItemStack(Blocks.materiale, 1, 4)
		});
		
		//slab
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.rocciaSingleSlab, 6, 0), new Object[] {
				"###", "   ", "   ",
				'#', new ItemStack(Blocks.roccia, 1, 0)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.rocciaSingleSlab, 6, 1), new Object[] {
				"###", "   ", "   ",
				'#', new ItemStack(Blocks.roccia, 1, 1)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.rocciaSingleSlab, 6, 2), new Object[] {
				"###", "   ", "   ",
				'#', new ItemStack(Blocks.roccia, 1, 2)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.rocciaSingleSlab, 6, 3), new Object[] {
				"###", "   ", "   ",
				'#', new ItemStack(Block.stone, 1)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.rocciaSingleSlab, 6, 4), new Object[] {
				"###", "   ", "   ",
				'#', new ItemStack(Blocks.roccia, 1, 4)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.rocciaSingleSlab, 6, 5), new Object[] {
				"###", "   ", "   ",
				'#', new ItemStack(Blocks.roccia, 1, 5)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.rocciaSingleSlab, 6, 6), new Object[] {
				"###", "   ", "   ",
				'#', new ItemStack(Blocks.roccia, 1, 6)
		});
		
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.materialeSingleSlab, 6, 0), new Object[] {
				"###", "   ", "   ",
				'#', new ItemStack(Blocks.materiale, 1, 0)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.materialeSingleSlab, 6, 1), new Object[] {
				"###", "   ", "   ",
				'#', new ItemStack(Blocks.materiale, 1, 1)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.materialeSingleSlab, 6, 2), new Object[] {
				"###", "   ", "   ",
				'#', new ItemStack(Blocks.materiale, 1, 2)
		});
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.materialeSingleSlab, 6, 3), new Object[] {
				"###", "   ", "   ",
				'#', new ItemStack(Blocks.materiale, 1, 3)
		});
		
	}
}
