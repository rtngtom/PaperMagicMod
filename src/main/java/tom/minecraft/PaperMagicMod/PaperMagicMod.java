package tom.minecraft.PaperMagicMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import tom.minecraft.PaperMagicMod.item.MinorArcana;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(name = PaperMagicMod.modname, modid = PaperMagicMod.modid, version = PaperMagicMod.version)
public class PaperMagicMod {
	public static final String modid = "papermagic";
	public static final String modname = "Paper Magic Mod";
	public static final String version = "0.0.0";
	
    @SidedProxy(clientSide="tom.minecraft.PaperMagicMod.ClientProxy", serverSide="tom.minecraft.PaperMagicMod.ServerProxy")
    public static CommonProxy proxy;
    
	public static CreativeTabs paperMagicTab = new CreativeTabs("Paper Magic"){
		public Item getTabIconItem() {
			return Items.paper;
		}
	};
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.Init(e);
	}
	
	
	@EventHandler
    public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
    }
}
