package Fundamentals.EX;

import java.util.Arrays;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countWagons = Integer.parseInt(scanner.nextLine());

        int[] wagons = new int[countWagons];
        for (int wagon = 0; wagon < countWagons; wagon++) {
            int countPeople = Integer.parseInt(scanner.nextLine());
            wagons[wagon] = countPeople;


        }
        int sum = 0;
        for (int item : wagons) {
            System.out.print(item + " ");
            sum += item;
        }
        System.out.println();
        System.out.println(sum);

    }
}



