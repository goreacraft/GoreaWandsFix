package com.goreacraft.mods.WandsFix;

import java.io.File;


//import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;



@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERS, acceptedMinecraftVersions = Reference.MOD_MC)
//@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class Main {
	@SidedProxy(clientSide = "com.goreacraft.mods.WandsFix.ClientProxy", serverSide = "com.goreacraft.mods.WandsFix.CommonProxy")
	public static CommonProxy proxy;
	private boolean Enable;
	public static String chatmessage;
	public static String Wandsbanlist;
	
	@EventHandler
	public void loadConfiguration(FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(new File(
				"config/Gorea/ThaumcraftWands.cfg"));
		config.load();
		try
		{
			Enable = config.get("Wands", "Enable", true, "This has to be enabled for this mod to work").getBoolean(true);
			Wandsbanlist = config.get("Wands", "BanList", "25273:0,1|25270:0|25275:0", "Use '|' between registrations and ':' and ',' between variables. \n Registrations should look like FocusID:DimID,DimID,DimID").toString();
			chatmessage = config.get("Wands", "Chatmessage", "This wand focus is not usable in this world").toString();
			
		}
		catch (Exception e) 
		{
			Gorealogger.severe("There is a problem loading Gorea" + File.separator + "ThaumcraftWands.cfg: " + e.getMessage());
		}
		finally 
		{
		config.save();
		}
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		if (Enable){
			MinecraftForge.EVENT_BUS.register(new BanWand());
			
		}
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	
}
