package Fundamentals.LAB.Exams;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String activationKey = scan.nextLine();
        String input;

        while (!"Generate".equals(input = scan.nextLine())) {
            String[] tokens = input.split(">>>");

            switch (tokens[0]) {
                case "Contains":
                    if (activationKey.contains(tokens[1])) {
                        System.out.println(activationKey + " contains " + tokens[1]);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    int start = Integer.parseInt(tokens[2]);
                    int end = Integer.parseInt(tokens[3]);
                    if (tokens[1].equals("Upper")) {
                        activationKey = activationKey.substring(0, start) + activationKey.substring(start, end).toUpperCase() + activationKey.substring(end);
                    } else if (tokens[1].equals("Lower")) {
                        activationKey = activationKey.substring(0, start) + activationKey.substring(start, end).toLowerCase() + activationKey.substring(end);
                    }
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    activationKey = activationKey.substring(0, Integer.parseInt(tokens[1])) +
                            activationKey.substring(Integer.parseInt(tokens[2]));
                    System.out.println(activationKey);
                    break;
            }
        }
        System.out.println("Your activation key is: " + activationKey);
    }

    public static class SumAdjacentEqualNumbers {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            List<Double> numbersList = Arrays.stream(scanner.nextLine()
                            .split(" "))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            for (int i = 0; i < numbersList.size() - 1; i++) {
                double currentNum = numbersList.get(i);
                double nextNum = numbersList.get(i + 1);
                if (currentNum == nextNum) {
                    numbersList.set(i, currentNum + nextNum);
                    numbersList.remove(i + 1);
                    i = -1;

                }

            }
            System.out.println(joinElementsByDelimiter(numbersList," "));

        }
        public static String joinElementsByDelimiter(List<Double> list, String delimiter){
            DecimalFormat df = new DecimalFormat("0.#");
            String result ="";
            for (double item : list) {
                String numDf = df.format(item) + delimiter;
                result += numDf;
            }
        return result;
        }
    }
}