package tom.minecraft.PaperMagicMod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import java.util.List;
import scala.util.Random;
import tom.minecraft.PaperMagicMod.PaperMagicMod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class MinorArcana extends Item {
    public static final String[] field_card_types = new String[] {"Swords", "Cups", "Coins", "Wands"};
    public static final String[] field_card_values = new String[] {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Page", "Knight", "Queen", "King"};
    // Determine type by using 
    
    public String getUnlocalizedName(ItemStack item){
    	return super.getUnlocalizedName(item) + "_" + item.getItemDamage();
    }
    
    public Item setUnlocalizedName(String name){
		super.setUnlocalizedName(name);
		return this;
    }
    
    public MinorArcana(int stackSize, CreativeTabs tab, String name){
    	this.setMaxStackSize(stackSize);
    	this.setCreativeTab(tab);
    	this.setUnlocalizedName(name);
    	this.setHasSubtypes(true);
    }
    
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < 57; i ++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player){
    	player.setItemInUse(item, 100);
		return item;
    	
    }
    
    @Override
    public void onPlayerStoppedUsing(ItemStack item, World world, EntityPlayer player, int i){
    	Random rando = new Random();
    	switch(item.getItemDamage()){
    	case 0:
    		int exp = rando.nextInt(56)+1;
    		player.addChatMessage(new ChatComponentText("You drew the " + field_card_values[(exp-1)%14] + " of " + field_card_types[(exp-1)/14]));
    		player.inventory.consumeInventoryItem(this);
    		player.inventory.addItemStackToInventory(new ItemStack(this,1,exp));
    		break;
    	case 1: case 2: case 3:case 4: case 5: case 6: case 7: case 8: case 9: case 10: case 11: case 12: case 13: case 14:
    		if(player.experienceLevel<50){
    			float expGain = ((float)player.xpBarCap()-player.experience)/(float)(15-item.getItemDamage());
    			if(expGain-(int)expGain>0.5) expGain = (float)Math.ceil(expGain);
    			else expGain = (float)Math.floor(expGain);
    			player.addExperience((int)expGain);
    			player.addChatMessage(new ChatComponentText("You used the " + field_card_values[item.getItemDamage()-1] + " of Swords."));
    		}
    		player.inventory.consumeInventoryItem(this);
    		player.inventory.addItemStackToInventory(new ItemStack(this,1,0));
    		break;
    	default:
    		player.inventory.consumeInventoryItem(this);
    		player.inventory.addItemStackToInventory(new ItemStack(this,1,0));
    		player.addChatMessage(new ChatComponentText("You used the " + field_card_values[(item.getItemDamage()-1)%14] + " of " + field_card_types[(item.getItemDamage()-1)/14]));
    		break;
    	}
    }
}
