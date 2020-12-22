package enhancedgeology.main.handlers;

import enhancedgeology.main.CreativeTab;
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
		OreDictionary.registerOre("dustZirconium", Items.Zirconio);
		OreDictionary.registerOre("ingotZircaloy", Items.Zircaloy);
	}
}
