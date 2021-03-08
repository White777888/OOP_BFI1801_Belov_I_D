package com.company;

//Класс трехмерной точки
public class Point3d extends Point2d{
    //Защищенная переменная z
    protected double z;

    //Конструктор с параметрами
    public Point3d(double x, double y, double z){
        //Вызов конструктора базового класса
        super(x, y);
        this.z = z;
    }
    public Point3d(){
        //Вызов параметризированного конструктора
        this(0,0,0);
    }

    //Не дублируем код, а пишем функции доступа только для z
    //Доступ к z
    public double getZ(){
        return z;
    }
    public void setZ(double z){
        this.z = z;
    }

    //Функция сравнения двух объектов
    @Override
    public boolean equals(Object obj){

        //Мы могли передать тот же объект
        if (obj == this) {
            return true;
        }

        //Проверка на null и на равенство типов
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        //Приведем obj к Point3d
        Point3d point = (Point3d)obj;

        //Если все координаты ранвы, то вернется true,
        //а если нет, то false
        return (x == point.x && y == point.y && z == point.z);
    }

    //Функция определения расстояния между точками
    public double distanceTo(Point3d point){
        return Math.sqrt(
                Math.pow(x - point.x, 2) +
                Math.pow(y - point.y, 2) +
                Math.pow(z - point.z, 2));
    }
}
