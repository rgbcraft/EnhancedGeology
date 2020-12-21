package enhancedgeology.main.tools;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

public class ToolContatoreGeiger extends Item implements IElectricItem {
	// Radioattività minerali
		private static Map<String, Float> mineralRadioactivity = new HashMap();

		public ToolContatoreGeiger(int par1) {
			super(par1);
			this.canRepair = false;
			this.setTextureFile("/enhancedgeology/textures/oggetti.png");
			this.setIconIndex(3);
			this.setMaxDamage(10);
			this.setCreativeTab(CreativeTab.tabEnhancedGeologyAltro);
			this.setItemName("ContatoreGeiger");
			this.setMaxStackSize(1);
			this.setNoRepair();

			// Aggiungi valori di modifica gravità

			mineralRadioactivity.put("16:0", 0.023F);
			mineralRadioactivity.put("247:0", 1.72F);
			mineralRadioactivity.put("146:6", 0.057F);
			mineralRadioactivity.put("146:9", 0.0033F);
			mineralRadioactivity.put("146:10", 1.85F);
			mineralRadioactivity.put("73:0", 0.003F);
			mineralRadioactivity.put("224:3", 12.6762F);

		}

		@Override
		public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side,
				float hitX, float hitY, float hitZ) {
			if (!world.isRemote) {
				if (this.canTakeDamage(itemStack, 1)) {
					player.sendChatToPlayer("");
					player.sendChatToPlayer("\247bColonna:       \2477" + x + ", " + y + ", " + z);
					float reading = radioactivityOfArea(world, x, y, z);
					String readingFmt = new DecimalFormat("#.##").format(reading); 
					if (reading > 5.0F) {
						player.sendChatToPlayer("\247bRadioattività:  \247c" + readingFmt + "  \247ruSv/h");
					} else {
						player.sendChatToPlayer("\247bRadioattività:  \247a" + readingFmt + " \247ruSv/h");
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

		private float radioactivityOfArea(final World worldObj, final int x, final int y, final int z) {
			int totalScore = 0;
			int blocksScanned = 0;
			Random rand = new Random();
			float localRadioactivity = rand.nextFloat() * (0.15F - 0.07F) + 0.07F;
			Float modifier = 0.0F;
			final int range = 2;
			for (int blockY = y; blockY > 0; --blockY) {
				for (int blockX = x - range; blockX <= x + range; ++blockX) {
					for (int blockZ = z - range; blockZ <= z + range; ++blockZ) {
						final int blockId = worldObj.getBlockId(blockX, blockY, blockZ);
						final int metaData = worldObj.getBlockMetadata(blockX, blockY, blockZ);
						modifier = mineralRadioactivity.get(String.valueOf(blockId) + ":" + String.valueOf(metaData));
						if (modifier == null) {
							modifier = 0.0F;
						}
						localRadioactivity = localRadioactivity + (modifier / 10);
					}
				}
			}
			return localRadioactivity;
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
