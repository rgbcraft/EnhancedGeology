package enhancedgeology.main.radiology;

import enhancedgeology.main.CreativeTab;
import net.minecraft.item.Item;

public class ItemUF6 extends Item {

	public ItemUF6(int id, int textureId, String itemName) {
		super(id);
		/**
		 * Registra un esafluoruro d'uranio
		 * @param id ID dell'oggetto
		 * @param textureId ID della texture
		 * @param itemName nome oggetto
		 * @return Item.
		 */
		this.setTextureFile("/enhancedgeology/textures/oggetti.png");
		this.setIconIndex(textureId);
		this.setCreativeTab(CreativeTab.tabEnhancedGeologyAltro);
		this.setItemName(itemName);
		this.setMaxStackSize(maxStackSize);
	}

}
