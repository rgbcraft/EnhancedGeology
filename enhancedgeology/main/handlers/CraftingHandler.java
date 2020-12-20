package enhancedgeology.main.handlers;

import cpw.mods.fml.common.registry.GameRegistry;
import enhancedgeology.main.blocks.Blocks;
import enhancedgeology.main.items.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CraftingHandler {
	public static void AggiungiCrafting() {
		
		
		//QUARZO (Stack)
		ItemStack quarzoStack = appeng.api.Materials.matQuartzDust;
		ItemStack quarzoCristalloStack = appeng.api.Materials.matQuartz;
		//
		// RECIPE CRAFTING
		//	
		
		/*
		 * STRUMENTI
		 */
		GameRegistry.addShapedRecipe(new ItemStack(Items.MartelloGeologo, 1),
				new Object[] { "III", " SI", " S ", 'S', Item.stick, 'I', ic2.api.Items.getItem("iridiumPlate")});		
		
		/*
		 * BLOCCHI DECORATIVI
		 */
		
		//Quarziti e affini
		//Quarzite stock
		quarzoCristalloStack.stackSize = 1;
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.materiale, 1, 4), 
				new Object[] { "   ", "QQ ", "QQ ", 'Q', quarzoCristalloStack});
		//Colonna di quarzite
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.materiale, 2, 6) ,
				new Object[] { "   ", " Q ", " Q ", 'Q', new ItemStack(Blocks.materiale, 1, 4)});
		//Mattone di quarzite
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.materiale, 1, 5), 
				new Object[] { "   ", "QQ ", "QQ ", 'Q', new ItemStack(Blocks.materiale, 1, 4)});
		//Quarzite incisa
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.materiale, 1, 7), 
				new Object[] { "   ", "Q Q", "Q Q", 'Q', new ItemStack(Blocks.materiale, 1, 4)});
		
		//Mattoni di tufo
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.materiale, 1, 3), 
				new Object[] { "   ", "TT ", "TT ", 'T', new ItemStack(Blocks.roccia, 1, 6)});
		
		//Andesite levigata
		ic2.api.Ic2Recipes.addCompressorRecipe(new ItemStack(Blocks.roccia, 1, 0), new ItemStack(Blocks.materiale, 1, 0));
		
		//Diorite levigata
		ic2.api.Ic2Recipes.addCompressorRecipe(new ItemStack(Blocks.roccia, 1, 1), new ItemStack(Blocks.materiale, 1, 1));
		
		//Granito levigato
		ic2.api.Ic2Recipes.addCompressorRecipe(new ItemStack(Blocks.roccia, 1, 3), new ItemStack(Blocks.materiale, 1, 3));
		
		//Tetto Amianto
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.TettoAmianto, 16),
				new Object[] {"ACA", "CAC", "ACA", 'C', Items.Crisotilo, 'A', Item.clay});
		
		
		/*
		 * GREGTECH SINTASSI
		 * 
		 * getGregTechItem(TIPO, QTA, META)
		 * 
		 * TIPO:
		 * 1. Polveri
		 * 2. Celle
		 */

		/*
		 * RICETTE DECOMPOSIZIONE ROCCE
		 */
		
		//Peridotite -> Olivina (37)
		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Blocks.roccia, 1, 3),
				GregtechCompat.getGregTechItem(1, 1, 37));
		
		//Peridotite -> 70% 44 Olivina, 20% 12 Alluminio, 10% 6 ematite, 1% 1 piropo
		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 64, 3), 0,
				GregtechCompat.getGregTechItem(1, 44, 37), GregtechCompat.getGregTechItem(1, 12, 18),
				new ItemStack(Items.Ematite, 6), GregtechCompat.getGregTechItem(1, 1, 56));
		
		//Serpentinite -> Serpentino
		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Blocks.roccia, 1, 7),
				new ItemStack(Items.Serpentino));
		
		//Serpentinite -> 60% 38 Serpentino, 15% 10 brucite, 20% 13 magnetite, 5% 3 Crisotilo
		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 64, 7), 0,
				new ItemStack(Items.Serpentino, 38), new ItemStack(Items.Brucite, 10),
				new ItemStack(Items.Magnetite, 13), new ItemStack(Items.Crisotilo, 3));
		
		//Kimberlite -> Olivina (37)
		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Blocks.roccia, 1, 9),
				GregtechCompat.getGregTechItem(1, 1, 37));
		
		//Kimberlite -> 85% 54  Olivina, 6% 4 almandino, 6% 4 piropo, 3% 2 diamante
		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 64, 9), 0,
				GregtechCompat.getGregTechItem(1, 54, 37), GregtechCompat.getGregTechItem(1, 4, 57),
				GregtechCompat.getGregTechItem(1, 4, 56), new ItemStack(Item.diamond, 3));
		
		//Diaspro -> Silice (7)
		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Blocks.roccia, 1, 5), 
				GregtechCompat.getGregTechItem(1, 1, 7));
		
		//Diaspro -> 85% 54 silice, 9% 5 ematite, 4% 4 manganese, 2% 1 oro
		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 64, 5), 0,
				GregtechCompat.getGregTechItem(1, 54, 7), new ItemStack(Items.Ematite, 5),
				GregtechCompat.getGregTechItem(1, 4, 12), GregtechCompat.getGregTechItem(1, 1, 242));
		
		//Tufo -> Quarzo e Fluorite
		quarzoStack.stackSize = 60;
		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 64, 6), 0,
				new ItemStack(Items.Fluorite, 4), quarzoStack, null, null);
		
		quarzoStack.stackSize = 1;
		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Blocks.roccia, 1, 6),
				quarzoStack);
				
		//Ardesia -> Quarzo
		
		quarzoStack.stackSize = 30;
		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 64, 4), 0,
				quarzoStack, new ItemStack(Items.Muscovite, 12), new ItemStack(Items.Ematite, 20), GregtechCompat.getGregTechItem(1, 2, 4));
		
		quarzoStack.stackSize = 1;
		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Blocks.roccia, 1, 4),
				quarzoStack);
		
		//Diorite -> Feldspato
		
		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Blocks.roccia, 1, 3), new ItemStack(Items.Feldspato, 1));
		
		//Diorite -> 90% 59 Feldspato, 5% 3 Olivina, 2% 1 Magnetite, 2% 1 Titanio
		
		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 64, 1), 0,
				new ItemStack(Items.Feldspato, 59), GregtechCompat.getGregTechItem(1, 3, 37),
				new ItemStack(Items.Magnetite, 1), GregtechCompat.getGregTechItem(1, 1, 19));
		
		//Granito -> Ghiaia
		
		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Blocks.roccia, 1, 2), new ItemStack(Block.gravel, 1));
		
		//Granito -> 40%  26 di Silice, 40%, 26 Feldspato, 10% 6 biotite, 10% 6 orneblenda
		
		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 64, 2), 0,
				new ItemStack(Items.Feldspato, 26), GregtechCompat.getGregTechItem(1, 26, 7),
				new ItemStack(Items.Biotite, 6), new ItemStack(Items.Orneblenda, 6));
		
		//Gneiss -> Ghiaia
		
		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Blocks.roccia, 1, 8), new ItemStack(Block.gravel, 1));
		
		//Gneiss -> 40%  26 di Silice, 40%, 26 Feldspato, 10% 6 biotite, 10% 6 orneblenda
		
		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 64, 8), 0,
				new ItemStack(Items.Feldspato, 26), GregtechCompat.getGregTechItem(1, 26, 7),
				new ItemStack(Items.Biotite, 6), new ItemStack(Items.Orneblenda, 6));
		
		//Andesite -> Ghiaia
		
		ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Blocks.roccia, 1, 0), new ItemStack(Block.gravel, 1));

		//Andesite -> 70%  47 di Feldspato,20% 12 di Silice, 5% 3 Magnetite, 2%  1 zircone 
		
		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 64, 0), 0,
				new ItemStack(Items.Feldspato, 47), GregtechCompat.getGregTechItem(1, 12, 7),
				new ItemStack(Items.Magnetite, 3), new ItemStack(Items.Zircone, 1));
		
		/*
		 * METAMORFOSI DI ROCCE SEDIMENTARIE
		 */

		//Stone -> Ardesia (63: Dark Ashes)
		GregtechCompat.addImplosionRecipe(new ItemStack(Block.stone), 2,
				new ItemStack(Blocks.roccia, 1, 4), GregtechCompat.getGregTechItem(1, 1, 63));
		
		//Peridotite -> Serpentinite (63: Dark Ashes)
		GregtechCompat.addImplosionRecipe(new ItemStack(Blocks.roccia, 1, 3), 2,
				new ItemStack(Blocks.roccia, 1, 7), GregtechCompat.getGregTechItem(1, 1, 63));
		
		//Granito -> Gneiss (63: Dark Ashes)
		GregtechCompat.addImplosionRecipe(new ItemStack(Blocks.roccia, 1, 3), 2,
				new ItemStack(Blocks.roccia, 1, 4), GregtechCompat.getGregTechItem(1, 1, 63));
		
		/*
		 * DECOMPOSIZIONE DI MINERALI
		 */
		
		//Serpentino -> 90% magnesio, 10% crisotilo
		GregtechCompat.addElectrolyzerRecipe(new ItemStack(Items.Serpentino, 64), 0,
				GregtechCompat.getGregTechItem(1, 51, 13), new ItemStack(Items.Crisotilo, 12), null, null, 160, 110);
		
		//Muscovite/Biotite -> 33% 22 Al, 33% 21 Si, 33% 21 K
		GregtechCompat.addElectrolyzerRecipe(new ItemStack(Items.Biotite, 64), 21,
				GregtechCompat.getGregTechItem(1, 22, 18), GregtechCompat.getGregTechItem(1, 21, 7),
				GregtechCompat.getGregTechItem(2, 21, 14), null, 1160, 110);
		GregtechCompat.addElectrolyzerRecipe(new ItemStack(Items.Muscovite, 64), 21,
				GregtechCompat.getGregTechItem(1, 22, 18), GregtechCompat.getGregTechItem(1, 21, 7),
				GregtechCompat.getGregTechItem(2, 21, 14), null, 1160, 110);
		
		//Feldspato -> 60% Si, 20% K, 20% Al
		
		GregtechCompat.addElectrolyzerRecipe(new ItemStack(Items.Feldspato, 64), 13,
				GregtechCompat.getGregTechItem(1, 13, 18), GregtechCompat.getGregTechItem(1, 38, 7), 
				GregtechCompat.getGregTechItem(2, 13, 14), null, 1220, 95);

		//Orneblenda: 25% Mg, 25% Fe, 25% Al, 25% Ca. 
		
		GregtechCompat.addElectrolyzerRecipe(new ItemStack(Items.Orneblenda, 64), 16,
				GregtechCompat.getGregTechItem(1, 16, 241), GregtechCompat.getGregTechItem(1, 16, 13),
				GregtechCompat.getGregTechItem(2, 16, 11), GregtechCompat.getGregTechItem(1, 16, 18), 1290, 90);

		//Brucite: 63 Mg, 1 Ir
		
		GregtechCompat.addElectrolyzerRecipe(new ItemStack(Items.Brucite, 32), 0,
				GregtechCompat.getGregTechItem(1, 63, 13), GregtechCompat.getGregTechItem(5, 1, 16), null, null, 10460, 65);
		
		//Magnetite:
		
		GregtechCompat.addElectrolyzerRecipe(new ItemStack(Items.Magnetite, 64), 0,
				GregtechCompat.getGregTechItem(1, 46, 241), GregtechCompat.getGregTechItem(1, 18, 63), null, null, 1400, 70);
		
		//Ematite: 
		
		GregtechCompat.addElectrolyzerRecipe(new ItemStack(Items.Magnetite, 64), 0,
				GregtechCompat.getGregTechItem(1, 30, 241), GregtechCompat.getGregTechItem(1, 34, 63), null, null, 1400, 70);
		
		//Fluorite:
		
		GregtechCompat.addElectrolyzerRecipe(new ItemStack(Items.Fluorite, 3), 4,
				new ItemStack(Items.Fluoro, 2), GregtechCompat.getGregTechItem(2, 2, 11), null, null, 6500, 45);
		
		
		/*
		 * PARTE RADIOLOGICA
		 */
		
		//Uranite -> U3O8
		GregtechCompat.addGrinderRecipe(new ItemStack(Blocks.roccia, 5, 10), 1,
				GregtechCompat.getGregTechItem(1, 2, 244), GregtechCompat.getGregTechItem(1, 2, 23), new ItemStack(Items.U3O8, 1), null);
		
		//U3O8 -> UO2
		GregtechCompat.addChemicalRecipe(new ItemStack(Items.U3O8, 1), GregtechCompat.getGregTechItem(2, 1, 40),
				new ItemStack(Items.UO2), 3600);
		
		//UO2 -> U naturale
		ItemStack uranioNaturale = ic2.api.Items.getItem("uraniumIngot");
		uranioNaturale.stackSize = 3;
		GregtechCompat.addBlastRecipe(new ItemStack(Items.UO2, 3), GregtechCompat.getGregTechItem(2, 1, 0),
				uranioNaturale, ic2.api.Items.getItem("waterCell"), 1200, 95, 973);
		
		//UO2 -> UF6
		
		GregtechCompat.addChemicalRecipe(new ItemStack(Items.UO2, 1), new ItemStack(Items.Fluoro, 1),
				new ItemStack(Items.UF6Nat, 1), 3100);
		
		//UF6 -> UF6LE
		GregtechCompat.addCentrifugeRecipe(new ItemStack(Items.UF6Nat, 1), 0,
				new ItemStack(Items.UF6LE), null, null, null, 36000);
		
		//UF6LE -> UF6HE
		GregtechCompat.addCentrifugeRecipe(new ItemStack(Items.UF6LE, 1), 0,
				new ItemStack(Items.UF6HE), null, null, null, 864000);
		//UF6LE -> LEU
		
		ic2.api.Ic2Recipes.addExtractorRecipe(new ItemStack(Items.UF6LE), new ItemStack(Items.LEU)); 
		
		//UF6HE -> HEU
		
		ic2.api.Ic2Recipes.addExtractorRecipe(new ItemStack(Items.UF6HE), new ItemStack(Items.HEU));
		
		//LEU -> LECell
		
		GregtechCompat.addCannerRecipe(new ItemStack(Items.LEU), ic2.api.Items.getItem("cell"),
				new ItemStack(Items.LECell), null, 150, 45);
		
		//HEU -> HECell
		
		GregtechCompat.addCannerRecipe(new ItemStack(Items.HEU), ic2.api.Items.getItem("cell"),
				new ItemStack(Items.HECell), null, 150, 45);
		
		//Zircone -> Zirconio
		GregtechCompat.addElectrolyzerRecipe(new ItemStack(Items.Zircone, 3), 0,
				new ItemStack(Items.Zirconio, 1), GregtechCompat.getGregTechItem(1, 2, 7), null, null, 4800, 95);
		
		//Zirconio -> Zircaloy
		GregtechCompat.addBlastRecipe(new ItemStack(Items.Zirconio, 63), GregtechCompat.getGregTechItem(1, 1, 244),
				new ItemStack(Items.Zircaloy, 64), null, 6500, 20, 2250);
		
		//Zircaloy -> ZircaloyPlate
		GregtechCompat.addBenderRecipe(new ItemStack(Items.Zircaloy, 1), new ItemStack(Items.ZircaloyPlate, 1), 800, 32);
		
		//LECell -> LECellx2
		GameRegistry.addShapedRecipe(new ItemStack(Items.LECellx2, 1),
				new Object[] {"CPC", "   ", "   ", 'C', Items.LECell, 'P', GregtechCompat.getGregTechItem(0, 1, 68)});
		
		//LECellx2 -> LECellx4
		GameRegistry.addShapedRecipe(new ItemStack(Items.LECellx2, 1),
				new Object[] {" C ", "PPP", " C ", 'C', Items.LECellx2, 'P', GregtechCompat.getGregTechItem(0, 1, 68)});
		
		//HECell -> HECellx2
		GameRegistry.addShapedRecipe(new ItemStack(Items.HECellx2, 1),
				new Object[] {"CPC", "   ", "   ", 'C', Items.HECell, 'P', Items.ZircaloyPlate});
		
		//HECellx2 -> HECellx4
		GameRegistry.addShapedRecipe(new ItemStack(Items.HECellx2, 1),
				new Object[] {" C ", "PPP", " C ", 'C', Items.HECellx2, 'P', Items.ZircaloyPlate});
		
		
	}
}
