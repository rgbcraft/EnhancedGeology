package enhancedgeology.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockCustomStairs extends BlockStairs {

	public static Block modelBlock;
    private final int field_72158_c;

	
	public BlockCustomStairs(int id, Block modelBlock, int blockMetadata, String blockName) {
		super(id, modelBlock, blockMetadata);
		this.setBlockName(blockName);
        this.field_72158_c = blockMetadata;
		this.modelBlock = modelBlock;
		this.setLightOpacity(0);
		this.setTextureFile(modelBlock.getTextureFile());
	}
}