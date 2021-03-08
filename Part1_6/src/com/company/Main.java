package com.company;

import java.util.Scanner;

//Задачи из части 1/6
public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Задания части 1/6");
        String s;

        //Цикл, выполняющийся, пока не введется e или exit
        do {
            //Вывод меню
            PrintMenu();
            s = scan.next();

            //Коснтрукция switch, которой управляет введенная переменная s
            switch(s){
                case "1":
                    System.out.println("Введите число минут:");
                    int m = Integer.parseInt(scan.next());
                    System.out.println(m + " минут = " + convert(m) + " секунд");
                    break;
                case "2":
                    System.out.println("Введите кол-во очков:");
                    System.out.println("Финальная сумма очков: " +
                            points(Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
                    break;
                case "3":
                    System.out.println("Введите кол-во побед, ничьих и поражений:");
                    System.out.println("Финальная сумма очков: " +
                            footballPoints(Integer.parseInt(scan.next()),
                                    Integer.parseInt(scan.next()),
                                    Integer.parseInt(scan.next())));
                    break;

                case "4":
                    System.out.println("Введите число: ");
                    int num = Integer.parseInt(scan.next());
                    System.out.println("Делимость числа " + num + ": " + (divisibleByFive(num)? "делится" : "не делится"));
                    break;
                case "5":
                    System.out.println("Введите два булевых значения: ");
                    System.out.println("Результат: " + and(scan.nextBoolean(), scan.nextBoolean()));
                    break;

                case "6":
                    System.out.println("Введите три значения: ");
                    System.out.println("Можно покрасить стен: " + howManyWalls(scan.nextInt(), scan.nextInt(), scan.nextInt()));
                    break;
                case "7":
                    System.out.println("Введите число: ");
                    System.out.println("Квадрат числа: " + squared(scan.nextInt()));
                    break;
                case "8":
                    System.out.println("Введите кол-во товара, стоимость и цену закупки: ");
                    System.out.println("Вышли ли в плюс: " +
                            ((profitableGamble(scan.nextDouble(), scan.nextDouble(), scan.nextDouble()))? "да" : "нет"));
                    break;
                case "9":
                    System.out.println("Введите кол-во fps и кол-во минут: ");
                    System.out.println("FPM: " + frames(scan.nextInt(), scan.nextInt()));
                    break;
                case "10":
                    System.out.println("Введите делимое и частное: ");
                    System.out.println("Остаток: " + mod(scan.nextInt(), scan.nextInt()));
                    break;
            }


        }while(!s.equals("exit") && !s.equals("e"));

    }

    //Функция для вывода меню
    public static void PrintMenu(){
        System.out.println("Выберите задание");
        System.out.println("1. Минуты в секунды");
        System.out.println("2. Баскетбольные очки");
        System.out.println("3. Футбольные очки");
        System.out.println("4. Проверка делимости на 5");
        System.out.println("5. Оператор and");
        System.out.println("6. Покраска стен");
        System.out.println("7. Квадрат числа");
        System.out.println("8. Чистая прибыль");
        System.out.println("9. FPM");
        System.out.println("10. Остаток без оператора остатка");
        System.out.println("exit или e для выхода");
    }

    public static int convert(int minute){
        return minute * 60;
    }

    public static int points(int dbl, int trpl){
        return dbl * 2 + trpl * 3;
    }

    public static int footballPoints(int victory, int draw, int lose){
        return victory * 3 + draw * 1 + lose * 0;
    }

    public static boolean divisibleByFive(int num){
        return num % 5 == 0;
    }

    public static boolean and(boolean a, boolean b){
        return a && b;
    }

    public static int howManyWalls(int n, int w, int h){
        return n / (w * h);
    }

    public static int squared(int a) {
        return a * a;
    }

    public static boolean profitableGamble(double prob, double prize, double pay){
        return prob * prize > pay;
    }

    public static int frames(int fps, int m){
        return fps * m * 60;
    }

    public static int mod(int a, int b){
        return a - (a/b * b);
    }
}
