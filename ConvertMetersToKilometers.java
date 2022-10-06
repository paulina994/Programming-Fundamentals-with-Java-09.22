package Fundamentals.LAB;

import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        short meters = Short.parseShort(scanner.nextLine());

        double km = meters / 1000.00;
        System.out.printf("%.2f" , km);
    }
}
