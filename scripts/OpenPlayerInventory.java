package scripts;

import data.*;
/**
 * A script to open the player's inventory.
 * 
 * @author (Donovan Yates) 
 * @version (0.1)
 */
public class OpenPlayerInventory extends Scriptable
{
    /**
     * Constructor for objects of class OpenPlayerInventory
     */
    public OpenPlayerInventory(GameWorld gameWorld)
    {
        super(gameWorld);
        gameWorld.getPlayer().getInventory().show();
    }
}
