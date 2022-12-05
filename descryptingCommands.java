package Fundamentals.EX;

import java.util.Scanner;

public class descryptingCommands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("Finish")) {
            String[] commands = input.split(" ");
            String command = commands[0];

            switch (command) {
                case "Replace":
                    String currentChar = commands[1];
                    String newChar = commands[2];
                    text = text.replace(currentChar, newChar);
                    System.out.println(text);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(commands[1]);
                    int endIndex = Integer.parseInt(commands[2]);
                    if (startIndex >= 0 && startIndex <= text.length() - 1 && endIndex >= 0 && endIndex <= text.length() - 1) {
                        String substring = text.substring(startIndex, endIndex + 1);
                        text = text.replace(substring, "");
                        System.out.println(text);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;
                case "Make":
                    String upperOrLower = commands[1];
                    if (upperOrLower.equals("Upper")) {
                        text = text.toUpperCase();
                        System.out.println(text);
                    } else {
                        text = text.toLowerCase();
                        System.out.println(text);
                    }
                    break;
                case "Check":
                    String string = commands[1];
                    if(text.contains(string)){
                        System.out.printf("Message contains %s%n",string);
                    }else{
                        System.out.printf("Message doesn't contain %s%n",string);
                    }
                    break;
                case "Sum":
                    int start = Integer.parseInt(commands[1]);
                    int end = Integer.parseInt(commands[2]);
                    if(start >=0  && start <= text.length() -1 && end >=0 && end <= text.length() -1) {
                        String substring = text.substring(start, end + 1);
                        int sum = 0;
                        for(char symbol : substring.toCharArray()){
                            sum += (int) symbol;
                        }
                        System.out.println(sum);
                    }else{
                        System.out.println("Invalid indices!");
                    }
                    break;

            }


            input = scanner.nextLine();
        }
    }
}
