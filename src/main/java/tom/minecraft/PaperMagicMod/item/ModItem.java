package tom.minecraft.PaperMagicMod.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import tom.minecraft.PaperMagicMod.PaperMagicMod;

public class ModItem extends Item {
	
	public static Item MinorArcana;
	   
	public static final void Init(){

		// PreInit for MinorArcana
		MinorArcana = new MinorArcana(1, PaperMagicMod.paperMagicTab,"MinorArcana");
		
		// Register created items
		GameRegistry.registerItem(MinorArcana, "paperMagicMinor");
		System.out.println("Cards Registered.");
	}
		

}
