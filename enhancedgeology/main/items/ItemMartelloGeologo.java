package enhancedgeology.main.items;

import enhancedgeology.main.CreativeTab;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class ItemMartelloGeologo extends ItemPickaxe {

	public ItemMartelloGeologo(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setTextureFile("/enhancedgeology/textures/oggetti.png");
		this.setIconIndex(0);
		this.setMaxDamage(100);
		this.setCreativeTab(CreativeTab.tabEnhancedGeologyAltro);
		this.setItemName("martello_geologo");
		this.setMaxStackSize(1);
		this.setNoRepair();
	}
	
	@Override
	public void onUpdate(ItemStack is, World world, Entity e, int par4, boolean par5) {
		if (!is.isItemEnchanted()) {
			is.addEnchantment(Enchantment.fortune, 5);
		}
	}

}
