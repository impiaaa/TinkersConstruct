package tconstruct.items.armor;

import tconstruct.TConstruct;
import tconstruct.util.player.*;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import java.util.List;

import tconstruct.items.CraftingItem;
import net.minecraft.util.StatCollector;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Knapsack extends CraftingItem
{

    public Knapsack(int id)
    {
        super(id, new String[] { "knapsack" }, new String[] { "knapsack" }, "armor/");
        this.setMaxStackSize(10);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        switch (stack.getItemDamage())
        {
        case 0:
            list.add(StatCollector.translateToLocal("knapsack.tooltip"));
            break;
        }
    }
    
    @Override
    public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack)
    {
		TPlayerStats stats = TConstruct.playerTracker.getPlayerStats(player.username);
		KnapsackInventory inv = stats.knapsack;
		
		if (stats != null && inv != null) {
			for(int i = 0; i < inv.getSizeInventory(); i++){
				if(inv.getStackInSlot(i) != null){
					inv.getStackInSlot(i).getItem().onUpdate(inv.getStackInSlot(i), player.worldObj, player, i, false);
				}
			}
		}
    }

}
