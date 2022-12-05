package Fundamentals.EX;

import java.util.Scanner;

public class TheImitationGame50Procent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] inputData = input.split("\\|");
            String command = inputData[0];

            switch (command) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(inputData[1]);
                    String firstPart = encryptedMessage.substring(0, numberOfLetters);
                    String secondPart = encryptedMessage.substring(numberOfLetters);
                    encryptedMessage = secondPart + firstPart;


                    break;
                case "Insert":
                    int index = Integer.parseInt(inputData[1]);
                    String value = inputData[2];
                    String first = encryptedMessage.substring(0, index);
                    String second = encryptedMessage.substring(index);
                    encryptedMessage = first + value + second;

                    break;
                case "ChangeAll":
                    String substring = inputData[1];
                    String replacement = inputData[2];
                    encryptedMessage = encryptedMessage.replaceAll(substring, replacement);

                    break;
            }
            input = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s", encryptedMessage);
    }

}

