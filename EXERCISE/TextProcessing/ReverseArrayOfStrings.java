package Fundamentals.EX.TextProcessing;

import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");

        for (int i = 0; i < inputArr.length / 2; i++) {
            String oldElement = inputArr[i]; // a
            inputArr[i] = inputArr[inputArr.length - 1 - i]; //c
            inputArr[inputArr.length - 1 -i] = oldElement;


        }
        System.out.println(String.join( " ",inputArr));

    }
}
