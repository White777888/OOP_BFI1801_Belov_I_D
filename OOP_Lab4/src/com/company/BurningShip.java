package com.company;

import java.awt.geom.Rectangle2D;

public class BurningShip extends FractalGenerator{
    //Статическая константа максимального кол-ва итераций
    public static final int MAX_ITERATIONS = 2000;

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        //Установка координат и ширины с высотой
        //в соответсвии с диапазоном  (-2 - 1.5i) - (1 + 1.5i)
        range.x = -2;
        range.y = -2.5;

        range.width = range.height = 4;
    }

    @Override
    public int numIterations(double x, double y){
        //zn = zn-1^2 + c


        int count = 0;

        //Исходная точка
        Complex source = new Complex(x, y);

        //Текущая точка
        Complex z = new Complex(source);


        //Пока не превысили 2000
        while(count < MAX_ITERATIONS){
            count++;

            //Применяем модуль к реальной и мнимой части

            z.setReal(Math.abs(z.getReal()));
            z.setImag(Math.abs(z.getImag()));

            //Умножаем
            z = z.Mult(z);

            //Скалдываем
            z = z.Add(source);

            if((z.SqrModule() > 4)){
                break;
            }
        }

        return count == MAX_ITERATIONS? -1 : count;

    }

    //Метод для возвращения строкового представления фрактала (его имя)
    public String toString(){
        return "Burning Ship";
    }

}
