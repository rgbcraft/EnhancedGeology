package enhancedgeology.main.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockRocce extends ItemBlock {

	public ItemBlockRocce(int par1) {
		super(par1);
		this.setHasSubtypes(true);
	}

	@Override 
	public String getItemNameIS(ItemStack is) {
		return "rocce" + is.getItemDamage();
	}
	
	@Override
	public int getMetadata(int damage) {
		return damage;
	}
	
	@Override
	public void getSubItems(int id, CreativeTabs ct, List subBlocks) {
		// i max = numero massimo di blocchi nel metadata
		for (int i = 0; i <= 10; i++) {
			subBlocks.add(new ItemStack(id, 1, i));
		}
	}
}
