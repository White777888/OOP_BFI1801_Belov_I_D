package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Задания части 2/6");
        String s;

        //Цикл, выполняющийся, пока не введется e или exit
        do {
            //Вывод меню
            PrintMenu();
            s = scan.next();

            //Коснтрукция switch, которой управляет введенная переменная s
            switch(s){
                case "1":
                    System.out.println("Введите номер дома и длину улицы: ");
                    System.out.println("Противоположный дом: " + oppositeHouse(scan.nextInt(), scan.nextInt()));
                    break;
                case "2":
                    System.out.println("Введите имя и фамилию:");
                    System.out.println("Результат: " + nameShuffle(new Scanner(System.in).nextLine()));
                    break;
                case "3":
                    System.out.println("Введите стоимость и размер скидки:");
                    System.out.println("Финальная стоимость: " +
                            discount(scan.nextDouble(), scan.nextDouble()));
                    break;

                case "4":
                    System.out.println("Введите размер массива: ");
                    //Вводим размер массива
                    int size = scan.nextInt();

                    System.out.println("Введите массив размера " + size + ": ");
                    //Создаем список
                    ArrayList array = new ArrayList<>(size);
                    //Инициализируем
                    for (int i = 0; i < size; i++) {
                        array.add(i, scan.nextInt());
                    }

                    System.out.println("Разность Max - Min: " + differenceMaxMin(array));
                    break;

                case "5":
                    System.out.println("Введите три значения: ");
                    System.out.println("Кол-во одинаковых значений: " + equal(scan.nextInt(), scan.nextInt(), scan.nextInt()));
                    break;

                case "6":
                    System.out.println("Введите строку:");
                    System.out.println("Результат: " + reverse(new Scanner(System.in).nextLine()));
                    break;
                case "7":
                    System.out.println("Введите три числа: ");
                    System.out.println("Разница: " +
                            programmers(scan.nextInt(), scan.nextInt(), scan.nextInt()));
                    break;
                case "8":
                    System.out.println("Введите строку: ");
                    System.out.println("Результат: " + (getXO(new Scanner(System.in).nextLine())? "равное количество (true)": "неравное количество (false)"));
                    break;
                case "9":
                    System.out.println("Введите строку: ");
                    System.out.println("Результат: " + bomb(new Scanner(System.in).nextLine()));
                    break;
                case "10":
                    System.out.println("Введите две строки: ");
                    System.out.println("Результат: " +
                            (sameAscii(new Scanner(System.in).nextLine(), new Scanner(System.in).nextLine()) ? "равны (true)" : "неравны (false)"));
                    break;
            }


        }while(!s.equals("exit") && !s.equals("e"));

    }

    //Метод для вывода меню
    public static void PrintMenu(){
        System.out.println("Выберите задание");
        System.out.println("1. Противоположный дом");
        System.out.println("2. Обмен фамилии и имени");
        System.out.println("3. Скидка");
        System.out.println("4. Разница Max - Min");
        System.out.println("5. Сколько равных чисел");
        System.out.println("6. Развернуть строку");
        System.out.println("7. Разница в доходах");
        System.out.println("8. X и O");
        System.out.println("9. ISIL (A TERRORIST ORGANIZATION BANNED IN RUSSIA)");
        System.out.println("10. Сравнение ASCII");
        System.out.println("exit или e для выхода");
    }

    public static int oppositeHouse(int n, int l){ return 2*l - n + 1;}

    public static String nameShuffle(String s){ return s.substring(s.indexOf(" ")) + " " + s.substring(0, s.indexOf(" ")); }

    public static double discount(double price, double disc){ return price * (100 - disc)/100; }

    public static int differenceMaxMin(ArrayList inArray){ return (int)Collections.max(inArray) - (int)Collections.min(inArray); }

    public static int equal(int a, int b, int c){
        /*int count = 0;

        if(a == b){
            count+=2;
        }
        if(a == c){
            if(a == b){count++;}
            else count+=2;

        }
        if(b == c){
            if(a != b && a != c){count+=2;}
            else if(a == b && a == c){}
            else count++;
        }
        return count;*/

        if(a == b && b == c){ return 3; }
        else if(a != b && b == c){ return 2; }
        else if(a == b && b != c){ return 2; }
        else if(a == c) { return 2; }
        else return 0;

    }

    public static String reverse(String s){
        String res = "";
        for(int i = s.length() - 1; i >= 0; i--){
            res += s.charAt(i);
        }

        return res;
    }

    public static int programmers(int p1, int p2, int p3){

        //Ищем максимум
        int max = max(p1, max(p2, p3));

        //Ищем минимум
        int min = min(p1, min(p2, p3));

        return max - min;
    }

    public static int max(int a, int b){
        return a > b ? a : b;
    }

    public static int min(int a, int b){
        return a < b ? a : b;
    }

    public static boolean getXO(String s){
        int cO = 0, cX = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'x' || s.charAt(i) == 'X'){
                cX++;
            }else if(s.charAt(i) == 'o' || s.charAt(i) == 'O'){
                cO++;
            }
        }

        return cO == cX;
    }

    public static String bomb(String dangerous){
        return dangerous.toLowerCase().contains("bomb") ? "DUCK!" : "Relax, there's no bomb.";
    }

    public static boolean sameAscii(String s1, String s2){
        int sum1 = 0, sum2 = 0;

        for(int i = 0; i < s1.length(); i++){
            sum1 += (int)s1.charAt(i);
        }

        for(int i = 0; i < s2.length(); i++){
            sum2 += (int)s2.charAt(i);
        }

        return sum1 == sum2;
    }
}
