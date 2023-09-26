package enhancedgeology.main.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enhancedgeology.main.CreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockMaterialeSlab extends BlockHalfSlab {

	/** The type of tree this slab came from. */
    public static final String[] materialType = new String[] {"polishedAndesite", "polishedDiorite", "polishedGranite", "mattoniTufo"};

    public BlockMaterialeSlab(int par1, boolean par2)
    {
        super(par1, par2, Material.rock);
        this.setTextureFile("/enhancedgeology/textures/materiali.png");
        this.setCreativeTab(CreativeTab.tabEnhancedGeologyMateriali);
        this.setHardness(1.0f);
		this.setLightOpacity(0);
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        switch (par2 & 7)
        {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
            	return 3;
            default:
                return 0;
        }
    }

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    public int getBlockTextureFromSide(int par1)
    {
        return this.getBlockTextureFromSideAndMetadata(par1, 0);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        //return Block.woodSingleSlab.blockID;
   		return Blocks.materialeSingleSlab.blockID;
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(Blocks.materialeSingleSlab.blockID, 2, par1 & 7);
    }

    /**
     * Returns the slab block name with step type.
     */
    public String getFullSlabName(int par1)
    {
        if (par1 < 0 || par1 >= materialType.length)
        {
            par1 = 0;
        }

        return super.getBlockName() + "." + materialType[par1];
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        if (par1 != Blocks.materialeSlab.blockID)
        {
            for (int var4 = 0; var4 < 4; ++var4)
            {
                par3List.add(new ItemStack(par1, 1, var4));
            }
        }
    }
}