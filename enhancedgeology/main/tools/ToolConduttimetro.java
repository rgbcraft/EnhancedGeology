package enhancedgeology.main.tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enhancedgeology.main.CreativeTab;
import ic2.api.ElectricItem;
import ic2.api.IElectricItem;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class ToolConduttimetro extends Item implements IElectricItem {

	// Conduttività dei minerali
	private static Map<String, Float> mineralConductivity = new HashMap();

	public ToolConduttimetro(int par1) {
		super(par1);
		this.canRepair = false;
		this.setTextureFile("/enhancedgeology/textures/oggetti.png");
		this.setIconIndex(2);
		this.setMaxDamage(10);
		this.setCreativeTab(CreativeTab.tabEnhancedGeologyAltro);
		this.setItemName("Conduttimetro");
		this.setMaxStackSize(1);
		this.setNoRepair();

		// Aggiungi valori di modifica gravità

		mineralConductivity.put("14:0", 0.1F);
		mineralConductivity.put("15:0", 0.12F);
		mineralConductivity.put("16:0", -0.5F);
		mineralConductivity.put("56:0", -0.9F);
		mineralConductivity.put("247:0", -0.2F);
		mineralConductivity.put("458:0", -0.9F);
		mineralConductivity.put("13:0", -0.2F);
		mineralConductivity.put("146:0", -0.12F);
		mineralConductivity.put("146:1", 0.007F);
		mineralConductivity.put("146:2", -0.2F);
		mineralConductivity.put("146:3", 0.05F);
		mineralConductivity.put("146:4", 0.05F);
		mineralConductivity.put("146:5", -0.2F);
		mineralConductivity.put("146:6", 0.01F);
		mineralConductivity.put("146:7", -0.2F);
		mineralConductivity.put("146:8", -0.2F);
		mineralConductivity.put("146:9", 0.03F);
		mineralConductivity.put("146:10", -0.2F);
		mineralConductivity.put("255:1", -0.2F);
		mineralConductivity.put("255", -0.2F);
		mineralConductivity.put("73:0", 0.11F);
		mineralConductivity.put("129:0", -0.2F);
		mineralConductivity.put("254:0", -0.2F);
		mineralConductivity.put("2001:0", 0.8F);
		mineralConductivity.put("1398:1", 0.8F);
		mineralConductivity.put("1398:2", 0.3F);
		mineralConductivity.put("2001:1", 0.3F);
		mineralConductivity.put("2001:2", 0.6F);
		mineralConductivity.put("2001:3", 0.1F);
		mineralConductivity.put("8:0", 0.4F);
		mineralConductivity.put("9:0", 0.4F);
	}

	@Override
	public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side,
			float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			if (this.canTakeDamage(itemStack, 1)) {
				player.sendChatToPlayer("");
				player.sendChatToPlayer("\247bColonna:       \2477" + x + ", " + y + ", " + z);
				float reading = conductivityOfArea(world, x, y, z);
				if (reading > 0.3F) {
					player.sendChatToPlayer("\247bConduttività:  \247c" + reading + "  \247rmS/m");
				} else if (reading == 0.3F) {
					player.sendChatToPlayer("\247bConduttività:  \247a" + reading + " \247rmS/m");
				} else if (reading <= 0.0F) {
					player.sendChatToPlayer("\247bConduttività:  \247aOL \247rmS/m");
				} else {
					player.sendChatToPlayer("\247bConduttività:  \247e" + reading + " \247rmS/m");
				}
				if (itemStack.getItemDamage() > 7) {
					player.sendChatToPlayer("\247cBatteria scarica");
				}
				player.sendChatToPlayer("");
				this.damage(itemStack, 10, player);
				return true;
			}
		}
		return false;
	}

	private float conductivityOfArea(final World worldObj, final int x, final int y, final int z) {
		int totalScore = 0;
		int blocksScanned = 0;
		float localConductivity = 0.3F;
		Float modifier = 0.0F;
		final int range = 2;
		for (int blockY = y; blockY > 0; --blockY) {
			for (int blockX = x - range; blockX <= x + range; ++blockX) {
				for (int blockZ = z - range; blockZ <= z + range; ++blockZ) {
					final int blockId = worldObj.getBlockId(blockX, blockY, blockZ);
					final int metaData = worldObj.getBlockMetadata(blockX, blockY, blockZ);
					modifier = mineralConductivity.get(String.valueOf(blockId) + ":" + String.valueOf(metaData));
					if (modifier == null) {
						modifier = 0.0F;
					}
					
					localConductivity = localConductivity + (modifier / 100);
				}
			}
		}
		if (worldObj.getBiomeGenForCoords(x, z) == BiomeGenBase.ocean || worldObj.getBiomeGenForCoords(x, z) == BiomeGenBase.frozenOcean) {
			localConductivity = localConductivity + 100;
		};
		return localConductivity;
	}

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