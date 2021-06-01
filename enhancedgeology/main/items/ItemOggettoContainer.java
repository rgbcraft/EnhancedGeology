package enhancedgeology.main.items;

import enhancedgeology.main.CreativeTab;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemOggettoContainer extends Item {

	public ItemOggettoContainer(int id, int textureId, String itemName, int maxStackSize, Item containerItem) {
		super(id);
		/**
		 * Registra un oggetto generico
		 * @param id ID dell'oggetto
		 * @param textureId ID della texture
		 * @param itemName nome oggetto
		 * @param maxStackSize Max stack size
		 * @param containerItem Oggetto contenuto
		 * @return Item.
		 */
		this.setTextureFile("/enhancedgeology/textures/oggetti.png");
		this.setIconIndex(textureId);
		this.setCreativeTab(CreativeTab.tabEnhancedGeologyAltro);
		this.setItemName(itemName);
		this.setMaxStackSize(maxStackSize);
		this.setContainerItem(containerItem);
	}

}
