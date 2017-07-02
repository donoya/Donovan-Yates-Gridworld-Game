/**
 * An example item that does nothing.
 * 
 * @author (Donovan Yates) 
 * @version (0.1)
 */
public class DummyItem extends ItemStack
{
    /**
     * Constructor for objects of class DummyItem
     */
    public DummyItem(Inventory i)
    {
        super("Dummy_Item", "Example Mod", 32, i);
    }
}
