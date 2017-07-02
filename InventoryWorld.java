import info.gridworld.grid.Grid;
import info.gridworld.world.World;
import info.gridworld.gui.WorldFrame;
/**
 * Base class for Inventory
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class InventoryWorld<T> extends World<T>
{
    WorldFrame<T> frame;
    /**
     * Constructor for objects of class InventoryWorld
     */
    public InventoryWorld()
    {
        super();
    }
    public InventoryWorld(Grid g)
    {
        super(g);
    }
    public void show()
    {
        if (frame == null)
        {
            frame = new WorldFrame<T>(this);
        }
        frame.setVisible(true);
    }
    public WorldFrame getFrame()
    {
        return frame;
    }
    public void close()
    {
        frame.setVisible(false);
    }
}