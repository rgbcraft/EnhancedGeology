package enhancedgeology.main.items;

import enhancedgeology.main.CreativeTab;
import net.minecraft.item.Item;

public class ItemOggetto extends Item {

	public ItemOggetto(int id, int textureId, String itemName, int maxStackSize) {
		super(id);
		/**
		 * Registra un oggetto generico
		 * @param id ID dell'oggetto
		 * @param textureId ID della texture
		 * @param itemName nome oggetto
		 * @param maxStackSize Max stack size
		 * @return Item.
		 */
		this.setTextureFile("/enhancedgeology/textures/oggetti.png");
		this.setIconIndex(textureId);
		this.setCreativeTab(CreativeTab.tabEnhancedGeologyAltro);
		this.setItemName(itemName);
		this.setMaxStackSize(maxStackSize);
	}
	
	

}
