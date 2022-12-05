package Fundamentals.EX;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine(); //първоначалния тест

        StringBuilder encryptedText = new StringBuilder();

        for (char symbol : text.toCharArray()) {
            //encryptedText.append(String.format("%c",symbol + 3));
            char encryptedSymbol = (char)(symbol+3);
            encryptedText.append(encryptedSymbol);
        }
        System.out.println(encryptedText);
    }
}
