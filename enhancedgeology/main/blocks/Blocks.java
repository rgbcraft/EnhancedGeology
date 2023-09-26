package enhancedgeology.main.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import enhancedgeology.main.items.ItemBlockMateriali;
import enhancedgeology.main.items.ItemBlockRocce;
import enhancedgeology.main.items.ItemCustomSlab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class Blocks {
	

	public static Block roccia, materiale, TettoAmianto;
	public static Block stoneStairs, ardesiaStairs, andesiteStairs, dioriteStairs, graniteStairs, polishedAndesiteStairs, polishedDioriteStairs, polishedGraniteStairs, quarziteStairs;
	public static BlockHalfSlab rocciaSlab, rocciaSingleSlab, materialeSlab, materialeSingleSlab;

	public static void InizializzaBlocchi() {
		roccia = new Roccia(146);
		materiale = new Materiale(147);
		TettoAmianto = new TettoAmiantoBlock(3200, 0);
		stoneStairs = new BlockCustomStairs(202, Block.stone, 0, "stoneStairs");
		andesiteStairs = new BlockCustomStairs(203, Blocks.roccia, 0, "andesiteStairs");
		dioriteStairs = new BlockCustomStairs(204, Blocks.roccia, 1, "dioriteStairs");
		graniteStairs = new BlockCustomStairs(205, Blocks.roccia, 2, "graniteStairs");
		polishedAndesiteStairs = new BlockCustomStairs(206, Blocks.materiale, 0, "polishedAndesiteStairs");
		polishedDioriteStairs = new BlockCustomStairs(153, Blocks.materiale, 1, "polishedDioriteStairs");
		polishedGraniteStairs = new BlockCustomStairs(154, Blocks.materiale, 2, "polishedGraniteStairs");
		quarziteStairs = new BlockCustomStairs(155, Blocks.materiale, 4, "quarziteStairs");
		ardesiaStairs = new BlockCustomStairs(156, Blocks.roccia, 4, "ardesiaStairs");
		
		rocciaSlab = (BlockHalfSlab)new BlockRocciaSlab(212, true).setBlockName("rocciaSlab");
		rocciaSingleSlab = (BlockHalfSlab)new BlockRocciaSlab(213, false).setBlockName("rocciaSlab");
		
		materialeSlab = (BlockHalfSlab)new BlockMaterialeSlab(214, true).setBlockName("materialeSlab");
		materialeSingleSlab = (BlockHalfSlab)new BlockMaterialeSlab(215, false).setBlockName("materialeSlab");
		
	}
	public static void RegistraBlocchi() {
		GameRegistry.registerBlock(roccia, ItemBlockRocce.class, roccia.getBlockName());
		GameRegistry.registerBlock(materiale, ItemBlockMateriali.class, materiale.getBlockName());
		GameRegistry.registerBlock(TettoAmianto, "TettoAmianto");
		GameRegistry.registerTileEntity(enhancedgeology.main.entities.TileEntityTettoAmianto.class,
				"TettoAmiantoTileEntity");
		GameRegistry.registerBlock(stoneStairs, "stoneStairs");
		GameRegistry.registerBlock(andesiteStairs, "andesiteStairs");
		GameRegistry.registerBlock(dioriteStairs, "dioriteStairs");
		GameRegistry.registerBlock(graniteStairs, "graniteStairs");
		GameRegistry.registerBlock(polishedAndesiteStairs, "polishedAndesiteStairs");
		GameRegistry.registerBlock(polishedDioriteStairs, "polishedDioriteStairs");
		GameRegistry.registerBlock(polishedGraniteStairs, "polishedGraniteStairs");
		GameRegistry.registerBlock(quarziteStairs, "quarziteStairs");
		GameRegistry.registerBlock(ardesiaStairs, "ardesiaStairs");
		
		GameRegistry.registerBlock(rocciaSlab, "rocciaSlab");
		GameRegistry.registerBlock(rocciaSingleSlab, "rocciaSingleSlab");
		
		GameRegistry.registerBlock(materialeSlab, "materialeSlab");
		GameRegistry.registerBlock(materialeSingleSlab, "materialeSingleSlab");
		
		Item.itemsList[rocciaSingleSlab.blockID] = (new ItemCustomSlab(rocciaSingleSlab.blockID - 256, rocciaSingleSlab, rocciaSlab, false)).setItemName("rocciaSlab");
        Item.itemsList[rocciaSlab.blockID] = (new ItemCustomSlab(rocciaSlab.blockID - 256, rocciaSingleSlab, rocciaSlab, true)).setItemName("rocciaSlab");
        
		Item.itemsList[materialeSingleSlab.blockID] = (new ItemCustomSlab(materialeSingleSlab.blockID - 256, materialeSingleSlab, materialeSlab, false)).setItemName("materialeSlab");
        Item.itemsList[materialeSlab.blockID] = (new ItemCustomSlab(materialeSlab.blockID - 256, materialeSingleSlab, materialeSlab, true)).setItemName("materialeSlab");
        
	}	

	public static void RegistraLingua() {
		
		//Scale
		
		LanguageRegistry.addName(stoneStairs, "Stone Stairs");
		LanguageRegistry.addName(andesiteStairs, "Andesite Stairs");
		LanguageRegistry.addName(dioriteStairs, "Diorite Stairs");
		LanguageRegistry.addName(graniteStairs, "Granite Stairs");
		LanguageRegistry.addName(polishedAndesiteStairs, "Polished Andesite Stairs");
		LanguageRegistry.addName(polishedDioriteStairs, "Polished Diorite Stairs");
		LanguageRegistry.addName(polishedGraniteStairs, "Polished Granite Stairs");
		LanguageRegistry.addName(quarziteStairs, "Quarzite Stairs");
		LanguageRegistry.addName(ardesiaStairs, "Ardesia Stairs");
		
		// Slab
		
		LanguageRegistry.addName(new ItemStack(rocciaSlab, 1, 0), "Andesite Slab");
		LanguageRegistry.addName(new ItemStack(rocciaSlab, 1, 1), "Diorite Slab");
		LanguageRegistry.addName(new ItemStack(rocciaSlab, 1, 2), "Granite Slab");
		LanguageRegistry.addName(new ItemStack(rocciaSlab, 1, 3), "Stone Slab");
		LanguageRegistry.addName(new ItemStack(rocciaSlab, 1, 4), "Ardesia Slab");
		LanguageRegistry.addName(new ItemStack(rocciaSlab, 1, 5), "Diaspro Rosso Slab");
		LanguageRegistry.addName(new ItemStack(rocciaSlab, 1, 6), "Tufo Slab");

		LanguageRegistry.addName(new ItemStack(rocciaSingleSlab, 1, 0), "Andesite Slab");
		LanguageRegistry.addName(new ItemStack(rocciaSingleSlab, 1, 1), "Diorite Slab");
		LanguageRegistry.addName(new ItemStack(rocciaSingleSlab, 1, 2), "Granite Slab");
		LanguageRegistry.addName(new ItemStack(rocciaSingleSlab, 1, 3), "Stone Slab");
		LanguageRegistry.addName(new ItemStack(rocciaSingleSlab, 1, 4), "Ardesia Slab");
		LanguageRegistry.addName(new ItemStack(rocciaSingleSlab, 1, 5), "Diaspro Rosso Slab");
		LanguageRegistry.addName(new ItemStack(rocciaSingleSlab, 1, 6), "Tufo Slab");
		
		LanguageRegistry.addName(new ItemStack(materialeSlab, 1, 0), "Andesite Slab");
		LanguageRegistry.addName(new ItemStack(materialeSlab, 1, 1), "Diorite Slab");
		LanguageRegistry.addName(new ItemStack(materialeSlab, 1, 2), "Granite Slab");
		LanguageRegistry.addName(new ItemStack(materialeSlab, 1, 3), "Mattoni di tufo Slab");

		LanguageRegistry.addName(new ItemStack(materialeSingleSlab, 1, 0), "Andesite Slab");
		LanguageRegistry.addName(new ItemStack(materialeSingleSlab, 1, 1), "Diorite Slab");
		LanguageRegistry.addName(new ItemStack(materialeSingleSlab, 1, 2), "Granite Slab");
		LanguageRegistry.addName(new ItemStack(materialeSingleSlab, 1, 3), "Mattoni di tufo Slab");
		
		
		//Amianto
		LanguageRegistry.addName(TettoAmianto, "Tetto in fibrocemento");
		
		//rocce
		
		LanguageRegistry.addName(new ItemStack(roccia, 1, 0), "Andesite");
		LanguageRegistry.addName(new ItemStack(roccia, 1, 1), "Diorite");
		LanguageRegistry.addName(new ItemStack(roccia, 1, 2), "Granito");
		LanguageRegistry.addName(new ItemStack(roccia, 1, 3), "Peridotite");
		LanguageRegistry.addName(new ItemStack(roccia, 1, 4), "Ardesia");
		LanguageRegistry.addName(new ItemStack(roccia, 1, 5), "Diaspro Rosso");
		LanguageRegistry.addName(new ItemStack(roccia, 1, 6), "Tufo");
		LanguageRegistry.addName(new ItemStack(roccia, 1, 7), "Serpentinite");
		LanguageRegistry.addName(new ItemStack(roccia, 1, 8), "Gneiss");
		LanguageRegistry.addName(new ItemStack(roccia, 1, 9), "Kimberlite");
		LanguageRegistry.addName(new ItemStack(roccia, 1, 10), "Uraninite");
		
		//materiali
		
		LanguageRegistry.addName(new ItemStack(materiale, 1, 0), "Andesite levigata");
		LanguageRegistry.addName(new ItemStack(materiale, 1, 1), "Diorite levigata");
		LanguageRegistry.addName(new ItemStack(materiale, 1, 2), "Granito levigato");
		LanguageRegistry.addName(new ItemStack(materiale, 1, 3), "Mattoni di tufo");
		LanguageRegistry.addName(new ItemStack(materiale, 1, 4), "Quarzite");
		LanguageRegistry.addName(new ItemStack(materiale, 1, 5), "Mattoni di quarzite");
		LanguageRegistry.addName(new ItemStack(materiale, 1, 6), "Colonna di quarzite");
		LanguageRegistry.addName(new ItemStack(materiale, 1, 7), "Quarzite incisa");
	}

	public static void AggiungiAttributi() {

	}

}
