package enhancedgeology.main.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enhancedgeology.main.CreativeTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemMinerale extends Item {

	public ItemMinerale(int id, int textureId, String itemName, int maxStackSize) {
		super(id);
		/**
		 * Registra un minerale
		 * @param id ID dell'oggetto
		 * @param textureId ID della texture
		 * @param itemName nome oggetto
		 * @param maxStackSize Max stack size
		 * @return Item.
		 */
		this.setTextureFile("/enhancedgeology/textures/minerali.png");
		this.setIconIndex(textureId);
		this.setCreativeTab(CreativeTab.tabEnhancedGeologyMinerali);
		this.setItemName(itemName);
		this.setMaxStackSize(maxStackSize);
	}

}
