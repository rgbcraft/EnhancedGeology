package enhancedgeology.main.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import enhancedgeology.main.CreativeTab;
import enhancedgeology.main.radiology.ItemHECell;
import enhancedgeology.main.radiology.ItemHECellx2;
import enhancedgeology.main.radiology.ItemHECellx4;
import enhancedgeology.main.radiology.ItemLECell;
import enhancedgeology.main.radiology.ItemLECellx2;
import enhancedgeology.main.radiology.ItemLECellx4;
import enhancedgeology.main.radiology.ItemMGECell;
import enhancedgeology.main.radiology.ItemMGECellx2;
import enhancedgeology.main.radiology.ItemMGECellx4;
import enhancedgeology.main.radiology.ItemMOXCell;
import enhancedgeology.main.radiology.ItemMOXCellx2;
import enhancedgeology.main.radiology.ItemMOXCellx4;
import enhancedgeology.main.radiology.ItemUF6;
import enhancedgeology.main.tools.ToolBateia;
import enhancedgeology.main.tools.ToolConduttimetro;
import enhancedgeology.main.tools.ToolContatoreGeiger;
import enhancedgeology.main.tools.ToolGasDrill;
import enhancedgeology.main.tools.ToolGlassHammer;
import enhancedgeology.main.tools.ToolGravimetro;
import enhancedgeology.main.tools.ToolHammerDrill;
import enhancedgeology.main.tools.ToolMartelloGeologo;
import enhancedgeology.main.tools.ToolOxyFuelTorch;
import enhancedgeology.main.tools.ToolSDSHammerDrill;

public class Items {
	
	//ITEMS
	public static Item GlassHammer, GasDrill, HammerDrill, SDSHammerDrill, OxyFuelTorch, MartelloGeologo, Crisotilo, Biotite, Feldspato, Muscovite,
	Magnetite, Ematite, Zircone, Serpentino, Orneblenda, Brucite, Fluorite, Fluoro,
	U3O8, UO2, LEU, HEU, MGEU, MOX, UF6Nat, UF6LE, UF6HE, UF6MGE, LECell, LECellx2, LECellx4, HECell, HECellx2, HECellx4, MGECell, MGECellx2, MGECellx4, MOXCell, MOXCellx2, MOXCellx4,
	Zirconio, Zircaloy, ZircaloyPlate, Miscela,
	Gravimetro, Conduttimetro, ContatoreGeiger, Bateia, LOXCell, IronScraps, AcetyleneCell, OxygenCell,Duralumin,AlloyMixture2014, CopperSulfate, CopperOxide;
 
	public static void InizializzaItem() {

	String texture = "/enhancedgeology/textures/oggetti.png";	
	
	MartelloGeologo = new ToolMartelloGeologo(16030, EnumToolMaterial.EMERALD);
	GasDrill = new ToolGasDrill(16031, EnumToolMaterial.IRON);
	GlassHammer = new ToolGlassHammer(16029, EnumToolMaterial.IRON);
	HammerDrill = new ToolHammerDrill(16028, EnumToolMaterial.IRON);
	SDSHammerDrill = new ToolSDSHammerDrill(16027, EnumToolMaterial.IRON);
	OxyFuelTorch = new ToolOxyFuelTorch(16026, EnumToolMaterial.IRON);
	
	/*Fluoro = new Item(16033).setTextureFile(texture).setIconIndex(16).setCreativeTab(CreativeTab.tabEnhancedGeologyAltro)
			.setItemName("Fluoro");
	UO2 = new Item(16034).setTextureFile(texture).setIconIndex(17).setCreativeTab(CreativeTab.tabEnhancedGeologyAltro)
			.setItemName("UO2");
	*/
	
	
	
	Fluoro = new ItemOggetto(16033, 16, "Fluoro", 64);
	UO2 = new ItemOggetto(16034, 17, "UO2", 64);
	LOXCell = new ItemOggetto(16035, 21, "LOXCell", 64);
	Miscela = new ItemOggettoContainer(16036, 10, "Miscela", 4, ic2.api.Items.getItem("fuelCan").getItem());
	OxygenCell = new ItemOggetto(16037, 22, "OxygenCell", 64);
	AcetyleneCell = new ItemOggetto(16038, 23, "AcetyleneCell", 64);
	
	
	UF6Nat = new ItemUF6(16100, 18, "UF6Nat");
	UF6LE = new ItemUF6(16101, 19, "UF6LE");
	UF6HE = new ItemUF6(16102, 20, "UF6HE");
	UF6MGE = new ItemUF6(16103, 24, "UF6MGE");
	
	Biotite = new ItemMinerale(16050, 0, "Biotite", 64);
	Muscovite = new ItemMinerale(16051, 1, "Muscovite", 64);
	Feldspato = new ItemMinerale(16052, 2, "Feldspato", 64);
	Magnetite = new ItemMinerale(16053, 3, "Magnetite", 64);
	Ematite = new ItemMinerale(16054, 4, "Ematite", 64);
	Zircone = new ItemMinerale(16055, 5, "Zircone", 64);
	Serpentino = new ItemMinerale(16056, 6, "Serpentino", 64);
	Crisotilo = new ItemMinerale(16057, 7, "Crisotilo", 64);
	Orneblenda = new ItemMinerale(16058, 8, "Orneblenda", 64);
	Brucite = new ItemMinerale(16059, 9, "Brucite", 64);
	Fluorite = new ItemMinerale(16060, 10, "Fluorite", 64);
	
	
	U3O8 = new ItemMinerale(16211, 11, "U3O8", 8);
	LEU = new ItemOggetto(16212, 48, "LEU", 64);
	HEU = new ItemOggetto(16213, 49, "HEU", 64);
	MGEU = new ItemOggetto(16214, 52, "MGEU", 64);
	MOX = new ItemOggetto(16215, 53, "MOX", 64);

	
	Zirconio = new ItemOggetto(16221, 66, "Zirconio", 64);
	Zircaloy = new ItemOggetto(16222, 50, "Zircaloy", 64);
	ZircaloyPlate = new ItemOggetto(16223, 82, "ZircaloyPlate", 64);
	IronScraps = new ItemOggetto(16224, 96, "IronScraps", 64);
	Duralumin = new ItemOggetto(16225, 51, "Duralumin", 64);
	AlloyMixture2014 = new ItemOggetto(16226, 97, "AlloyMixture2014", 64);
	CopperSulfate = new ItemOggetto(16227, 67, "CopperSulfate", 64);
	CopperOxide = new ItemOggetto(16228, 68, "CopperOxide", 64);
	
	LECell = new ItemLECell(16200);
	LECellx2 = new ItemLECellx2(16201);
	LECellx4 = new ItemLECellx4(16202);
	
	HECell = new ItemHECell(16203);
	HECellx2 = new ItemHECellx2(16204);
	HECellx4 = new ItemHECellx4(16205);
	
	MGECell = new ItemMGECell(16206);
	MGECellx2 = new ItemMGECellx2(16207);
	MGECellx4 = new ItemMGECellx4(16208);
	
	MOXCell = new ItemMOXCell(16209);
	MOXCellx2 = new ItemMOXCellx2(16210);
	MOXCellx4 = new ItemMOXCellx4(16211);
	
	Gravimetro = new ToolGravimetro(16300);
	Conduttimetro = new ToolConduttimetro(16301);
	ContatoreGeiger = new ToolContatoreGeiger(16302);
	Bateia = new ToolBateia(16303);
	Bateia.setContainerItem(Bateia);
	
	
	GameRegistry.registerItem(Gravimetro, "Gravimetro");
	GameRegistry.registerItem(Conduttimetro, "Conduttimetro");
	GameRegistry.registerItem(ContatoreGeiger, "ContatoreGeiger");
	GameRegistry.registerItem(Bateia, "Bateia");
	
	}
	
	 
	
	
	public static void RegistraLingua() {
		
	
		LanguageRegistry.addName(OxyFuelTorch, "Oxy-fuel Cutting Torch");
		LanguageRegistry.addName(GlassHammer, "Glass Hammer");
		LanguageRegistry.addName(GasDrill, "Gas-powered Drill");
		LanguageRegistry.addName(MartelloGeologo, "Martello da geologo");
		LanguageRegistry.addName(HammerDrill, "Hammer Drill");
		LanguageRegistry.addName(SDSHammerDrill, "SDS Hammer Drill");
		
		LanguageRegistry.addName(Biotite, "Biotite");
		LanguageRegistry.addName(Muscovite, "Muscovite");
		LanguageRegistry.addName(Feldspato, "Feldspar");
		LanguageRegistry.addName(Magnetite, "Magnetite");
		LanguageRegistry.addName(Ematite, "Ematite");
		LanguageRegistry.addName(Zircone, "Zircon");
		LanguageRegistry.addName(Serpentino, "Serpentine");
		LanguageRegistry.addName(Crisotilo, "Chrysotile");
		LanguageRegistry.addName(Orneblenda, "Orneblende");
		LanguageRegistry.addName(Brucite, "Brucite");
		LanguageRegistry.addName(Fluorite, "Fluorite");
		
		LanguageRegistry.addName(Fluoro, "Fluorine Cell");
		LanguageRegistry.addName(LOXCell, "Liquid Oxygen Cell");
		LanguageRegistry.addName(Miscela, "Gasoline Mixture");
		LanguageRegistry.addName(OxygenCell, "Oxygen Cell");
		LanguageRegistry.addName(AcetyleneCell, "Acetylene Cell");
		
		LanguageRegistry.addName(U3O8, "U₃O₈ (Yellowcake)");
		LanguageRegistry.addName(UO2, "UO₂");
		LanguageRegistry.addName(LEU, "Lightly Enriched Uranium");
		LanguageRegistry.addName(HEU, "Highly Enriched Uranium");
		LanguageRegistry.addName(MGEU, "Military Grade Enriched Uranium");
		LanguageRegistry.addName(MOX, "Mixed Oxides (MOX)");
		LanguageRegistry.addName(UF6Nat, "UF₆ (natural)");
		LanguageRegistry.addName(UF6LE, "UF₆ (lightly enr.)");
		LanguageRegistry.addName(UF6HE, "UF₆ (highly enr.)");
		LanguageRegistry.addName(UF6MGE, "UF₆ (military grade enr.)");
		
		LanguageRegistry.addName(Zirconio, "Zirconium Dust");
		LanguageRegistry.addName(Zircaloy, "Zircaloy 4");
		LanguageRegistry.addName(ZircaloyPlate, "Zircaloy 4 Plate");
		LanguageRegistry.addName(Duralumin, "Duralumin Ingot");
		LanguageRegistry.addName(CopperSulfate, "Copper Sulfate Dust");
		LanguageRegistry.addName(CopperOxide, "Copper (II) Oxide Dust");
		
		LanguageRegistry.addName(AlloyMixture2014, "Alloy Mixture N°2014");
		LanguageRegistry.addName(IronScraps, "Iron Ore Scraps");
		
		LanguageRegistry.addName(LECell, "Lightly Enriched Uranium Cell");
		LanguageRegistry.addName(LECellx2, "Dual Lightly Enriched Uranium Cell");
		LanguageRegistry.addName(LECellx4, "Quad Lightly Enriched Uranium Cell");
		
		LanguageRegistry.addName(HECell, "Highly Enriched Uranium Cell");
		LanguageRegistry.addName(HECellx2, "Dual Highly Enriched Uranium Cell");
		LanguageRegistry.addName(HECellx4, "Quad Highly Enriched Uranium Cell");
		
		LanguageRegistry.addName(MGECell, "Military Grade Uranium Cell");
		LanguageRegistry.addName(MGECellx2, "Dual Military Grade Uranium Cell");
		LanguageRegistry.addName(MGECellx4, "Quad Military Grade Uranium Cell");
		
		LanguageRegistry.addName(MOXCell, "MOX Cell");
		LanguageRegistry.addName(MOXCellx2, "Dual MOX Cell");
		LanguageRegistry.addName(MOXCellx4, "Quad MOX Cell");
		
		LanguageRegistry.addName(Gravimetro, "Gravimetro");
		LanguageRegistry.addName(Conduttimetro, "Conduttimetro");
		LanguageRegistry.addName(ContatoreGeiger, "Contatore Geiger");
		LanguageRegistry.addName(Bateia, "Bateia");		
		
	}
}


