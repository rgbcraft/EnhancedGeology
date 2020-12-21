package enhancedgeology.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import enhancedgeology.main.blocks.Blocks;
import enhancedgeology.main.handlers.CraftingHandler;
import enhancedgeology.main.items.Items;
import enhancedgeology.main.proxies.CommonProxy;
import net.minecraft.src.BaseMod;

@Mod(name="Enhanced Geology", version="1.1", modid="enhancedgeology")
public class Main extends BaseMod{
	
	@SidedProxy(clientSide="enhancedgeology.main.proxies.ClientProxy", serverSide="enhancedgeology.main.proxies.ServerProxy")
	public static CommonProxy proxy;
	
	@Override
	public String getVersion() {
		return "1.1";
	}

	@Override
	public void load() {

		
	}
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("[EnhancedGeology] Ma secondo te un cratone è un cratere grosso? MA TU L'ESAME NON LO PASSI, CAPITO MEOLA?! --Prof Scambelluri");			
	}
	
	
	@Init
	public void init(FMLInitializationEvent event) {
		//proxy per modelli techne
		proxy.init(event);
		Blocks.InizializzaBlocchi();
		Blocks.RegistraBlocchi();
		Blocks.RegistraLingua();
		Blocks.AggiungiAttributi();
		Items.InizializzaItem();
		Items.RegistraLingua();
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		CraftingHandler.AggiungiCrafting();
	    proxy.postInit(event);
	}
}
