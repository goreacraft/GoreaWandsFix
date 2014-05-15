package com.goreacraft.mods.WandsFix;


public class WandFix {
	private static String[] registrations = Main.Wandsbanlist.split("\\|");
	@SuppressWarnings("unused")
	private static String[][] wands = RegistrationsSplit(registrations);
	
	
	public static String[][] RegistrationsSplit(String[] args2) {
		int rows = WandFix.registrations.length;
		String[][] asd2 = new String[rows][2];
		
		for (int i=0;i < rows;i++ ){
		asd2[i] = args2[i].split("[;:,]");				
			}
		return asd2;
		
	}
	
/*	public Object location(){
		MovingObjectPosition objectMouseOver;// = mc.objectMouseOver;
		if (objectMouseOver != null)
		{
		    if (objectMouseOver.typeOfHit == EnumMovingObjectType.ENTITY)
		    {
		        return objectMouseOver.entityHit.getEntityName();
		    }
		    else if (objectMouseOver.typeOfHit == EnumMovingObjectType.TILE)
		    {
		        Block block = Block.blocksList[World.getBlockId(objectMouseOver.blockX, objectMouseOver.blockY, objectMouseOver.blockZ)];
		        if (block != null)
		        {
		            ItemStack pickBlock = block.getPickBlock(objectMouseOver, world, objectMouseOver.blockX, objectMouseOver.blockY, objectMouseOver.blockZ);
		            if (pickBlock != null)
		            {
		                return pickBlock.getDisplayName();
		            }
		            return block.getLocalizedName();
		        }
		    }
		}
	}*/
	/*private int getMovingObjectPositionFromPlayer(World world, EntityPlayer entityplayer, boolean flag, double reach, String xyz)
	{
		float f = 1.0F;
		float playerPitch = entityplayer.prevRotationPitch + (entityplayer.rotationPitch - entityplayer.prevRotationPitch) * f;
		float playerYaw = entityplayer.prevRotationYaw + (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f;
		double playerPosX = entityplayer.prevPosX + (entityplayer.posX - entityplayer.prevPosX) * f;
		double playerPosY = (entityplayer.prevPosY + (entityplayer.posY - entityplayer.prevPosY) * f + 1.6200000000000001D) - entityplayer.yOffset;
		double playerPosZ = entityplayer.prevPosZ + (entityplayer.posZ - entityplayer.prevPosZ) * f;
		Vec3 vecPlayer = Vec3.createVectorHelper(playerPosX, playerPosY, playerPosZ);
		float cosYaw = MathHelper.cos(-playerYaw * 0.01745329F - 3.141593F);
		float sinYaw = MathHelper.sin(-playerYaw * 0.01745329F - 3.141593F);
		float cosPitch = -MathHelper.cos(-playerPitch * 0.01745329F);
		float sinPitch = MathHelper.sin(-playerPitch * 0.01745329F);
		float pointX = sinYaw * cosPitch;
		float pointY = sinPitch;
		float pointZ = cosYaw * cosPitch;
		Vec3 vecPoint = vecPlayer.addVector(pointX * reach, pointY * reach, pointZ * reach);
		MovingObjectPosition movingobjectposition = world..rayTraceBlocks_do_do(vecPlayer, vecPoint, flag, !flag);
		if (xyz == "x") return (int) movingobjectposition.blockX;
		if (xyz == "y") return (int) movingobjectposition.blockY;
		if (xyz == "z") return (int) movingobjectposition.blockZ;
		else return 0;
	}*/
	
	/*@ForgeSubscribe
	public void onUsingWand21(PlayerInteractEvent event)
	{
		if(!event.entityPlayer.worldObj.isRemote && event.entityPlayer.getHeldItem().getItemUseAction().name()=="bow" && event.entityPlayer.getHeldItem() != null)
			
			if(event.entityPlayer.inventory.getCurrentItem().itemID==25266)
			 
				if (event.entityPlayer.getHeldItem().getUnlocalizedName().lastIndexOf("WandCasting")>0)
				{
					
				}
				
	}*/
		
	
		
		//System.out.println(event);
		
	}
/*@ForgeSubscribe
public void onUsingWand2(PlayerInteractEvent event)
{
	
	if(!event.entityPlayer.worldObj.isRemote && event.entityPlayer.getHeldItem().getItemUseAction().name()=="bow" && event.entityPlayer.getHeldItem() != null)
	{
		
		System.out.println(event.entityPlayer.inventory.getCurrentItem().itemID);
		
		if(event.entityPlayer.inventory.getCurrentItem().itemID==25266)
		{ 
			if (event.entityPlayer.getHeldItem().getUnlocalizedName().lastIndexOf("WandCasting")>0)
			{ 			
					System.out.println("______________________");
					int posx= (getMovingObjectPositionFromPlayer(event.entityPlayer.worldObj, event.entityPlayer, true, 200, "x"));
					int posy= (getMovingObjectPositionFromPlayer(event.entityPlayer.worldObj, event.entityPlayer, true, 200, "y"));
					int posz= (getMovingObjectPositionFromPlayer(event.entityPlayer.worldObj, event.entityPlayer, true, 200, "z"));
						if (event.entityPlayer.worldObj.getBlockId(posx, posy, posz)==1)
						{
							event.setCanceled(true);
						} //else return;
									
					
					//System.out.println(event.entityPlayer.getHeldItem().getUnlocalizedName().lastIndexOf("WandCasting"));
					//System.out.println(event.entityPlayer.dimension);
					//event.entityPlayer.addChatMessage(event.entityPlayer.dimension);
					
					
					
					int n = Main.Wandsbanlist.lastIndexOf(event.entityPlayer.getHeldItem().getTagCompound().getTags().toString());
					if (n > 0)
						{
						for (int j =0; j< registrations.length;j++)
						{
							for (int k=1; k < wands[j].length;k++)
								{
									if (wands[j][k] == event.entityPlayer.getEntityWorld().toString())
									 //event.entityPlayer.addChatMessage("\u00a7b--- www.goreacraft.com ---");
									event.entityPlayer.addChatMessage(Main.chatmessage);
									// System.out.println("This wand fosus is not usable in this world");
									event.setCanceled(true);
								}
						 }
							 	//System.out.println(event.entityPlayer.getHeldItem().getUnlocalizedName().substring(5, event.entityPlayer.getHeldItem().getUnlocalizedName().length()));
							 	System.out.println(event.entityPlayer.getHeldItem().getUnlocalizedName().lastIndexOf("WandCasting")>0);
								System.out.println("______________________");
							}
				}
		}
	}

}*/


