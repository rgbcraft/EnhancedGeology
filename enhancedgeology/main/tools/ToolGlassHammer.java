package enhancedgeology.main.tools;

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

public class ToolGlassHammer extends ItemPickaxe {

	final static int MAXDAMAGE = 50;

	public ToolGlassHammer(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setTextureFile("/enhancedgeology/textures/oggetti.png");
		this.setIconIndex(12);
		this.setMaxDamage(MAXDAMAGE);
		this.setCreativeTab(CreativeTab.tabEnhancedGeologyAltro);
		this.setItemName("glass_hammer");
		this.setMaxStackSize(1);
		this.setNoRepair();
	}
	
	@Override
	public float getStrVsBlock(ItemStack is, Block par2Block) {
		return par2Block != null && (par2Block.blockMaterial == Material.glass) ? 50.0F : 0.1F;
	}
}