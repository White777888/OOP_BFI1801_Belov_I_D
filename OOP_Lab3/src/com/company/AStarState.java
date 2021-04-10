/**
 * This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map.  This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints."  In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 **/

package com.company;

import java.util.HashMap;
import java.util.Map;


public class AStarState
{
    /** This is a reference to the map that the A* algorithm is navigating. **/
    private Map2D map;

    //Объявление наборов открытых и закрытых вершин
    HashMap<Location, Waypoint> openCollection;
    HashMap<Location, Waypoint> closeCollection;


    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;

        //Инициализируем HashMap
        this.openCollection = new HashMap<>();
        this.closeCollection = new HashMap<>();

    }

    /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap()
    {
        return map;
    }






    /**
     * This method scans through all open waypoints, and returns the waypoint
     * with the minimum total cost.  If there are no open waypoints, this method
     * returns <code>null</code>.
     **/
    //Возвращает точку в открытом наборе с наимееньшей общей стоимостью
    public Waypoint getMinOpenWaypoint()
    {
        Waypoint Wmin = null;
        float min = Float.MAX_VALUE;

        for(HashMap.Entry entry : openCollection.entrySet()){

            //Если находим новый минимум, то запоминаем его и точку
            if(((Waypoint)entry.getValue()).getPreviousCost() + ((Waypoint)entry.getValue()).getRemainingCost() < min){
                min = ((Waypoint)entry.getValue()).getPreviousCost() + ((Waypoint)entry.getValue()).getRemainingCost();
                Wmin = (Waypoint)entry.getValue();
            }

        }

        return Wmin;
    }

    /**
     * This method adds a waypoint to (or potentially updates a waypoint already
     * in) the "open waypoints" collection.  If there is not already an open
     * waypoint at the new waypoint's location then the new waypoint is simply
     * added to the collection.  However, if there is already a waypoint at the
     * new waypoint's location, the new waypoint replaces the old one <em>only
     * if</em> the new waypoint's "previous cost" value is less than the current
     * waypoint's "previous cost" value.
     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {

        Waypoint findWP = openCollection.get(newWP.getLocation());

        //Если не нашли точку, то просто добавляем
        if(findWP == null){
            openCollection.put(newWP.getLocation(), newWP);
            return true;
        //Если нашли
        }else{
            //то сравниваем стоимость пути до старой и новой точки
            if((findWP.getPreviousCost()) > newWP.getPreviousCost()){
                openCollection.put(newWP.getLocation(), newWP);
                return true;
            }

            return false;
        }
    }


    //Возвращаеет вол-во точек в открытом наборе
    public int numOpenWaypoints()
    {
        //Возвращаем вол-во точек в открытом наборе
        return openCollection.size();
    }


    /**
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     **/
    public void closeWaypoint(Location loc)
    {
        //Перемещаем заданную точку в закрытый набор
        closeCollection.put(loc, openCollection.get(loc));

        //Удалаяем заданную точку
        openCollection.remove(loc);
    }

    /**
     * Returns true if the collection of closed waypoints contains a waypoint
     * for the specified location.
     **/
    public boolean isLocationClosed(Location loc)
    {
        return closeCollection.get(loc) != null;
    }
}
