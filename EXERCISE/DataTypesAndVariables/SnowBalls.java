package Fundamentals.EX.DataTypesAndVariables;

import FirstStepInCoding.Lab.MaxNumber;

import java.util.Scanner;

public class SnowBalls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double maxValue = Double.MIN_VALUE;
        int snowballSnowBiggest = 0;
        int snowballTTimeBiggest = 0;
        int snowballQualityBiggest = 0;

        for (int i = 1; i <= n; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            double snowballValue = Math.pow(snowballSnow / snowballTime, snowballQuality);
            if (snowballValue > maxValue) {
                maxValue = snowballValue;
                snowballSnowBiggest = snowballSnow;
                snowballTTimeBiggest = snowballTime;
                snowballQualityBiggest = snowballQuality;
            }



        }System.out.printf("%d : %d = %.0f (%d)", snowballSnowBiggest, snowballTTimeBiggest, maxValue, snowballQualityBiggest);
    }
}
