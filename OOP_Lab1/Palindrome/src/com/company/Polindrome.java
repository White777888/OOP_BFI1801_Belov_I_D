package com.company;

//Класс для проверки слов на полиндромность
public class Polindrome {

    //Основная функция проверки слов
    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++){

            //Читаем строку
            String s = args[i];

            System.out.print(s + " ");

            //Если слово (не)является полиндромом,
            //то выводим соответствующее сообщение
            if(IsPalindrome(s)){
                System.out.println("is palindrome");
            }else{
                System.out.println("is not palindrome");
            }
        }
    }

    //Функция для разворачивания строки наоборот
    public static String ReverseString(String s){

        String res = "";

        //Копируем символы с конца исходной строки
        //В начало результирующей
        for(int i = s.length() - 1; i >= 0; i--){
            res += s.charAt(i);
        }

        return res;
    }

    //Функция проверки строки на полиндромность
    public static boolean IsPalindrome(String s){
        //Возвращает истину, если два объекта равны
        //и ложь в обратном случае
        return s.equals(ReverseString(s));
    }
}
