package Fundamentals.LAB.BasicSyntax;

import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] inputArr = scanner.nextLine().split(" ");
        int[] numArr = new int[inputArr.length];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(inputArr[i]);


        } int evenSum = 0;
        for (int i = 0; i < numArr.length; i++) {
            int currentElement = numArr[i];
            if(currentElement % 2 ==0){
                evenSum += currentElement;
            }

        }
        System.out.println(evenSum);
}
}
