package com.company;

//Класс комплексных чисел
public class Complex {
    //Мнимая и реальная части
    private double a, b;

    //Конструктор по умолчанию
    public Complex(){
        this.a = 0;
        this.b = 0;
    }

    //Конструктор
    public Complex(double a, double b){
        this.a = a;
        this.b = b;
    }

    public Complex(Complex z){
        a = z.a;
        b = z.b;
    }

    //Метод для получения модуля
    public double module(){
        return Math.sqrt(a * a + b * b);
    }

    //Метод для получения квадрата модуля
    public double SqrModule(){
        return a * a + b * b;
    }

    public Complex Mult(Complex z){
        return new Complex(this.a * z.a - this.b * z.b, this.a * z.b + this.b * z.a);
    }

    public Complex Add(Complex z){
        return new Complex(this.a + z.a, this.b + z.b);
    }

    //Методы для доступа
    public double getReal(){ return a; }
    public void setReal(double a){ this.a = a; }

    public double getImag() { return b; }
    public void setImag(double b) { this.b = b; }
}
