package enhancedgeology.main.tools;

import enhancedgeology.main.CreativeTab;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ToolMartelloGeologo extends ItemPickaxe {

	public ToolMartelloGeologo(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setTextureFile("/enhancedgeology/textures/oggetti.png");
		this.setIconIndex(0);
		this.setMaxDamage(250);
		this.setCreativeTab(CreativeTab.tabEnhancedGeologyAltro);
		this.setItemName("martello_geologo");
		this.setMaxStackSize(1);
		this.setNoRepair();
	}
	
	@Override
	public void onUpdate(ItemStack is, World world, Entity e, int par4, boolean par5) {
		if (!is.isItemEnchanted()) {
			is.addEnchantment(Enchantment.fortune, 6);
		}
	}
	
	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
		return 0.55F;
	}
	

}
