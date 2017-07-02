import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.world.World;
import info.gridworld.grid.Location;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.gui.WorldFrame;
/**
 * an inventory for a structure
 * 
 * @author (Donovan Yates) 
 * @version (0.1)
 */
public class Inventory extends InventoryWorld<ItemStack>
{
    private BoundedGrid<ItemStack> items; //this is the contents of the inventory
    /**
     * Constructor for objects of class Inventory
     */
    public Inventory(int s)
    {
        super(new BoundedGrid(1,s)); //this is to affect the grid
        items = new BoundedGrid(1,s); //this is to keep track of the grid
    }
    public Inventory(BoundedGrid g)
    {
        super(g);
        items=g;
    }
    public ItemStack[] checkItems_Use_this()
    {
        ItemStack[] itemList = new ItemStack[items.getNumCols()];
        for(int i=0; i<itemList.length; i++)
        {
            itemList[i]=items.get(new Location(0,i));
        }
        return itemList;
    }
    public ItemStack checkSlot_Use_this(int i)
    {
        return items.get(new Location(0,i));
    }
    public ItemStack checkSlot_Use_this(Location loc)
    {
        return items.get(loc);
    }
    public ItemStack addItem(ItemStack item, String password)
    {
        if(!password.equals("\\using this via the interface is cheating."))
        {
            return item;
        }
        for(int i=0; i<items.getNumCols(); i++){
            if(items.get(new Location(0,i))==null) //is the slot empty
            {
                items.put(new Location(0,i),item); //puts the stack in the empty slot
                return null; //successfully put item into an open inventory slot
            }
        }
        return item; //no empty slots to put item
    }
    public int transferItems(ItemStack sending, ItemStack recieving, int quantity) //transfers items from one stack to another
    {
        if(sending.getItemType().equals(recieving.getItemType())&&sending.getMod().equals(recieving.getMod())){ //are the item stacks of the same type
            quantity = recieving.addToStack(sending,quantity-sending.removeFromStack(quantity,"\\No refunds"),"\\Using this via the interface is cheating");
            sending.addToStack(sending,quantity,"\\Using this via the interface is cheating");
            return quantity; //return the number of items successfully transfered
        }
        return 0; //the sending stack cannot be transfered to the recieving stack
    }
    public void add(Location loc, ItemStack occupant)
    {
        return; // do nothing
    }
    public void add(ItemStack occupant)
    {
        return; //do nothing
    }
    public ItemStack remove(Location loc)
    {
        return null; //do nothing
    }
    public ItemStack removeItems(Location loc, int quantity, String password)
    {
        if(!password.equals("\\doing this via the interface will destroy the items. There are no refunds."))
        {
               return null; //do nothing
        }
        if(items.get(loc).getCurrentSize()<quantity) //are there not enough items in the stack
        {
            quantity=items.get(loc).getCurrentSize(); //reduce quantity to acceptable size
        }
        ItemStack removedItems = items.get(loc);
        for(int i=0; i<quantity; i++){
            removedItems.removeFromStack(Math.abs(quantity)-items.get(loc).getCurrentSize(),"//No refunds");
            items.get(loc).removeFromStack(quantity,"//No refunds");
        }
        return removedItems;
    }
    public int getMaxSize_Use_this()
    {
        return items.getNumCols();
    }
}
