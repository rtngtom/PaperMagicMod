package tom.minecraft.PaperMagicMod;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import tom.minecraft.PaperMagicMod.item.ModItem;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e){
		ModItem.Init();
	}
	
	public void Init(FMLInitializationEvent e){
		
	}

	public void postInit(FMLPostInitializationEvent e){
	}

}

