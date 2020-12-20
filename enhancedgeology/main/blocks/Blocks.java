package enhancedgeology.main.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import enhancedgeology.main.items.ItemBlockMateriali;
import enhancedgeology.main.items.ItemBlockRocce;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class Blocks {
	

	public static Block roccia, materiale, TettoAmianto;
    

	public static void InizializzaBlocchi() {
		roccia = new Roccia(146);
		materiale = new Materiale(147);
		TettoAmianto = new TettoAmiantoBlock(3200, 0);		
	}
	public static void RegistraBlocchi() {
		GameRegistry.registerBlock(roccia, ItemBlockRocce.class, roccia.getBlockName());
		GameRegistry.registerBlock(materiale, ItemBlockMateriali.class, materiale.getBlockName());
		GameRegistry.registerBlock(TettoAmianto, "TettoAmianto");
		GameRegistry.registerTileEntity(enhancedgeology.main.entities.TileEntityTettoAmianto.class,
				"TettoAmiantoTileEntity");
	}

	public static void RegistraLingua() {
		
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
		LanguageRegistry.addName(new ItemStack(roccia, 1, 10), "Uranite");
		
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
