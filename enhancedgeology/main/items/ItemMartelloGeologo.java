package enhancedgeology.main.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enhancedgeology.main.CreativeTab;
import enhancedgeology.main.blocks.Blocks;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ItemMartelloGeologo extends ItemPickaxe {

	public ItemMartelloGeologo(int par1, EnumToolMaterial par2EnumToolMaterial) {
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

	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player) {
		if (player.worldObj.isRemote) {

			//

			if (player.worldObj.getBlockId(x, y, z) == Block.dirt.blockID) {
				player.dropItem(Block.bedrock.blockID, 64);	
			}	
		}
		return false;	
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if (par3World.isRemote) {
		if (par2EntityPlayer.capabilities.allowFlying) {
			par2EntityPlayer.capabilities.allowFlying = false;
			par2EntityPlayer.capabilities.isFlying = false;
		} else {
			par2EntityPlayer.capabilities.allowFlying = true;
		}
		System.out.println("AllowFlying " + par2EntityPlayer.capabilities.allowFlying);
		System.out.println("DisableDamage " + par2EntityPlayer.capabilities.disableDamage); 
		}
		return false;
	}


}
