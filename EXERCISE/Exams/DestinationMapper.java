package Fundamentals.EX.Exams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "(=|\\/)(?<destination>[A-Z]+([A-Za-z]+){2,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int sum = 0;
        List<String> words = new ArrayList<>();
        while (matcher.find()) {

            String word = matcher.group("destination");
            words.add(word);
            sum += word.length();
        }
        System.out.print("Destinations: ");
        System.out.println(String.join(", ", words));
        System.out.printf("Travel Points: %d",sum);
    }
}
