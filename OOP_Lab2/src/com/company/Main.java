package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Введите по 3 координаты для 3-х точек");

        //Ввод координат
        System.out.print("Точка 1: ");
        Point3d p1 = new Point3d(
                input.nextDouble(), input.nextDouble(), input.nextDouble());

        System.out.print("\nТочка 2: ");
        Point3d p2 = new Point3d(
                input.nextDouble(), input.nextDouble(), input.nextDouble());

        System.out.print("\nТочка 3: ");
        Point3d p3 = new Point3d(
                input.nextDouble(), input.nextDouble(), input.nextDouble());

        //Проверка на одинаковые точки
        if(p1.equals(p2) || p1.equals(p3)){
            System.out.println("Введены одинаковые точки!");
            return;
        }else if(p2.equals(p3)){
            System.out.println("Введены одинаковые точки!");
            return;
        }

        //Если мы здесь, значит точки разные
        double S = computeArea(p1, p2, p3);

        System.out.println("Площадь треугольника равна: " + S);


    }

    public static double computeArea(Point3d p1, Point3d p2, Point3d p3){
        //Использование формулы Герона для нахождения площади
        //Три стороны
        double a = p1.distanceTo(p2);
        double b = p2.distanceTo(p3);
        double c = p3.distanceTo(p1);

        //Проверка на существование треугольника
        if(!(a < b + c && b < a + c && c < a + b)){
            System.out.println("Треугольник не существует!");
            return 0.0;
        }
        //Полупериметр
        double p = (a + b + c) / 2;

        //Формула Герона
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
