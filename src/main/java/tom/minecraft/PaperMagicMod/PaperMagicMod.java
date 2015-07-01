package tom.minecraft.PaperMagicMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(name = PaperMagicMod.modname, modid = PaperMagicMod.modid, version = PaperMagicMod.version)
public class PaperMagicMod {
	public static final String modid = "papermagic";
	public static final String modname = "Paper Magic Mod";
	public static final String version = "0.0.0";
	
    public static Item MinorArcana;
	
	public static CreativeTabs paperMagicTab = new CreativeTabs("Paper Magic"){
		public Item getTabIconItem() {
			return Items.paper;
		}
	};
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		
		// PreInit for MinorArcana
	    MinorArcana = new MinorArcana();
        
	    MinorArcana.setMaxStackSize(1);
	    MinorArcana.setCreativeTab(PaperMagicMod.paperMagicTab);
	    MinorArcana.setUnlocalizedName("Card");

	    
	    // Register created items
	    GameRegistry.registerItem(MinorArcana, "paperMagicCard");
	    System.out.println("Cards Registered.");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
	}
	
	
	@EventHandler
    public void postInit(FMLPostInitializationEvent e) {
		System.out.println("Mod loaded.");
    }
}
