package scripts;

import data.*;
/**
 * Write a description of class ClosePlayerInventory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClosePlayerInventory extends Scriptable
{
    /**
     * Constructor for objects of class ClosePlayerInventory
     */
    public ClosePlayerInventory(GameWorld gameWorld)
    {
        super(gameWorld);
        gameWorld.getPlayer().getInventory().close();
    }
}
