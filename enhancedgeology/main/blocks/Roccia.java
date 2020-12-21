package enhancedgeology.main.blocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enhancedgeology.main.CreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Roccia extends Block {

	public Roccia(int id) {
		super(id, Material.rock);
		this.setBlockName("roccia");
		this.setTextureFile("/enhancedgeology/textures/rocce.png");
		this.setCreativeTab(CreativeTab.tabEnhancedGeologyRocce);
		this.setHardness(1.7F);
		this.setResistance(15.0F);
		
	}
	
	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBlockTextureFromSideAndMetadata(int side, int metadata) {
		return metadata;
	}
}
