import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/**
 * An unbounded grid that needs each tile to be unlocked to be usable
 * 
 * @author (Donovan Yates) 
 * @version (0.1)
 */
public class ExpandableGrid<Actor> extends AbstractGrid
{
    private ArrayList<GameLocation> unlockedLocations = new ArrayList<GameLocation>();
    private ActorWorld world;
    private Map<GameLocation, Actor> occupantMap;
    /**
     * Constructor for objects of class ExpandableGrid
     */
    public ExpandableGrid(GameLocation loc)
    {
        super();
        unlockedLocations.add(loc); //creates a starting tile at the specified location.
    }
    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> a = new ArrayList<Location>();
        for (Location loc : occupantMap.keySet())
            a.add(loc);
        return a;
    }
    public Actor get(Location loc)
    {
        if (loc == null)
            throw new NullPointerException("loc == null");
        return occupantMap.get(loc);
    }
    public Actor put(Location loc, Object obj)
    {
        if (loc == null)
            throw new NullPointerException("loc == null");
        if (obj == null)
            throw new NullPointerException("obj == null");
        return occupantMap.put((GameLocation)loc, (Actor)obj);
    }
    public Actor remove(Location loc)
    {
        if (loc == null)
            throw new NullPointerException("loc == null");
        return occupantMap.remove(loc);
    }
    public int getNumRows()
    {
        return -1;
    }
    public int getNumCols()
    {
        return -1;
    }
    public boolean Unlock(GameLocation loc)//unlocks the specified tile
    {
        if(unlockedLocations.contains(loc))
        {
            
            unlockedLocations.add(loc);
            return true; //succeeded in adding tile
        }
        return false; //failure to add tile
    }
    public boolean isValid(Location loc)
    {
        if(unlockedLocations.contains(loc)){
            return true;
        }
        return false;
    }
    public void setWorld(ActorWorld w){
        world=w;
    }
    public ActorWorld getWorld(){
        return world;
    }
}