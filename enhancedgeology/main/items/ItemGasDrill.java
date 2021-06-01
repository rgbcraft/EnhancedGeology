package enhancedgeology.main.items;

import enhancedgeology.main.CreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class ItemGasDrill extends ItemPickaxe {

	final static int MAXDAMAGE = 1000;
	final static int FUELLOWWARNINGLEVEL = MAXDAMAGE - (MAXDAMAGE / 100 * 15);
	
	public ItemGasDrill(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setTextureFile("/enhancedgeology/textures/oggetti.png");
		this.setIconIndex(11);
		this.setMaxDamage(MAXDAMAGE);
		this.setCreativeTab(CreativeTab.tabEnhancedGeologyAltro);
		this.setItemName("gas_drill");
		this.setMaxStackSize(1);
		this.setNoRepair();
	}
	
	@Override
	public float getStrVsBlock(ItemStack is, Block par2Block) {
		
		if (is.getItemDamage() == (MAXDAMAGE - 1)) {
			return 0.1F;
		}
		return par2Block != null && (par2Block.blockMaterial == Material.iron || par2Block.blockMaterial == Material.anvil || par2Block.blockMaterial == Material.rock) ? 50.0F : 0.1F;
	}
	
	@Override 
	public void onUpdate (ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		EntityPlayer player = (EntityPlayer) par3Entity;
		
		if (par1ItemStack.getItemDamage() == (MAXDAMAGE - 2)) {
			if (!par2World.isRemote) {
				par2World.playSoundAtEntity(par3Entity, "EnhGeo_RanOutOfGas", 1.0F, 1.0F);
			}
			par1ItemStack.setItemDamage(MAXDAMAGE - 1);
		}
		
		if (par1ItemStack.getItemDamage() == (0)) {
			if (!par2World.isRemote && !player.capabilities.isCreativeMode) {
				par2World.playSoundAtEntity(player, "EnhGeo_StartDrill", 1.0F, 1.0F);
			}
			if (!player.capabilities.isCreativeMode) {
				par1ItemStack.damageItem(1, player);
			}
		}
	}
}
