package Fundamentals.EX;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "(@|#)(?<wordOne>[A-Za-z]{3,})\\1{2}(?<wordTwo>[A-Za-z]{3,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> words = new ArrayList<>();
        int count = 0;
        while (matcher.find()) {
            String wordOne = matcher.group("wordOne");
            String wordTwo = matcher.group("wordTwo");
            count++;
            String reversedWord = "";
            for (int i = wordTwo.length() - 1; i >= 0; i--) {
                char currentChar = wordTwo.charAt(i);
                reversedWord += currentChar;
            }
            if (reversedWord.equals(wordOne)) {

                words.add(wordOne + " <=> " + wordTwo);
            }
        }
        if (count == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", count);
        }
        if (words.size() == 0) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ",words));


        }
    }
}
