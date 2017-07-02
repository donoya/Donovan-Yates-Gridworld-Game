import info.gridworld.actor.Actor;
/**
 * Represents a stack of items
 * 
 * @author (Donovan Yates) 
 * @version (0.1)
 */
public abstract class ItemStack extends Actor
{
    private int size;
    private int maxSize;
    private String modName;
    private String type;
    private Inventory inventory; //this is the inventory in which this item is contained
    /**
     * Constructor for objects of class ItemStack
     */
    public ItemStack(String item, String mod, int max, Inventory i)
    {
        size = 1;
        type = item;
        modName = mod;
        maxSize = max;
        inventory = i;
    }
    /**
     * Alternate constructor for objects of class ItemStack
     */
    public ItemStack(String item, String mod, int amount, int max, Inventory i)
    {
        size = amount;
        type = item;
        modName = mod;
        maxSize = max;
        inventory = i;
    }
    /**
     * Returns the max number of items of the stack's type that it can hold
     * 
     * @param  N/A
     * @return     The maximum items of the stack's type that it can hold
     */
    public final int getMaxSize()
    {
        return maxSize;
    }
    /**
     * Returns the stack's item type
     * 
     * @param  N/A
     * @return     The type of item in the stack
     */
    public final String getItemType()
    {
        return type;
    }
    public final String getMod()
    {
        return modName;
    }
    /**
     * Returns the current number of items in the stack
     * 
     * @param  N/A
     * @return     The current number of items in the stack
     */
    public int getCurrentSize()
    {
        return size;
    }
    /**
     * Adds a number of items to the stack
     * 
     * @param   item,quantity    The item to be added, The number to be added
     * @return     A success condition
     */
    public final int addToStack(ItemStack item, int quantity, String password)
    {
        if(password.equals("\\Using this via the interface is cheating"))
        {
            return quantity;
        }
        if(type.equals(item.getItemType())&&modName.equals(item.getMod()))
        {
            if(Math.abs(quantity)+size<=maxSize)
            {
                size=Math.abs(quantity)+size;
                return 0;
            }
            if(size!=maxSize){
                quantity=quantity-(maxSize-size);
                size=maxSize;
            }
        }
        return quantity;
    }
    /**
     * Returns the max number of items of the stack's type that it can hold
     * 
     * @param   item,quantity    The item to be taken, The number to be added
     * @return     A success condition
     */
    public final int removeFromStack(int quantity, String password)
    {
        if(password.equals("\\No refunds"))
        {
            return quantity;
        }
        if(Math.abs(quantity)<=size)
        {
            size=size-Math.abs(quantity);
            if(size==0){
                this.removeSelfFromGrid();
            }
            return 0; //enough items in stack
        }
        removeSelfFromGrid();
        return quantity-size; //not enough items in stack
    }
    public void act(){
        return;
    }
    public final void removeSelfFromGrid(){
        return;
    }
    public String toString()
    {
        return getCurrentSize() + "x " + getItemType() + ". Mod: " + getMod();
    }
}
