package Fundamentals.EX.ArraysExercice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] commandArr = input.split(" ");
            String command = commandArr[0];

            switch (command) {
                case "swap":
                    int swapIndexOne = Integer.parseInt(commandArr[1]);
                    int swapIndexTwo = Integer.parseInt(commandArr[2]);

                    int valueAtIndexOne = numbersArr[swapIndexOne]; //-2
                    int valueAtIndexTwo = numbersArr[swapIndexTwo]; // 87

                    numbersArr[swapIndexOne] = valueAtIndexTwo;
                    numbersArr[swapIndexTwo] = valueAtIndexOne;

                    break;
                case "multiply":
                    int multiplyIndexOne = Integer.parseInt(commandArr[1]);
                    int multiplyIndexTwo = Integer.parseInt(commandArr[2]);

                    int product = numbersArr[multiplyIndexOne] * numbersArr[multiplyIndexTwo];
                    numbersArr[multiplyIndexOne] = product;

                    break;
                case "decrease":
                    for (int i = 0; i < numbersArr.length; i++) {
                        numbersArr[i] = numbersArr[i] - 1;

                    }
                    break;
            }


            input = scanner.nextLine();
        }
        for (int i = 0; i < numbersArr.length; i++) {
            if (i == numbersArr.length - 1) {
                System.out.print(numbersArr[i]);
            } else {
                System.out.print(numbersArr[i] + ", ");
            }
        }
    }
}
