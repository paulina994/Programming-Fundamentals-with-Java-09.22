package Fundamentals.EX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();


        String regex = "([:]{2}|[*]{2})(?<word>[A-Z][a-z]{2,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int coolTresHold = 1;
        for (char symbol : text.toCharArray()) {
            if (Character.isDigit(symbol)) {
                coolTresHold *= Integer.parseInt(symbol + "");

            }
        }
        System.out.printf("Cool threshold: %d%n", coolTresHold);
        int countValidEmoji = 0;
        List<String> coolEmoji = new ArrayList<>();// готини емоджита

        while (matcher.find()) {
            countValidEmoji++;
            //сума на емоджито
            String word = matcher.group("word");

            int emojiSum = 0;
            for (char symbol : word.toCharArray()) {
                emojiSum += (int) symbol;
            }
            if (emojiSum >= coolTresHold) {
                coolEmoji.add(matcher.group());

            }
        }
        System.out.printf("%d emojis found in the text. The cool ones are:%n", countValidEmoji);
        coolEmoji.forEach(emoji -> System.out.println(emoji));
    }
}
