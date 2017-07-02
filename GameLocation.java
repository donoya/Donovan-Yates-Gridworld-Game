import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
/**
 * A location with stored data
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameLocation extends Location
{
    Map<String, Object> locationData;
    /**
     * Constructor for objects of class GameLocation
     */
    public GameLocation(int row, int column, ArrayList<Object> locationData)
    {
        super(row, column);
    }
    public Map<String, Object> getData()
    {
        return locationData;
    }
    public void setData(Map<String, Object> newData)
    {
        locationData = newData;
    }
    public void addData(String name, Object data)
    {
        locationData.put(name, data);
    }
    public void modifyData()
    {
        
    }
    public String toString()
    {
        Object[] locationDataArray = locationData.keySet().toArray();
        String dataString = "";
        if(!(locationDataArray.length==0))
        {
            dataString = " has: ";
            for(int i=0; i<locationDataArray.length; i++)
            {
                dataString.concat(locationDataArray.toString());
            }
        }
        return ("(" + getRow() + ", " + getCol() + ") " + dataString);
    }
}