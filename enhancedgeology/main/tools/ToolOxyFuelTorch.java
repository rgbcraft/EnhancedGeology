package enhancedgeology.main.tools;

import java.util.ArrayList;

import enhancedgeology.main.CreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ToolOxyFuelTorch extends ItemPickaxe {

	final static int MAXDAMAGE = 20;
	
	ArrayList<String> cuttableItems = new ArrayList<String>();

	
	public ToolOxyFuelTorch(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setTextureFile("/enhancedgeology/textures/oggetti.png");
		this.setIconIndex(114);
		this.setMaxDamage(MAXDAMAGE);
		this.setCreativeTab(CreativeTab.tabEnhancedGeologyAltro);
		this.setItemName("OxyFuelTorch");
		this.setMaxStackSize(1);
		this.setNoRepair();
		
		cuttableItems.add("178:0");
		cuttableItems.add("661:0");		
		
		//test
		cuttableItems.add("4057:0");
	}
	
	@Override
	public float getStrVsBlock(ItemStack is, Block par2Block) {	
		
		if (is.getItemDamage() == (MAXDAMAGE - 1)) {
			return 0.1F;
		}
		
		String itemString = par2Block.blockID + ":0";
		boolean breakable = false;

		for(String item: cuttableItems) {
		     if(item.equals(itemString)) {
		         breakable = true;
		         break;
		     }
		}
		return par2Block != null && breakable ? 500.0F : 0.1F;
	}
	
	@Override 
	public void onUpdate (ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		EntityPlayer player = (EntityPlayer) par3Entity;
		
		if (par1ItemStack.getItemDamage() == (MAXDAMAGE - 2)) {
			if (!par2World.isRemote) {
				par1ItemStack.getItem().setIconIndex(113);
			}
			par1ItemStack.setItemDamage(MAXDAMAGE - 1);
		}
		
		if (par1ItemStack.getItemDamage() == (0)) {
			if (!par2World.isRemote && !player.capabilities.isCreativeMode) {
				par1ItemStack.getItem().setIconIndex(114);
			}
			if (!player.capabilities.isCreativeMode) {
				par1ItemStack.damageItem(1, player);
			}
		}
	}
	
}
