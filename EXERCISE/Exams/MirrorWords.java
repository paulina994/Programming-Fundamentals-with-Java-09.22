package Fundamentals.EX.Exams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //намираме думи, които образуват двойка
        String text = scanner.nextLine();
        String regex = "(@|#)(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> pairs = new ArrayList<>();
        int countAllPairs = 0;// брой на всички двойки

        while (matcher.find()) {
            String firstWord = matcher.group("first");
            String secondWord = matcher.group("second");
            countAllPairs++;
            //проверка дали думите са печеливши
            StringBuilder secondWordBuilder = new StringBuilder(secondWord);
            String reversedSecondWord = secondWordBuilder.reverse().toString();

            if (firstWord.equals(reversedSecondWord)) {
                pairs.add(firstWord + " <=> " + secondWord);

            }
        }
        // отпечатваме брой на намерените двойки
        if (countAllPairs == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(countAllPairs + " word pairs found!");
        }
        //отпечатваме валидните двойки
        if (pairs.size() == 0) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", pairs));
        }
    }
}
