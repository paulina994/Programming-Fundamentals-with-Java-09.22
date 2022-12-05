package Fundamentals.EX.RegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //George, Peter, Bill, Tom -> {"George", "Peter", "Bill", "Tom"}
        String names = scanner.nextLine();
        List<String> racersNames = Arrays.stream(names.split(", ")).collect(Collectors.toList());
        // списък с имената на състезателите
        Map<String, Integer> racerDistances = new LinkedHashMap<>();
        racersNames.forEach(name -> racerDistances.put(name, 0));
        //състезател -> дистанция

        //Regex
        String regexLetter = "[A-Za-z]+";
        Pattern patternLetter = Pattern.compile(regexLetter);

        String regexDigit = "[0-9]";
        Pattern patternDigit = Pattern.compile(regexDigit);

        String input = scanner.nextLine();
        while (!input.equals("end of race")) {
            //input = "G!32e%o7r#32g$235@!2e"
            //име на състезателя -само от буквите
            StringBuilder nameBuilder = new StringBuilder();
            Matcher matcherLetter = patternLetter.matcher(input);

            while (matcherLetter.find()) {
                nameBuilder.append(matcherLetter.group());

            }
            //дистанция на състезателя - сума от цифрите
            int distance = 0;
            Matcher matcherDigit = patternDigit.matcher(input); //всички цифри -> ["3", "2"]
            while (matcherDigit.find()) {
                distance += Integer.parseInt(matcherDigit.group());
            }

            String racerName = nameBuilder.toString();//име на състезателя
            if (racerDistances.containsKey(racerName)) {
                int currentDistance = racerDistances.get(racerName);
                racerDistances.put(racerName, currentDistance + distance);
            }


            input = scanner.nextLine();
        }
        //добавя дистанцията на определенив състезател
        List<String> nameOfFirstThree = racerDistances.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))//сортирам записите по value (дистаниция) в намаляващ ред
                .limit(3)//взима 3 записа от мап)
                .map(entry -> entry.getKey()) //на всеки запис взимам ключ
                .collect(Collectors.toList()); // {"George" , "Peter" , "Bill"}
        System.out.println("1st place: " + nameOfFirstThree.get(0));
        System.out.println("2nd place: " + nameOfFirstThree.get(1));
        System.out.println("3rd place: " + nameOfFirstThree.get(2));
        /*без сортировка
        int count = 1;
        for (Map.Entry<String, Integer> pair : racerDistances.entrySet()) {
            if (count == 1) {
                System.out.println("1st place: " + pair.getKey());
                count++;
            } else if (count == 2) {
                System.out.println("2nd place: " + pair.getKey());
                count++;
            } else if (count == 3) {
                System.out.println("3rd place: " + pair.getKey());
                break;*/
    }


}