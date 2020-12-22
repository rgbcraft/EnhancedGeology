package enhancedgeology.main.tools;

import java.text.DecimalFormat;

import enhancedgeology.main.CreativeTab;
import enhancedgeology.main.items.Items;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class ToolBateia extends Item {

	private int antiClickSpam = 0;

	public ToolBateia(int par1) {
		super(par1);
		this.canRepair = false;
		this.setTextureFile("/enhancedgeology/textures/oggetti.png");
		this.setIconIndex(5);
		this.setMaxDamage(100);
		this.setCreativeTab(CreativeTab.tabEnhancedGeologyAltro);
		this.setItemName("Bateia");
		this.setMaxStackSize(1);
	}
	
	
	
	
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
    {
        return true;
    }


	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side,
			float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			if (itemStack.getItemDamage() <= 99) {
				if (world.getBlockMaterial(x, y + 1, z).equals(Material.water) && player.isInWater() == true) {
					if (world.getBiomeGenForCoords(x, z).equals(BiomeGenBase.frozenRiver)) {
						itemStack.damageItem(4, player);
						player.addExhaustion(1.2F);
						return true;
					} else if (world.getBiomeGenForCoords(x, z).equals(BiomeGenBase.river)) {
						itemStack.damageItem(2, player);
						player.addExhaustion(0.3F);
						return true;
					} else if (itemStack.getItemDamage() - 10 > 0) {
						player.addExhaustion(0.05F);
						itemStack.damageItem(-4, player);
						return true;
					}
				}
				player.sendChatToPlayer("Bisogna essere in acqua per usare la bateia");
				return false;
			}
			player.sendChatToPlayer("La bateia è piena!");
		}
		return false;
	}

	@Override
	public int getIconFromDamage(int dmg) {
		if (dmg < 25) {
			return 5;
		} else if (dmg < 50 && dmg >= 25) {
			return 6;
		} else if (dmg < 75 && dmg >= 50) {
			return 7;
		}
		return 8;
	}
}
