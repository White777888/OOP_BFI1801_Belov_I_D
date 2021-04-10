/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/

package com.company;


public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }

    @Override
    public boolean equals(Object obj) {

        //Проверка на null
        if(obj == null){ return false; }

        //Проверка класса
        if(this.getClass() != obj.getClass()){ return false; }

        //Проверка на сравнение с самим собой
        if(this == obj){ return true; }

        Location ltemp = (Location) obj;

        return ltemp.xCoord == this.xCoord && ltemp.yCoord == this.yCoord;
    }

    @Override
    public int hashCode() {
        //Если хэш-коды равны, то ВОЗМОЖНО равны и объекты
        //Если хэш-коды не равны, то объекты точно не равны

        //Для реаизации разных хэш-кодов можно использовать
        //какую-нибудь функцию, которая обеспечивает уникальные
        //и разные значения для разных точек
        //и уникальные равные значения для одинаковых точек

        //Можно взять обычную плоскость

        return xCoord + 31 * yCoord;
    }
}