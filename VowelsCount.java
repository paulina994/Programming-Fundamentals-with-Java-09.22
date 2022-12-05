package Fundamentals.EX;

import java.util.Locale;
import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        printVowelsCount(text.toLowerCase());
    }

    //метод, който принтира броя на гласните букви
    public static void printVowelsCount(String text) {
        //text е изцяло с малки букви
        int count = 0;
        for (char symbol : text.toCharArray()) {
            if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u') {
                count++;
            }
        }
        System.out.println(count);


    }
}
