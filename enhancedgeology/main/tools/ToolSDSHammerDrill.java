package enhancedgeology.main.tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enhancedgeology.main.CreativeTab;
import enhancedgeology.main.handlers.CraftingHandler;
import enhancedgeology.main.items.Items;
import ic2.api.ElectricItem;
import ic2.api.IElectricItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ToolSDSHammerDrill extends ItemPickaxe implements IElectricItem {
	
	public ToolSDSHammerDrill(int par1, EnumToolMaterial par2) {
		super(par1, par2);

		this.setTextureFile("/enhancedgeology/textures/oggetti.png");
		this.setIconIndex(14);
		this.setCreativeTab(CreativeTab.tabEnhancedGeologyAltro);
		this.setItemName("SDSHammerDrill");
		this.setMaxStackSize(1);
        this.setMaxDamage(27);
        this.setNoRepair();

	}


	@Override
	public float getStrVsBlock(ItemStack is, Block par2Block) {
		if (this.canTakeDamage(is, 10)) {
			if (par2Block.blockID == 230 || par2Block.blockID == 231)
				return super.getStrVsBlock(is, par2Block) + 500.0f;
		}
		return 0.5f;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLiving par7EntityLiving) {
		if (par7EntityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) par7EntityLiving;
			if (!player.capabilities.isCreativeMode) {
				this.damage(par1ItemStack, 10, player);
			}
		}
		return true;
	}
	

	private boolean canTakeDamage(ItemStack stack, int amount) {
        amount *= 50;
        return ElectricItem.discharge(stack, amount, Integer.MAX_VALUE, true, true) == amount;
    }

    private void damage(ItemStack itemStack, int amount, EntityPlayer player) {
        ElectricItem.use(itemStack, 50 * amount, player);
    }

	@Override
	public boolean canProvideEnergy() {
		return false;
	}

	@Override
	public int getChargedItemId() {
		return super.itemID;
	}

	@Override
	public int getEmptyItemId() {
		return super.itemID;
	}

	@Override
	public int getMaxCharge() {
		return 25000;
	}

	@Override
	public int getTier() {
		return 1;
	}

	@Override
	public int getTransferLimit() {
		return 250;
	}

	public void getSubItems(final int i, final CreativeTabs tabs, final List itemList) {
		final ItemStack charged = new ItemStack((Item) this, 1);
		ElectricItem.charge(charged, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false);
		itemList.add(charged);
		itemList.add(new ItemStack((Item) this, 1, this.getMaxDamage()));
	}

	public boolean getIsRepairable(final ItemStack par1ItemStack, final ItemStack par2ItemStack) {
		return false;
	}

}