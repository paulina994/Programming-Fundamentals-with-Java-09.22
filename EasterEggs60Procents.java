package Fundamentals.EX;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EasterEggs60Procents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "@*#*(?<color>[a-z]{3,})@*#*[^A-Za-z0-9]+\\/+(?<amount>[0-9]+\\.?[0-9]*)\\/+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);


        while (matcher.find()) {

            String color = matcher.group("color");
            int amount = Integer.parseInt(matcher.group("amount"));

            System.out.printf("You found %d %s eggs!%n", amount, color);

        }

    }


}
