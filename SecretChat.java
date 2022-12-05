package Fundamentals.EX;

import java.util.Locale;
import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {
            String[] inputData = input.split(":\\|:");
            String command = inputData[0];

            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(inputData[1]);
                    String firstPart = message.substring(0, index);
                    String secondPart = message.substring(index);
                    message = firstPart + " " + secondPart;

                    System.out.println(message);

                    break;
                case "Reverse":
                    String substring = inputData[1];
                    if (message.contains(substring)) {

                        message = message.replaceFirst(substring, "");
                        String reversedSubstring = "";
                        for (int i = substring.length() -1; i >= 0; i--) {
                            char currentChar = substring.charAt(i);
                            reversedSubstring += currentChar;

                        }message = message  + reversedSubstring;
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String sub = inputData[1];
                    String replacement = inputData[2];

                    message = message.replaceAll(sub, replacement);
                    System.out.println(message);

                    break;
            }


            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", message);
    }
}
