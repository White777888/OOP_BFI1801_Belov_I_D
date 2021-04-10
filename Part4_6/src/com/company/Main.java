package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Задания части 4/6");
        String s;
        int size;

        //Цикл, выполняющийся, пока не введется e или exit
        do {
            //Вывод меню
            PrintMenu();
            s = scan.next();

            int[] arr;

            //Коснтрукция switch, которой управляет введенная переменная s
            switch(s){
                case "1":
                    System.out.println("Введите размер массива: ");

                    arr = new int[scan.nextInt()];

                    System.out.println("Введите массив: ");
                    for(int i = 0; i < arr.length; i++){


                        arr[i] = scan.nextInt();

                    }

                    System.out.println(sevenBoom(arr));

                    break;
                case "2":
                    System.out.println("Введите размер массива: ");

                    arr = new int[scan.nextInt()];


                    System.out.println("Введите массив: ");
                    for(int i = 0; i < arr.length; i++){


                        arr[i] = scan.nextInt();

                    }

                    System.out.println(cons(arr));

                    break;
                case "3":
                    System.out.println("Введите свой микс: ");
                    System.out.println("Размикс: " +
                            unmix(new Scanner(System.in).nextLine()));
                    break;

                case "4":
                    System.out.println("Введите строку: ");
                    System.out.println("Результат: " + noYelling(new Scanner(System.in).nextLine()));
                    break;

                case "5":
                    System.out.println("Введите строку: ");
                    System.out.println("Результат: " + xPronounce(new Scanner(System.in).nextLine()));
                    break;

                case "6":
                    System.out.println("Введите размер массива: ");
                    //Вводим размер массива
                    size = scan.nextInt();

                    System.out.println("Введите массив размера " + size + ": ");
                    //Создаем список
                    ArrayList array = new ArrayList<>(size);
                    //Инициализируем
                    for (int i = 0; i < size; i++) {
                        array.add(i, new Integer(scan.nextInt()));
                    }

                    System.out.println("Наибольший разрыв: " + largestGap(array));
                    break;
                case "7":
                    System.out.print("Введите значение: ");
                    System.out.println("Результат: " + FUNCTION(scan.nextInt()));
                    break;
                case "8":
                    System.out.println("Введите строку: ");
                    System.out.println("Результат: " + commonLastVowel(new Scanner(System.in).nextLine()));
                    break;
                case "9":

                    System.out.print("Введите два числа для сложения: ");
                    System.out.println("Результат: " + memeSum(scan.nextInt(), scan.nextInt()));

                    break;
                case "10":
                    System.out.println("Введите строку: ");
                    System.out.println("Результат: " + unrepeated(new Scanner(System.in).nextLine()));
                    break;
            }


        }while(!s.equals("exit") && !s.equals("e"));
    }


    //Метод для вывода меню
    public static void PrintMenu(){
        System.out.println("Выберите задание");
        System.out.println("1. SEVENBOOM");
        System.out.println("2. Can be created что-то там");
        System.out.println("3. Строки-прыгскоки");
        System.out.println("4. Платные знаки");
        System.out.println("5. В поисках X");
        System.out.println("6. У вас чича");
        System.out.println("7. FUNCTION");
        System.out.println("8. Я не знаю зачем вам считать кол-во гласных в конце слов в предложении никто и никогда такого не хотел зачем вам это");
        System.out.println("9. Сложение дурачоуса");
        System.out.println("10. Ничего лишнего");
        System.out.println("exit или e для выхода");
    }


    //Проверка числа на наличие цифры 7
    public static String checkNum(int num){
        int digit;

        while(num > 0){
            digit = num % 10;
            num = num / 10;

            if(digit == 7){
                return "Boom!";
            }
        }

        return null;
    }

    //Проверка массива на наличие цифры 7
    public static String sevenBoom(int[] arr){

        for(int i = 0; i < arr.length; i++){
            if(checkNum(arr[i]) != null){
                return "Boom!";
            }
        }

        return "7 is absent";

    }

    //Проверка на арифметическую последовательность
    public static boolean cons(int[] arr){
        int sum = 0;
        int min, max;
        min = max = arr[0];

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        if(sum == ((min + max) * arr.length / 2)){
            return true;
        }else{
            return false;
        }
    }

    //Размиксовка
    public static String unmix(String mix){
        String unmixed = "";
        int i;

        //Меняем месатми пары символов
        for(i = 1; i < mix.length(); i+=2){
            unmixed = unmixed +  (char)mix.charAt(i) + (char)mix.charAt(i - 1);
        }

        return unmixed.length() != mix.length() ? unmixed + mix.charAt(i - 1) : unmixed;
    }

    //Удаление лишних знаков
    public static String noYelling(final String s){

        String nohomo = s;
        int l = nohomo.length() - 1;
        char last = nohomo.charAt(l);

        //Удаляем знаки, пока они есть
        while(nohomo.charAt(l) == '?' || nohomo.charAt(l) == '!'){
            nohomo = nohomo.substring(0, l);
            l = nohomo.length() - 1;
        }

        //Возвращаем строку с восстановленным одним знаком, либо возврващаем нетроную строку
        return nohomo.length() != s.length() ? nohomo + last : nohomo;
    }

    //Замена x
    public static String xPronounce(final String s){
        String nox = s;

        int index;

        while((index = nox.indexOf('x')) != -1){
            if(index != 0 && nox.charAt(index - 1) != ' '
                    && (index != nox.length() - 1) && nox.charAt(index + 1) != ' '){
                nox = nox.replaceFirst("x", "cks");
            }
            else if(index != 0 && nox.charAt(index - 1) == ' '
                    && (index != nox.length() - 1) && nox.charAt(index + 1) == ' '){
                nox = nox.replaceFirst("x", "ecks");
            }
            else if(index != 0 && nox.charAt(index - 1) != ' '){
                nox = nox.replaceFirst("x", "cks");
            }
            else if((index != nox.length() - 1) && nox.charAt(index + 1) != ' '){
                nox = nox.replaceFirst("x", "z");
            }

        }

        return nox;
    }

    //Поиск максимального разрыва
    public static Integer largestGap(ArrayList arr){
        //Сортировка
        Collections.sort(arr);

        Integer max = 0;
        //Поиск максимальной разницы
        for(int i = 0; i < arr.size() - 1; i++){
            if((Integer)arr.get(i + 1) - (Integer) arr.get(i) > max){

                max = (Integer)arr.get(i + 1) - (Integer)arr.get(i);
            }
        }

        return max;
    }

    //Метод для сортировки цифр числа
    public static int sortNum(int num){

        char[] chars = ("" + num).toCharArray();
        Arrays.sort(chars);

        return Integer.parseInt(new String(chars));
    }
    //Один странный метод
    public static int FUNCTION(int x){

        int y = sortNum(x);
        return x - y;

    }

    //Подсчет гласных на концах
    public static String commonLastVowel(String s){

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('a', 0);
        map.put('e', 0);
        map.put('o', 0);
        map.put('u', 0);
        map.put('i', 0);
        map.put('y', 0);

        String temp = "aeouiy", ch = "";

        s = s.toLowerCase(Locale.ROOT);

        int index;
        int count;
        /*Character ch;*/

        //Работаем, пока есть слова
        while((index = s.indexOf(' ')) != -1){

            ch = "" + s.charAt(index - 1);

            //Если это гласная, то считаем
            if(temp.contains(ch)){
                //Берем старое значение
                count = map.get(ch.charAt(0)).intValue();

                //Обновляем
                map.put(ch.charAt(0), count+1);

            }
            
            s = s.substring(0, index) + s.substring(index + 1);

        }

        ch = "" + s.charAt(s.length() - 1);
        //Если это гласная, то считаем
        if(temp.contains(ch)){
            //Берем старое значение
            count = map.get(ch.charAt(0)).intValue();

            //Обновляем
            map.put(ch.charAt(0), count+1);

        }

        int max = 0;


        //Поиск максимального значения
        for (HashMap.Entry e: map.entrySet()) {
            if(((Integer)e.getValue()).intValue() > max){
                max = (Integer)((Integer) e.getValue()).intValue();
                ch = "" + ((Character)e.getKey()).charValue();
            }
        }
        return ch;
    }

    //Мемная сумма
    public static int memeSum(int a, int b){
        String sa = "" + a;
        String sb = "" + b;
        String res = "";

        while(a > 0 && b > 0){
            res = "" + (a % 10 + b % 10) + res;
            a = a / 10;
            b = b / 10;


        }

        if(a > 0){
            res = "" + a + res;
        }
        else if(b > 0){
            res = "" + b + res;
        }

        return Integer.parseInt(res);

    }

    //Метод удаляющий из слова повторяющиеся символы
    public static String compressString(String s){
        String res = "";

        //Добавляем только то, что еще не добавили
        for(int i = 0; i < s.length(); i++){
            if(!res.contains("" + s.charAt(i))){
                res += "" + s.charAt(i);
            }
        }

        return res;
    }

    //Удаление повторяющихся букв в словах
    public static String unrepeated(final String s){
        String res = "", buff = "", temp = s;

        int index;

        while((index = temp.indexOf(' ')) != -1){

            //Выделил слово
            buff = temp.substring(0, index);

            //Скомпрессировали и добавили
            res += compressString(buff) + " ";

            temp = temp.substring(index + 1);


        }

        //Скомпрессировали и добавили
        res += compressString(temp);

        return res;
    }


}
