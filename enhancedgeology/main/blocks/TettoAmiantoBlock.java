package enhancedgeology.main.blocks;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enhancedgeology.main.CreativeTab;
import enhancedgeology.main.entities.TileEntityTettoAmianto;
import javazoom.jl.player.Player;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TettoAmiantoBlock extends BlockContainer {
	public static final String name = "TettoAmianto";

	public TettoAmiantoBlock(int id, int texture) {
		super(id, Material.iron);
		setHardness(0.6F);
		setResistance(0.6F);
		setStepSound(Block.soundMetalFootstep);
		setCreativeTab(CreativeTab.tabEnhancedGeologyMateriali);
		setBlockName("TettoAmianto");
		blockIndexInTexture = 4;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
		return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
		return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
	}

	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
	      setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.2F, 1.0F);
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entity) {
		if ((entity instanceof EntityPlayer)) {
			int yaw = (int) entity.rotationYaw;

			if (yaw < 0)
				yaw += 360;
			yaw += 22;
			yaw %= 360;
			int facing = yaw / 45;

			world.setBlockAndMetadataWithNotify(x, y, z, Blocks.TettoAmianto.blockID, facing / 2);
		}
	}

	public int getRenderType() {
		return -1;
	}

	public String getTextureFile() {
		return "/enhancedgeology/textures/oggetti.png";
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int idDropped(int par1, int par2) {
		return blockID;
	}

	public int quantityDropped() {
		return 1;
	}

	public TileEntity createNewTileEntity(World world) {
		return null;
	}

	public TileEntity createTileEntity(World world, int meta) {
		return new TileEntityTettoAmianto();
	}
}