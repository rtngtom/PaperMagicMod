package tom.minecraft.PaperMagicMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import scala.util.Random;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class MinorArcana extends Item {
    public static final String[] field_card_types = new String[] {"swords", "cups", "coins", "wands"};
    public static final String[] field_card_values = new String[] {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Page", "Knight", "Queen", "King"};
    // Determine type by using 
    
    private int damageValue;
    
   private Random rando = new Random();
	
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
    
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player){
    	player.setItemInUse(item, 100);
		return item;
    	
    }
    
    public void onPlayerStoppedUsing(ItemStack item, World world, EntityPlayer player, int i){
    	int exp = rando.nextInt(14)+1; 
    	if(player.experienceLevel<50){
    		float expGain = (float)player.xpBarCap()/(float)(15-exp);
    		if(expGain-(int)expGain>0.5) expGain = (float)Math.ceil(expGain);
    		else expGain = (float)Math.floor(expGain);
    		player.addExperience((int)expGain);
    		player.addChatMessage(new ChatComponentText("You drew the " + field_card_values[exp-1] + " of Swords."));
    	}
    }
}
