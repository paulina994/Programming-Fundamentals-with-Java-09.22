package Fundamentals.EX.Methods;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int number = 1; number <= n; number++) {
            //проверка дали е топ число
            //1. сумата от цифрите да се дели на 8
            //2. съдържа поне една нечетна цифра
            if(isSumOfDigitDivisibleBy8(number) && isContainsOddDigit(number)){
                System.out.println(number);
            }
        }
    }
    //метод, който проверява дали сумата от цифрите се дели на 8
    //true -> ако сумата се дели на 8
    //false -> ако сумата не се дели на 8

    public static boolean isSumOfDigitDivisibleBy8(int number) {
        //1.сума от цифрите
        int sumDigits = 0;
        while (number > 0) {
            //взимам последната цифра
            int lastDigit = number % 10;
            //сумирам последната цифра
            sumDigits += lastDigit;
            //премахвам последната цифра
            number = number / 10;
        }
        //2. проверка на сумата за деление с 8
        return sumDigits % 8 == 0;
    }
    //метод, който проверява дали имаме поне една нечетна цифра в числото
    // true -> имам поне една нечетна цифра
    //false -> ако нямам нито 1 нечетна цифра
    public static boolean isContainsOddDigit(int number) {
        //обхождам всяка цифра в число -> проверка дали е нечетно
        while (number > 0) {
            //взимам последната цифра
            int lastDigit = number % 10;
            //проверявам дали е нечетна
            if (lastDigit % 2 != 0) {
                return true;

            } else {
                //цифрата да е четна -> премахвам
                number = number / 10;
            }
            //премахвам цифрата

        }return false; //взети са всички цифри и никоя не е била нечетна

    }
}
