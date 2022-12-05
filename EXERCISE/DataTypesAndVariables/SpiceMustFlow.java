package Fundamentals.EX.DataTypesAndVariables;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int source = Integer.parseInt(scanner.nextLine()); // бр. подпавки в полето

        int days = 0; // бр дни добив
        int totalAmountSpices = 0; // общо количество добити подправки
        while (source >= 100) {
            int spices = source - 26; // добив
            totalAmountSpices += spices;
        days++;
        source = source-10;
        }
        System.out.println(days);
        if(totalAmountSpices>=26){
            totalAmountSpices-=26;
        }
        System.out.println(totalAmountSpices);
    }


}
