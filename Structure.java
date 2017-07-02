import info.gridworld.actor.Actor;
/**
 * Write a description of class Structure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Structure extends Actor
{
    private int health;
    private final int maxHealth;
    /**
     * Constructor for objects of class Structure
     */
    public Structure(int hp, int maxHP)
    {
        health = hp;
        maxHealth=maxHP;
    }
    public void act()
    {
        return; //does nothing
    }
    public int getHealth()
    {
        return health;
    }
    public int heal(int healHP)
    {
        if(Math.abs(healHP)+health>maxHealth)
        {
            healHP = Math.abs(healHP)-(maxHealth-health);
            health = maxHealth;
            return healHP; //return the unnecessary healing in case it can still be used for something else
        }
        health = health + Math.abs(healHP);
        return 0;
    }
    public int damage(int damageHP)
    {
        if(Math.abs(damageHP)>=health){
            damageHP = Math.abs(damageHP)-health;
            removeSelfFromGrid();
            return damageHP; //return the unnecessary damage in case it can still be dealt to something else
        }
        health = health-Math.abs(damageHP);
        return 0;
    }
}