/**
 * Extend this to make a your own container
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Container extends Structure
{
    Inventory inventory;
    /**
     * Constructor for objects of class Container
     */
    public Container(Inventory i, int hp, int maxHP)
    {
        super(hp,maxHP);
        inventory=i;
    }
    public Container(int size, int hp, int maxHP)
    {
        super(hp,maxHP);
        inventory=new Inventory(size);
    }
    public void open()
    {
        inventory.show();
    }
    public void close()
    {
        inventory.close();
    }
    public Inventory getInventory(){
        return inventory;
    }
    public void act(){
        for(int i=0; i<getGrid().getNeighbors(getLocation()).size(); i++)
        {
            if(!(getGrid().getNeighbors(getLocation()).get(i) instanceof Player))
            {
                close();
            }
        }
    }
}