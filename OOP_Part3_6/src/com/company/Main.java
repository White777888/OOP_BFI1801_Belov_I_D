package com.company;

import java.util.ArrayList;
import java.util.Scanner;



public class Main {



    public static void main(String[] args) {



        Scanner scan = new Scanner(System.in);
        System.out.println("Задания части 3/6");
        String s;
        int size;

        //Цикл, выполняющийся, пока не введется e или exit
        do {
            //Вывод меню
            PrintMenu();
            s = scan.next();

            //Коснтрукция switch, которой управляет введенная переменная s
            switch(s){
                case "1":
                    System.out.println("Введите размер массива: ");

                    City[] arr = new City[scan.nextInt()];
                    System.out.println(arr.length);

                    for(int i = 0; i < arr.length; i++){
                        System.out.println("Введите имя города: ");

                        arr[i] = new City();

                        System.out.println("Введите имя города: ");
                        arr[i].setName(new Scanner(System.in).nextLine());

                        System.out.println("Введите население города: ");
                        arr[i].setPopulation(scan.nextLong());

                        //System.out.println(arr);
                    }

                    arr = millionsRounding(arr);
                    System.out.println("Округленный массив: ");

                    for(int i = 0; i < arr.length; i++){
                        System.out.println(arr[i].getName() + " " + arr[i].getPopulation());
                    }

                    break;
                case "2":
                    System.out.println("Введите сторону треугльника:");
                    double[] res = otherSides(scan.nextDouble());

                    System.out.println("Результат: " + res[0] + ", " + res[1]);
                    break;
                case "3":
                    System.out.println("Пускай игроки введут свои жесты (не подглядывать!):");
                    System.out.println("Хто победил: " +
                            rps(scan.next(), scan.next()));
                    break;

                case "4":
                    System.out.println("Введите размер массива: ");
                    //Вводим размер массива
                    size = scan.nextInt();

                    System.out.println("Введите массив размера " + size + ": ");
                    //Создаем список
                    int[] warArray = new int[size];
                    //Инициализируем
                    for (int i = 0; i < size; i++) {
                       warArray[i] = scan.nextInt();
                    }

                    System.out.println("Разница: " + warOfNumbers(warArray));
                    break;

                case "5":
                    System.out.println("Введите строку: ");
                    System.out.println("Результат: " + reverseCase(new Scanner(System.in).nextLine()));
                    break;

                case "6":
                    System.out.println("Введите имя: ");
                    System.out.println("Результат: " + inatorInator(scan.next()));
                    break;
                case "7":
                    System.out.println("Введите пять чисел: ");
                    System.out.println("Влезет ли: " +
                            doesBrickFit(scan.nextDouble(), scan.nextDouble(), scan.nextDouble(), scan.nextDouble(), scan.nextDouble()));
                    break;
                case "8":
                    System.out.println("Введите данные для поездки: ");
                    System.out.println("Сколько проедем: " + totalDistance(scan.nextDouble(), scan.nextDouble(),
                            scan.nextInt(), scan.nextBoolean()));
                    break;
                case "9":
                    System.out.println("Введите размер массива: ");
                    //Вводим размер массива
                    size = scan.nextInt();

                    System.out.println("Введите массив размера " + size + ": ");
                    //Создаем список
                    double[] array = new double[size];
                    //Инициализируем
                    for (int i = 0; i < size; i++) {
                        array[i] = scan.nextInt();
                    }

                    System.out.println("Среднее: " + mean(array));
                    break;
                case "10":
                    System.out.println("Введите число: ");
                    System.out.println("Результат: " +
                            parityAnalysis(scan.nextInt()));
                    break;
            }


        }while(!s.equals("exit") && !s.equals("e"));
    }


    //Метод для вывода меню
    public static void PrintMenu(){
        System.out.println("Выберите задание");
        System.out.println("1. Город миллионник");
        System.out.println("2. Стороны треугольника");
        System.out.println("3. Каменьб, ножмницы, бунмага");
        System.out.println("4. Конец войны");
        System.out.println("5. Грибы на дыбы");
        System.out.println("6. ТермиИнатор");
        System.out.println("7. Хирпичи");
        System.out.println("8. Хто куда, а я...");
        System.out.println("9. Среднее значение");
        System.out.println("10. Что-то там про четное");
        System.out.println("exit или e для выхода");
    }



    public static City[] millionsRounding(City[] input){
        long pi;

        for(int i = 0; i < input.length; i++){

            pi = input[i].getPopulation();

            input[i].setPopulation((long)(Math.round(pi / Math.pow(10, 6)) * Math.pow(10, 6)));
        }

        return input;
    }

    public static double[] otherSides(double littleSide){
        double[] res = {Math.round(littleSide * 2 * 100) / 100,
                (double)Math.round(littleSide * Math.sqrt(3) * 100) / 100};
        return res;
    }

    public static String rps(String p1, String p2){
        String p1w = "Player 1 wins";
        String p2w = "Player 2 wins";
        String tie = "TIE";

        if(p1.equals(p2)){
            return tie;
        }

        if(p1.equals("rock")){
            if(p2.equals("scissors")){
                return p1w;
            }
            if(p2.equals("paper")){
                return p2w;
            }
        }else if(p1.equals("scissors")){
            if(p2.equals("paper")){
                return p1w;
            }
            if(p2.equals("rock")){
                return p2w;
            }
        }else if(p1.equals("paper")){
            if(p2.equals("rock")){
                return p1w;
            }
            if(p2.equals("scissors")){
                return p2w;
            }
        }

        return "МЫ ИГРАЕМ В КАМЕНЬ НОЖНИЦЫ БУМАГУ ТАК И ПОКАЗЫВАЙ КАМЕНЬ НОЖНИЦЫ ИЛИ БУМАГУ ПАЛЬЧИК СВОЙ ЗАСУНЬ ТУДА ОТКУДА ТЫ ВЫЛЕЗ";
    }

    public static int warOfNumbers(int[] warArray){

        int sumEven = 0, sumNotEven = 0;

        for(int i = 0; i < warArray.length; i++){
            if(warArray[i] % 2 == 0){
                sumEven += warArray[i];
            }else{
                sumNotEven += warArray[i];
            }
        }

        return Math.abs(sumEven - sumNotEven);
    }

    public static String reverseCase(String s){
        String res = "";
        char ch;

        for(int i = 0; i < s.length(); i++){
            ch = s.charAt(i);

            if(Character.isUpperCase(ch)){
                res += Character.toLowerCase(ch);
            }else if(Character.isLowerCase(ch)){
                res += Character.toUpperCase(ch);
            }else{
                res += ch;
            }
        }
        return res;
    }

    public static String inatorInator(String s){

        String last = "" + s.charAt(s.length() - 1);
        String temp = "eyuioa";

        if(temp.contains(last)){
            return s + "-inator " + s.length() + "000";
        }else {
            return s + "inator " + s.length() + "000";
        }
    }

    public static boolean doesBrickFit(double a, double b, double c,
                                       double w, double h){

        if(a <= w && b <= h || b <= w && a <= h){
            return true;
        }

        if(a <= w && c <= h || c <= w && a <= h){
            return true;
        }

        if(b <= w && c <= h || c <= w && b <= h){
            return true;
        }

        return false;

    }

    public static double totalDistance(double fuel, double cons, int pass, boolean cond){
        cons = cons + (cons * 0.05 * pass);
        cons = cons + cons * 0.1 * (cond ? 1 : 0);
        return (fuel) / cons * 100 ;
    }

    public static double mean(double[] arr){
        double sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }

        return sum / arr.length;
    }

    public static boolean parityAnalysis(int num){

        int sum = 0, numcopy = num;
        while(numcopy != 0){
            sum += numcopy % 10;
            numcopy = numcopy / 10;
        }

        return sum % 2 == num % 2;
    }




}
