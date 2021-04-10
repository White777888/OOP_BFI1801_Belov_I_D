package com.company;

import java.lang.reflect.GenericArrayType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Задания части 5/6");
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

                    System.out.println("Введите две строки: ");

                    System.out.println("Результат: " + sameLetterPattern(new Scanner(System.in).nextLine(), new Scanner(System.in).nextLine()));

                    break;
                case "2":
                    System.out.println("Введите две координаты: ");

                    System.out.println("Маршрут: " + spiderVsFly(scan.next(), scan.next()));

                    break;
                case "3":

                    System.out.print("Введите число: ");
                    System.out.println("Число цифр: " + digitsCount(scan.nextLong()));

                    break;

                case "4":

                    System.out.print("Введите кол-во слов: ");

                    String[] ans = new String[scan.nextInt()];

                    for(int i = 0; i < ans.length; i++){
                        ans[i] = scan.next();
                    }

                    System.out.print("Введите слово отгадку: ");

                    System.out.println("Кол-во очков: " + totalPoints(ans, scan.next()));

                    break;

                case "5":
                    System.out.print("Введите длину массива: ");

                    int[] arr = new int[scan.nextInt()];

                    for(int i = 0; i < arr.length; i++){
                        arr[i] = scan.nextInt();
                    }

                    System.out.println("Максимальная ариф. последовательность: " + longestRun(arr));
                    break;

                case "6":
                    System.out.print("Введите длину массива: ");

                    String[] test = new String[scan.nextInt()];

                    for(int i = 0; i < test.length; i++){
                        test[i] = scan.next();
                    }

                    System.out.println("Результат: " + takeDownAverage(test));
                    break;
                case "7":
                    System.out.print("Введите строку: ");
                    System.out.println("Результат: " +
                            rearrange(new Scanner(System.in).nextLine()));
                    break;
                case "8":

                    System.out.print("Введите два числа: ");
                    System.out.println("Результат: " + maxPossible(scan.nextInt(), scan.nextInt()));

                    break;
                case "9":

                    System.out.println("Введите город, дату и еще город: ");
                    System.out.println("Результат: " + timeDifference(new Scanner(System.in).nextLine(), new Scanner(System.in).nextLine(), new Scanner(System.in).nextLine()));

                    break;
                case "10":
                    System.out.println("Введите число: ");
                    System.out.println("Результат: " + isNew(scan.nextInt()));
                    break;
            }


        }while(!s.equals("exit") && !s.equals("e"));
    }

    //Метод для вывода меню
    public static void PrintMenu(){
        System.out.println("Выберите задание");
        System.out.println("1. Шаблончики");
        System.out.println("2. Павук (без кружки)");
        System.out.println("3. Рекурсивный подсчет");
        System.out.println("4. Твистер там какой-то");
        System.out.println("5. Лучше подлинее");
        System.out.println("6. Результат гениального перевода");
        System.out.println("7. Снова работа со строками :(");
        System.out.println("8. Зачем-то мы меняем цифры");
        System.out.println("9. ЗАДАЧА НА 2 ЧАСА ВОТ УЖ ДЕЙСТВИТЕЛЬНО НА ВРЕМЯ (КЧАЮ)");
        System.out.println("10. Что-то там про новое");
        System.out.println("exit или e для выхода");
    }

    //Метод для построения карты расположения символов
    public static List<Integer> BuildMap(String str) {
        ArrayList<Integer> map = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            map.add(str.indexOf(str.charAt(i)));
        }

        return map;
    }
    //Метод получает карты строк и сравнивает
    public static boolean sameLetterPattern(String str1, String str2) {
        return BuildMap(str1).equals(BuildMap(str2));
    }

    //Codewars: Jomo Pipi, karinakok
    public static String spiderVsFly(final String spider, final String fly){
        String radials = "ABCDEFGH";

        char sr = spider.charAt(0), sl = spider.charAt(1), fr = fly.charAt(0), fl = fly.charAt(1);

        char midRing = Math.abs(sr - fr) <= 2 || Math.abs(sr - fr) >= 6 ? (char)Math.min(sl,fl) : '0';

        String answer = ""+sr+sl+"-";

        while (sl > midRing) answer += (--sl == '0' ? "A0-" : ""+ sr + sl + "-");


        while (sl <= fl && midRing != '0') {
            if (sr == fr) break;
            if (6 <= Math.abs(sr -fr)) {
                if (sr > fr) { sr++; if (sr == 'I') sr = 'A';
                }else{ sr--; if (sr == '@') sr = 'H';}
            }
            else{
                if (sr < fr) sr++; else sr--;
            }
            answer += "" + sr + sl + "-";
        }

        while (sl++ < fl) answer += "" + fr + sl + "-";

        return answer.substring(0,answer.length()-1);
    }

    //Подсчет цифр
    public static int digitsCount(long num){

        //Если число состоит из одной цифры
        if (num % 10 == num){
            return 1;
        }

        //Плюс 1 и уменьшаем число
        return digitsCount(num / 10) + 1;
    }

    //Проверка, явялется ли слово состоящим из букв второго слова
    public static boolean consistOf(String word, final String magic){

        String nomagic = magic;
        char ch;

        //Проходим слово и анализируем символы
        for(int i = 0; i < word.length(); i++){

            ch = word.charAt(i);
            //Если символ не содержится в магическом слове
            if(!nomagic.contains("" + ch)){
                return false;
            }

            //Убираем лишний символ
            nomagic = nomagic.substring(0, nomagic.indexOf(ch)) + nomagic.substring(nomagic.indexOf(ch) + 1);
        }

        return true;

    }
    //Твистер
    public static int totalPoints(String[] ans, String magicWord){

        int sum = 0;

        //Проходим массив
        for(int i = 0; i < ans.length; i++){

            //Проверяем каждое слово
            if(consistOf(ans[i], magicWord)){

                if(ans[i].length() == 3){
                    sum += 1;
                }else if(ans[i].length() == 4){
                    sum += 2;
                }else if(ans[i].length() == 5){
                    sum += 3;
                }else if(ans[i].length() == 6){
                    sum += 54;
                }
            }
        }

        return sum;
    }


    //Поиск максимальной возврастающей последовательности
    public static int IncreaselongestRun(int[] arr){
        int max = 0;
        int curr = 0;

        for(int i = 1; i < arr.length; i++){

            curr = 1;

            while(i < arr.length && arr[i] - arr[i - 1] == 1){
                curr++;
                i++;
            }

            max = Math.max(max, curr);

        }

        return max;

    }

    //Поиск максимальной невозврастающей последовательности
    public static int DecreaselongestRun(int[] arr){
        int max = 0;
        int curr = 0;

        for(int i = 1; i < arr.length; i++){

            curr = 1;

            while(i < arr.length && arr[i] - arr[i - 1] == -1){
                curr++;
                i++;
            }

            max = Math.max(max, curr);

        }

        return max;

    }

    //Поиск максимальной (не)возврастающей последовательности
    public static int longestRun(int[] arr){
        return Math.max(IncreaselongestRun(arr), DecreaselongestRun(arr));
    }

    //Усреднение результат
    public static String takeDownAverage(String[] arr){

        double sum = 0;

        for(int i = 0; i < arr.length; i++){

            sum += Integer.parseInt(arr[i].substring(0, arr[i].indexOf('%'))) - 5;

        }

        sum = sum / arr.length - 5 * arr.length;

        return Math.round(sum) + "%";

    }

    //Упорядочить строку
    public static String rearrange(String s){

        int index;

        String res = "", buff = "";

        String[] spl = s.split(" ");
        if(spl.length == 0){ return ""; }

        String[] sorted = new String[spl.length];

        Pattern pat=Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
        Matcher matcher; /*pat.matcher("45.5saf -fg123 -18+");*/

        for(int i = 0; i < spl.length; i++){
            //Передаем строку для поиска соответсвий
            matcher = pat.matcher(spl[i]);

            //Ищем
            matcher.find();

            //Возвращаем найденное число
            index = Integer.parseInt(buff = matcher.group());

            sorted[index - 1] = spl[i].substring(0, spl[i].indexOf("" + index)) + spl[i].substring(spl[i].indexOf("" + index) + ("" + index).length());

        }

        //Строим выходную строку
        for(int i = 0; i < sorted.length; i++){
            res += sorted[i] + " ";
        }

        return res.substring(0, res.length() - 1);

    }

    //Метод для сортировки цифр числа
    public static int sortNum(int num){

        char[] chars = ("" + num).toCharArray();
        Character[] ch = new Character[chars.length];

        for(int i = 0 ; i < chars.length; i++){
            ch[i] = chars[i];
        }

        Arrays.sort(ch, Collections.reverseOrder());

        for(int i = 0 ; i < chars.length; i++){
            chars[i] = ch[i];
        }

        return Integer.parseInt(new String(chars));
    }
    //Буст числа
    public static int maxPossible(int a, int b){
        //Сортировка числа
        String sa = "" + a, sb = "" + sortNum(b);

        for(int i = 0; i < sa.length() && sb.length() != 0; i++){

            if((sa.charAt(i) - '\0') < (sb.charAt(0) - '\0')){
                sa = sa.substring(0, i) + sb.charAt(0) + sa.substring(i + 1);
                sb = sb.substring(1);
            }
        }

        return Integer.parseInt(sa);

    }

    //ЗАДАЧА НА 2 ЧАСА
    public static String timeDifference(String cityA, String dateA, String cityB){

        //Таблица часовых поясов
        Map<String, Double> map = new HashMap<>();
        map.put("Los Angeles", -8.0);
        map.put("New York",-5.0);
        map.put("Caracas", -4.5);
        map.put("Buenos Aires",-3.0);
        map.put("London",0.0);
        map.put("Rome", 1.0);
        map.put("Moscow",3.0);
        map.put("Tehran", 3.5);
        map.put("New Delhi",5.5);
        map.put("Beijing",8.0);
        map.put("Canberra",10.0);

        //Форматер
        SimpleDateFormat formater = new SimpleDateFormat("MMMM dd, yyyy HH:mm", Locale.US);
        GregorianCalendar LondonDate;
        Date d = new Date();

        //Дата
        try {
            d = formater.parse(dateA);
        }catch(ParseException e){
            e.printStackTrace();
        }
        System.out.println(d.toString());

        LondonDate = new GregorianCalendar();
        LondonDate.set(Calendar.YEAR, d.getYear() + 1900);

        LondonDate.set(Calendar.MONTH, d.getMonth());

        LondonDate.set(Calendar.DAY_OF_MONTH, d.getDate());

        LondonDate.set(Calendar.HOUR_OF_DAY, d.getHours());

        LondonDate.set(Calendar.MINUTE, d.getMinutes());

        int AHour = (int)map.get(cityA).doubleValue();
        double AMinute = (map.get(cityA).doubleValue() - (int)map.get(cityA).doubleValue());

        LondonDate.add(Calendar.HOUR_OF_DAY, -(AHour));
        LondonDate.add(Calendar.MINUTE, -(int)(60 * AMinute));


        int BHour = (int)map.get(cityB).doubleValue();
        double BMinute = (map.get(cityB).doubleValue() - (int)map.get(cityB).doubleValue());

        LondonDate.add(Calendar.HOUR_OF_DAY, BHour);
        LondonDate.add(Calendar.MINUTE, (int)(60 * BMinute));


        formater = new SimpleDateFormat("yyyy-M-d HH:mm", Locale.US);

        return formater.format(LondonDate.getTime());


    }

    //Новое число
    public static boolean isNew(int b1) {
        int b = b1;
        int k1 = 0;

        k1 = (int)Math.ceil(Math.log10(b));

        int[] arr = new int[k1];


        //Заполняем массив
        while (b1 > 0) {
            arr[k1 - 1] = b1 % 10;

            b1 = b1 / 10;
            k1 = k1 - 1;
        }

        //Если элемент слева больше правового и правый не ноль
        //то это значит, что можно образовать число меньше исходного
        //и исходное число НЕ НОВОЕ
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1] && arr[i + 1] != 0) {
                return false;
            }
        }
        return true;
    }

}




