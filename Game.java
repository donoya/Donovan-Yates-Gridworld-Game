import java.util.Random;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;
import java.io.IOException;
/**
 * The core system.
 * 
 * @author Donovan Yates
 * @version 0.1
 */
public class Game
{
    public static void main(String[] args) throws IOException, NoSuchMethodException
    {
        PlayerInventory playerInventory = new PlayerInventory();
        Player player = new Player(playerInventory);
        GameWorld world = new GameWorld(new ExpandableGrid(new GameLocation(0,0,new ArrayList<Object>())),player);
        ((ExpandableGrid)world.getGrid()).setWorld(world);
        player.setColor(new Color(0,255,255));
        world.add(new Location(0,0), player);
        world.show();
    }
}
