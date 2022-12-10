package enhancedgeology.main.proxies;

import java.io.File;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import enhancedgeology.main.entities.TileEntityTettoAmianto;
import enhancedgeology.main.models.RenderTableTettoAmianto;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	public ClientProxy() {
	}

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}

	@Init
	public void init(FMLInitializationEvent event) {
		super.init(event);
		// Preloading texture per evitare bug
		MinecraftForgeClient.preloadTexture("/enhancedgeology/textures/materiali.png");
		MinecraftForgeClient.preloadTexture("/enhancedgeology/textures/minerali.png");
		MinecraftForgeClient.preloadTexture("/enhancedgeology/textures/oggetti.png");
		MinecraftForgeClient.preloadTexture("/enhancedgeology/textures/rocce.png");
		
		System.out.println("[EnhancedGeology] Preloading texture completato");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTettoAmianto.class, new RenderTableTettoAmianto());
	}

	@Mod.PostInit
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
}
