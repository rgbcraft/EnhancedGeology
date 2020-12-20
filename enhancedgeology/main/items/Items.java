package enhancedgeology.main.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import enhancedgeology.main.CreativeTab;
import enhancedgeology.main.radiology.ItemHECell;
import enhancedgeology.main.radiology.ItemHECellx2;
import enhancedgeology.main.radiology.ItemHECellx4;
import enhancedgeology.main.radiology.ItemLECell;
import enhancedgeology.main.radiology.ItemLECellx2;
import enhancedgeology.main.radiology.ItemLECellx4;
import enhancedgeology.main.radiology.ItemUF6;

public class Items {
	
	//ITEMS
	public static Item MartelloGeologo, Crisotilo, Biotite, Feldspato, Muscovite,
	Magnetite, Ematite, Zircone, Serpentino, Orneblenda, Brucite, Fluorite, Fluoro,
	U3O8, UO2, LEU, HEU, UF6Nat, UF6LE, UF6HE, LECell, LECellx2, LECellx4, HECell, HECellx2, HECellx4,
	Zirconio, Zircaloy, ZircaloyPlate;
 
	public static void InizializzaItem() {

	String texture = "/enhancedgeology/textures/oggetti.png";	
	
	MartelloGeologo = new ItemMartelloGeologo(16030, EnumToolMaterial.EMERALD);
	
	Fluoro = new Item(16033).setTextureFile(texture).setIconIndex(16).setCreativeTab(CreativeTab.tabEnhancedGeologyAltro)
			.setItemName("Fluoro");
	UO2 = new Item(16034).setTextureFile(texture).setIconIndex(17).setCreativeTab(CreativeTab.tabEnhancedGeologyAltro)
			.setItemName("UO2");
	
	UF6Nat = new ItemUF6(16100, 18, "UF6Nat");
	UF6LE = new ItemUF6(16101, 19, "UF6LE");
	UF6HE = new ItemUF6(16102, 20, "UF6HE");
	
	Biotite = new ItemMinerale(16050, 0, "Biotite", 64);
	Muscovite = new ItemMinerale(16051, 1, "Muscovite", 64);
	Feldspato = new ItemMinerale(16052, 2, "Feldspato", 64);
	Magnetite = new ItemMinerale(16053, 3, "Magnetite", 64);
	Ematite = new ItemMinerale(16054, 4, "Ematite", 64);
	Zircone = new ItemMinerale(16055, 5, "Zircone", 16);
	Serpentino = new ItemMinerale(16056, 6, "Serpentino", 64);
	Crisotilo = new ItemMinerale(16057, 7, "Crisotilo", 32);
	Orneblenda = new ItemMinerale(16058, 8, "Orneblenda", 64);
	Brucite = new ItemMinerale(16059, 9, "Brucite", 32);
	Fluorite = new ItemMinerale(16060, 10, "Fluorite", 64);
	
	
	U3O8 = new ItemMinerale(16211, 11, "U3O8", 8);
	LEU = new ItemOggetto(16215, 48, "LEU", 64);
	HEU = new ItemOggetto(16213, 49, "HEU", 64);
	
	Zirconio = new ItemOggetto(16221, 66, "Zirconio", 64);
	Zircaloy = new ItemOggetto(16222, 50, "Zircaloy", 64);
	ZircaloyPlate = new ItemOggetto(16223, 82, "ZircaloyPlate", 64);
	
	LECell = new ItemLECell(16200);
	LECellx2 = new ItemLECellx2(16201);
	LECellx4 = new ItemLECellx4(16202);
	
	HECell = new ItemHECell(16203);
	HECellx2 = new ItemHECellx2(16204);
	HECellx4 = new ItemHECellx4(16205);
	
	}
	
	 
	
	
	public static void RegistraLingua() {
		LanguageRegistry.addName(MartelloGeologo, "Martello da geologo");
		
		LanguageRegistry.addName(Biotite, "Biotite");
		LanguageRegistry.addName(Muscovite, "Muscovite");
		LanguageRegistry.addName(Feldspato, "Feldspato");
		LanguageRegistry.addName(Magnetite, "Magnetite");
		LanguageRegistry.addName(Ematite, "Ematite");
		LanguageRegistry.addName(Zircone, "Zircone");
		LanguageRegistry.addName(Serpentino, "Serpentino");
		LanguageRegistry.addName(Crisotilo, "Crisotilo");
		LanguageRegistry.addName(Orneblenda, "Orneblenda");
		LanguageRegistry.addName(Brucite, "Brucite");
		LanguageRegistry.addName(Fluorite, "Fluorite");
		
		LanguageRegistry.addName(Fluoro, "Fluorine Cell");
		
		LanguageRegistry.addName(U3O8, "U₃O₈ (Yellowcake)");
		LanguageRegistry.addName(UO2, "UO₂");
		LanguageRegistry.addName(LEU, "Lightly Enriched Uranium");
		LanguageRegistry.addName(HEU, "Highly Enriched Uranium");
		LanguageRegistry.addName(UF6Nat, "UF₆ (naturale)");
		LanguageRegistry.addName(UF6LE, "UF₆ (lightly enr.)");
		LanguageRegistry.addName(UF6HE, "UF₆ (highly enr.)");
		
		LanguageRegistry.addName(Zirconio, "Zirconio");
		LanguageRegistry.addName(Zircaloy, "Zircaloy 4");
		LanguageRegistry.addName(ZircaloyPlate, "Zircaloy 4 Plate");
		
		LanguageRegistry.addName(LECell, "Lightly Enriched Uranium Cell");
		LanguageRegistry.addName(LECellx2, "Dual Lightly Enriched Uranium Cell");
		LanguageRegistry.addName(LECellx4, "Quad Lightly Enriched Uranium Cell");
		
		LanguageRegistry.addName(HECell, "Highly Enriched Uranium Cell");
		LanguageRegistry.addName(HECellx2, "Dual Highly Enriched Uranium Cell");
		LanguageRegistry.addName(HECellx4, "Quad Highly Enriched Uranium Cell");
		
	}
}


