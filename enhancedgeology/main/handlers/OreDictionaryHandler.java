package enhancedgeology.main.handlers;

import enhancedgeology.main.CreativeTab;
import enhancedgeology.main.blocks.Blocks;
import enhancedgeology.main.items.ItemMinerale;
import enhancedgeology.main.items.ItemOggetto;
import enhancedgeology.main.items.Items;
import enhancedgeology.main.radiology.ItemUF6;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/* 
 * Registra tutti gli oggetti come OreDictionary
 */

public class OreDictionaryHandler {
	public static void RegistraOreDict() {
		OreDictionary.registerOre("molecule_2f", Items.Fluoro);
		OreDictionary.registerOre("gemFluorite", Items.Fluorite);
		OreDictionary.registerOre("gemBiotite", Items.Biotite);
		OreDictionary.registerOre("gemMuscovite", Items.Muscovite);
		OreDictionary.registerOre("gemFeldspar", Items.Feldspato);
		OreDictionary.registerOre("gemMagnetite", Items.Magnetite);
		OreDictionary.registerOre("gemEmatite", Items.Ematite);
		OreDictionary.registerOre("gemZircon", Items.Zircone);
		OreDictionary.registerOre("gemSerpentine", Items.Serpentino);
		OreDictionary.registerOre("gemChrysotile", Items.Crisotilo);
		OreDictionary.registerOre("gemOrneblende", Items.Orneblenda);
		OreDictionary.registerOre("gemBrucite", Items.Brucite);
		OreDictionary.registerOre("ingotLeu", Items.LEU);
		OreDictionary.registerOre("ingotHeu", Items.HEU);
		OreDictionary.registerOre("ingotMgeu", Items.MGEU);
		OreDictionary.registerOre("ingotMOX", Items.MOX);
		OreDictionary.registerOre("dustZirconium", Items.Zirconio);
		OreDictionary.registerOre("ingotZircaloy", Items.Zircaloy);
		OreDictionary.registerOre("ironScraps", Items.IronScraps);
		OreDictionary.registerOre("cellLiquidOxygen", Items.LOXCell);
		OreDictionary.registerOre("cellOxygen", Items.OxygenCell);
		OreDictionary.registerOre("cellAcetylene", Items.AcetyleneCell);
		OreDictionary.registerOre("ingotDuralumin", Items.Duralumin);
		OreDictionary.registerOre("dustAlloy2014", Items.AlloyMixture2014);
		OreDictionary.registerOre("dustCopperSulfate", Items.CopperSulfate);
		OreDictionary.registerOre("dustCopperOxide", Items.CopperOxide);
		OreDictionary.registerOre("plateZircaloy4", Items.ZircaloyPlate);
		OreDictionary.registerOre("canisterFuelMixture", Items.Miscela);
		OreDictionary.registerOre("rockAndesite", new ItemStack(Blocks.roccia, 1, 0));
		OreDictionary.registerOre("rockDiorite", new ItemStack(Blocks.roccia, 1, 1));
		OreDictionary.registerOre("rockGranito", new ItemStack(Blocks.roccia, 1, 2));
		OreDictionary.registerOre("rockPeridotite", new ItemStack(Blocks.roccia, 1, 3));
		OreDictionary.registerOre("rockArdesia", new ItemStack(Blocks.roccia, 1, 4));
		OreDictionary.registerOre("rockDiasproRosso", new ItemStack(Blocks.roccia, 1, 5));
		OreDictionary.registerOre("rockTufo", new ItemStack(Blocks.roccia, 1, 6));
		OreDictionary.registerOre("rockSerpentinite", new ItemStack(Blocks.roccia, 1, 7));
		OreDictionary.registerOre("rockGneiss", new ItemStack(Blocks.roccia, 1, 8));
		OreDictionary.registerOre("rockKimberlite", new ItemStack(Blocks.roccia, 1, 9));
		OreDictionary.registerOre("oreUraninite", new ItemStack(Blocks.roccia, 1, 10));
	}
}
