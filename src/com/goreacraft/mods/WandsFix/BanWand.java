package com.goreacraft.mods.WandsFix;

import java.io.File;


import net.minecraft.util.IChatComponent;
//import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class BanWand {
	private static String[] registrations = Main.Wandsbanlist.split("\\|");
	private static String[][] wands = RegistrationsSplit(registrations);
	IChatComponent aa;
	public static String[][] RegistrationsSplit(String[] args2) {
		int rows = BanWand.registrations.length;
		String[][] asd2 = new String[rows][5];
		
		for (int i=0;i < rows;i++ )
		{
		asd2[i] = args2[i].split("[;:,]");				
		}
		return asd2;
		
	}

	//@ForgeSubscribe
	public void onUsingWand(PlayerInteractEvent event)
	{ 
		//System.out.println(event.entityPlayer.inventory.getCurrentItem().getItem().getUnlocalizedName());
		if(!event.entityPlayer.worldObj.isRemote && event.entityPlayer.getHeldItem() != null);// && event.entityPlayer.inventory.getCurrentItem().getItem()== thaumcraft.api.wands .getItem("itemWandCasting", 0).getItem() && event.entityPlayer.getHeldItem().getTagCompound() != null)
			{	
			for (int j =0; j< registrations.length;j++)
				
				{
				try {
				//System.out.println(event.entityPlayer.inventory.getCurrentItem().getTagCompound().getTags().toString());
				
				//int aaa=thaumcraft.api.ItemApi.getItem(("itemFocus"+wands[j][0]).toString(), 0).getItem().itemID;
				
				if (event.entityPlayer.inventory.getCurrentItem().getTagCompound().hasKey(wands[j][0]))
					{
						if (wands[j][1].equalsIgnoreCase("all"))
							{
							
							aa.appendText("This wand focus is banned in all worlds.");
							event.entityPlayer.addChatMessage(aa);									
							event.setCanceled(true);
							return;									
							}
						else 
							{
							for (int k=1; k<wands[j].length;k++)
								{								
								//System.out.println(wands[j][k]);
								if (wands[j][k]==null)
								{ return; } 
								else if (Integer.valueOf(wands[j][k]).equals(event.entityPlayer.dimension))
									{
									//thaumcraft.api.ItemApi.getItem("itemFocus"+"Fire", 0).getItem().itemID);
									event.entityPlayer.addChatMessage(aa.appendText(Main.chatmessage));												
									event.setCanceled(true);
									return;
									
									}
								}
							}
					}
				}catch (Exception e) 
				{
					System.out.println("There is a problem loading \"" + wands[j][0] +"\" in Gorea" + File.separator + "ThaumcraftWands.cfg, result: " + e.getMessage());
				} 
				}
			}			
	}
				
}

