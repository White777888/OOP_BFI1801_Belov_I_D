package com.company;

//Класс двумерной точки
public class Point2d {
    //Координаты x и y
    protected double x, y;

    //Конструктор с параметрами
    public Point2d(double x, double y){
        this.x = x;
        this.y = y;
    }
    //Конструктор по умолчанию
    public Point2d(){
        this(0, 0);
    }

    //Доступ к x
    public double getX(){
        return x;
    }
    public void setX(double x){
        this.x = x;
    }

    //Доступ к y
    public double getY(){
        return y;
    }
    public void setY(double y){
        this.y = y;
    }
}
