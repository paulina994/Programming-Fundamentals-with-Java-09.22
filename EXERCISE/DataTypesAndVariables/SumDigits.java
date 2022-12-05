package Fundamentals.EX.DataTypesAndVariables;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0; //сумата на цифрите
        while(number>0){
            int lastDigit = number % 10; //последна цифра
            sum += lastDigit;
            number = number/10; // премахваме последната цифра

        }
        System.out.println(sum);
    }
}
