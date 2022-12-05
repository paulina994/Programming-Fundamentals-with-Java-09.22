package Fundamentals.EX.TextProcessing;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] codes = input.split("\\s+");

        double totalSum = 0; // сума от модифицираните числа на всеки код
        for (String code : codes) {
            //код: {буква}{число}{буква}
            //модифицирам си числото в кода спрямо буквите

            double modifiedNumber = getModifiedNumber(code);
            //добавям модифицираното число към сумата
            totalSum += modifiedNumber;
        }
        System.out.printf("%.2f", totalSum);
    }

    private static double getModifiedNumber(String code) {
        //код: {буква}{число}{буква}
        //"A12b"
        char firstLetter = code.charAt(0);
        char secondLetter = code.charAt(code.length() - 1);
        double number = Double.parseDouble(code.replace(firstLetter, ' ')
                .replace(secondLetter, ' ')
                .trim());
        //1.проверка за firstLetter -> главна или малка
        if (Character.isUpperCase(firstLetter)) {
            int positionUpperLetter = (int) firstLetter - 64;
            number = number / positionUpperLetter;
        } else {
            int positionLowerLetter = (int) firstLetter - 96;
            number *= positionLowerLetter;

        }
        if (Character.isUpperCase(secondLetter)) {
            int positionUpperLetter = (int) secondLetter - 64;
            number -=  positionUpperLetter;
        } else {
            int positionLowerLetter = (int) secondLetter - 96;
            number += positionLowerLetter;
            //връщам модифицираното число

        }
        return number;
    }
}
