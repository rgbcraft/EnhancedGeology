package enhancedgeology.main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enhancedgeology.main.blocks.Blocks;
import enhancedgeology.main.items.Items;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {

	private String name;
	public static CreativeTabs tabEnhancedGeologyRocce = new CreativeTab(CreativeTabs.getNextID(), "EnhancedGeology - Rocce");
	public static CreativeTabs tabEnhancedGeologyMateriali = new CreativeTab(CreativeTabs.getNextID(), "EnhancedGeology - Materiali");
	public static CreativeTabs tabEnhancedGeologyMinerali = new CreativeTab(CreativeTabs.getNextID(), "EnhancedGeology - Minerali");
	public static CreativeTabs tabEnhancedGeologyAltro = new CreativeTab(CreativeTabs.getNextID(), "EnhancedGeology - Altro");
	public static CreativeTabs tabEnhancedGeologyRadiologia = new CreativeTab(CreativeTabs.getNextID(), "EnhancedGeology - Radiologia");

	public CreativeTab(int par1, String par2Str) {
		super(par1, par2Str);
		this.name = par2Str;
	}
	
	@Override
	public String toString() {
		return super.getTabLabel();
	}
	
	@SideOnly(Side.CLIENT) 
	public ItemStack getIconItemStack() {
		if(this.name == tabEnhancedGeologyRocce.getTabLabel()) {
			return new ItemStack(Blocks.roccia);
		} else if (this.name == tabEnhancedGeologyMateriali.getTabLabel()) {
			return new ItemStack(Blocks.materiale);
		} else if (this.name == tabEnhancedGeologyAltro.getTabLabel()) {
			return new ItemStack(Items.MartelloGeologo);
		} else if (this.name == tabEnhancedGeologyMinerali.getTabLabel()) {
			return new ItemStack(Items.Zircone);
		} else if (this.name == tabEnhancedGeologyRadiologia.getTabLabel()) {
			return new ItemStack(Items.LECell);
		}
		return null;
	}
	
	
	@Override
	public String getTranslatedTabLabel() {
		return this.name;
	}

}
