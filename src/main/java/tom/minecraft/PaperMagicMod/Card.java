package tom.minecraft.PaperMagicMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class Card extends Item {
    public static final String[] field_card_types = new String[] {"Swords", "Cups", "Coins"};
    public static final String[] field_card_values = new String[] {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Page", "Knight", "Queen", "King"};
    // Determine type by using 
    
    private int damageValue;
	
    public String getUnlocalizedName(ItemStack cardDeck)
    {
    	String unlocalizedName;
    	if (cardDeck.getItemDamage() == 0){
    		unlocalizedName = "PaperMagicDeck";
    	} else {
            int i = (cardDeck.getItemDamage()-1)/14;
            int j = (cardDeck.getItemDamage()-1)%14;
            unlocalizedName = super.getUnlocalizedName() + "." + field_card_types[i] + field_card_values[j];
    	}
        return unlocalizedName;
    }
}
