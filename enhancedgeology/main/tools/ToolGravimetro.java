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
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ToolGravimetro extends Item implements IElectricItem {

	// Densità dei minerali
	private static Map<String, Float> mineralDensity = new HashMap();

	public ToolGravimetro(int par1) {
		super(par1);
		this.canRepair = false;
		this.setTextureFile("/enhancedgeology/textures/oggetti.png");
		this.setIconIndex(1);
		this.setMaxDamage(10);
		this.setCreativeTab(CreativeTab.tabEnhancedGeologyAltro);
		this.setItemName("Gravimetro");
		this.setMaxStackSize(1);
		this.setNoRepair();

		// Aggiungi valori di modifica gravità

		mineralDensity.put("14:0", 0.6F);
		mineralDensity.put("15:0", 0.2F);
		mineralDensity.put("16:0", -0.2F);
		mineralDensity.put("56:0", 0.3F);
		mineralDensity.put("247:0", 0.65F);
		mineralDensity.put("458:0", -0.3F);
		mineralDensity.put("13:0", -0.15F);
		mineralDensity.put("146:0", 0.05F);
		mineralDensity.put("146:1", 0.06F);
		mineralDensity.put("146:2", 0.08F);
		mineralDensity.put("146:3", 0.12F);
		mineralDensity.put("146:4", 0.02F);
		mineralDensity.put("146:5", -0.3F);
		mineralDensity.put("146:6", 0.04F);
		mineralDensity.put("146:7", 0.08F);
		mineralDensity.put("146:8", 0.1F);
		mineralDensity.put("146:9", 0.3F);
		mineralDensity.put("146:10", 0.1F);
		mineralDensity.put("255:1", 0.6F);
		mineralDensity.put("255", 0.12F);
		mineralDensity.put("73:0", -0.12F);
		mineralDensity.put("129:0", 0.14F);
		mineralDensity.put("254:0", 0.145F);
		mineralDensity.put("2001:0", -0.05F);
		mineralDensity.put("1398:1", -0.05F);
		mineralDensity.put("1398:2", -0.1F);
		mineralDensity.put("2001:1", -0.1F);
		mineralDensity.put("2001:2", 0.2F);
		mineralDensity.put("2001:3", 0.64F);

	}

	@Override
	public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side,
			float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			if (this.canTakeDamage(itemStack, 1)) {
				player.sendChatToPlayer("");
				player.sendChatToPlayer("\247bColonna: \2477" + x + ", " + y + ", " + z);
				float reading = gravityOfArea(world, x, y, z);
				if (reading > 981000.0F) {
					player.sendChatToPlayer("\247bGravità:  \247c" + reading + "  \247rmgal");
				} else if (reading == 981000.0F) {
					player.sendChatToPlayer("\247bGravità:  \247a" + reading + " \247rmgal");
				} else {
					player.sendChatToPlayer("\247bGravità:  \247e" + reading + " \247rmgal");
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

	private float gravityOfArea(final World worldObj, final int x, final int y, final int z) {
		int totalScore = 0;
		int blocksScanned = 0;
		float localGravity = 981000.0F;
		Float modifier = 0.0F;
		final int range = 2;
		for (int blockY = y; blockY > 0; --blockY) {
			for (int blockX = x - range; blockX <= x + range; ++blockX) {
				for (int blockZ = z - range; blockZ <= z + range; ++blockZ) {
					final int blockId = worldObj.getBlockId(blockX, blockY, blockZ);
					final int metaData = worldObj.getBlockMetadata(blockX, blockY, blockZ);
					modifier = mineralDensity.get(String.valueOf(blockId) + ":" + String.valueOf(metaData));
					if (modifier == null) {
						modifier = 0.0F;
					}
					localGravity = localGravity + modifier;
				}
			}
		}
		return localGravity;
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