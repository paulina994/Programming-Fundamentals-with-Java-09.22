package Fundamentals.LAB.RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        //peter georgiev, peter Georgiev, Peter GeoRgiev, PEter GEorgiev, Peter Georgiev, Anna Petrova

        String regex = "\\b([A-Z][a-z]+) ([A-Z][a-z]+)\\b";

        Pattern pattern = Pattern.compile(regex); //шаблон

        Matcher matcher = pattern.matcher(text); // текстовете от променливата  text, които ми отговарят на шаблона

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");

        }
    }
}
