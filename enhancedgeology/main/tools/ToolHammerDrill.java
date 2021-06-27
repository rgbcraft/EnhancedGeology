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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ToolHammerDrill extends ItemPickaxe implements IElectricItem {

	final static int MAXDAMAGE = 13;

	
	public ToolHammerDrill(int par1, EnumToolMaterial par2) {
		super(par1, par2);
		this.canRepair = false;
		this.setTextureFile("/enhancedgeology/textures/oggetti.png");
		this.setIconIndex(1);
		this.setMaxDamage(MAXDAMAGE);
		this.setCreativeTab(CreativeTab.tabEnhancedGeologyAltro);
		this.setItemName("HammerDrill");
		this.setMaxStackSize(1);
		this.setNoRepair();

	}
	/*
	@Override
	public float getStrVsBlock(ItemStack is, Block par2Block) {
		
		if (is.getItemDamage() == (MAXDAMAGE - 1)) {
			return 0.1F;
		}
		return par2Block != null && (par2Block.blockMaterial == Material.iron || par2Block.blockMaterial == Material.anvil || par2Block.blockMaterial == Material.rock) ? 50.0F : 0.1F;
	}
	*/
	

	private boolean canTakeDamage(ItemStack stack, int amount) {
		amount *= 50;
		return ElectricItem.discharge(stack, amount, Integer.MAX_VALUE, true, true) == amount;
	}

	private void damage(final ItemStack is, final int damage, final EntityPlayer player) {
		ElectricItem.use(is, 50 * damage, player);
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
		return 5000;
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