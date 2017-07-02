import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Grid;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JFrame;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Enumeration;
import java.lang.reflect.*;
/**
 * An ActorWorld with more control
 * 
 * @author (Donovan Yates) 
 * @version (0.1)
 */
public class GameWorld<Actor> extends ActorWorld
{
    private Grid<Actor> grid;
    private Player player;
    private KeyBindManager keyBindManager;
    /**
     * Constructor for objects of class GameWorld
     */
    public GameWorld(Player p) throws IOException, NoSuchMethodException
    {
        super();
        keyBindManager=new KeyBindManager();
        player=p;
    }
    public GameWorld(Grid g, Player p) throws IOException, NoSuchMethodException
    {
        super(g);
        keyBindManager=new KeyBindManager();
        grid=g;
        player=p;
    }
    public void show()
    {
        super.show();
    }
    public boolean keyPressed(String description, Location loc)
    {
        try
        {
            keyPressedException(description, loc);
        }
        catch(InstantiationException e)
        {
        }
        catch(IllegalAccessException e)
        {
        }
        catch(InvocationTargetException e)
        {
        }
        return false;
    }
    public void keyPressedException(String description, Location loc) throws InstantiationException, IllegalAccessException, InvocationTargetException
    {
        for(int i=0; i<keyBindManager.getControls().size(); i++){
            Enumeration keys = keyBindManager.getControls().elements();
            for(int x=0; keys.hasMoreElements(); x++)
            {
                Object key = keys.nextElement();
                if(description.contains(((Constructor)keyBindManager.getControls().get(key)).getName())){
                    ((Constructor) keyBindManager.getControls().get(key)).newInstance(this);
                }
            }
        }
    }
    public Player getPlayer()
    {
        return player;
    }
}