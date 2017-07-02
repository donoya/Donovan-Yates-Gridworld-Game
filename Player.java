import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * @author (Donovan Yates) 
 * @version (0.1)
 */
public class Player extends Actor
{
    //needs for the player such as food and water are planned to go here later
    Grid grid;
    
    PlayerInventory inventory;
    Location location;
    Color color;
    int direction;
    /**
     * Constructor for objects of class Player
     */
    public Player(PlayerInventory i)
    {
        inventory=i;
    }
    @Override
    public void act(){
    }
    public Inventory getInventory(){
        return inventory;
    }
}