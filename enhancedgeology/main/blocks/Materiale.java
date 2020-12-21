package enhancedgeology.main.blocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enhancedgeology.main.CreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Materiale extends Block {

	public Materiale(int id) {
		super(id, Material.rock);
		this.setBlockName("materiale");
		this.setTextureFile("/enhancedgeology/textures/materiali.png");
		this.setCreativeTab(CreativeTab.tabEnhancedGeologyMateriali);
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
