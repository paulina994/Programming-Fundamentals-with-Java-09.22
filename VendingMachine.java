package Fundamentals.EX;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double sum = 0;

        while (!input.equals("Start")) {
            double coins = Double.parseDouble(input);

            if (coins != 0.1 && coins != 0.2 && coins != 0.5 && coins != 1 && coins != 2) {
                System.out.printf("Cannot accept %.2f", coins);
            } else {
                sum += coins;
            }

            input = scanner.nextLine();
        } input = scanner.nextLine();
        while (!input.equals("End")) {
            switch (input) {
                case"Nuts":
                    if(sum>=2.00){
                        sum-=2.00;
                        System.out.println("Purchased Nuts");
                    }else{
                        System.out.println("Sorry, not enough money");
                    }break;
                case "Water":
                    if(sum>=0.70){
                        sum-=0.70;
                        System.out.println("Purchased Water");
                    }else{
                        System.out.println("Sorry, not enough money");
                    }break;
                case "Crisps":
                    if(sum>=1.50){
                        sum-=1.50;
                        System.out.println("Purchased Crisps");
                    }else{
                        System.out.println("Sorry, not enough money");
                    }break;
                case "Soda":
                    if(sum>=0.80){
                        sum-=0.80;
                        System.out.println("Purchased Soda");
                    }else{
                        System.out.println("Sorry, not enough money");
                    }break;
                case "Coke":
                    if(sum>=1.00){
                        sum-=1.00;
                        System.out.println("Purchased Coke");
                    }else{
                        System.out.println("Sorry, not enough money");
                    }break;
                default:
                    System.out.println("Invalid product");

            }input = scanner.nextLine();


        }System.out.printf("Change: %.2f", sum);
    }
}
