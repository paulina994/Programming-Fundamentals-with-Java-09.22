package Fundamentals.EX;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().replaceAll("\\s+","");
        //символ -> бр. срещания

        Map<Character, Integer> symbolsCount = new LinkedHashMap<>();
        for (char symbol : text.toCharArray()) {
            /*if(symbol == ' '){
                continue; // пропуска всичко надолу и преминава към следващия символ
            }*/
            // 1.да не съм срещала такъв символ
            if (!symbolsCount.containsKey(symbol)) {
                symbolsCount.put(symbol, 1);
                //2. да съм срещала такъв символ
            } else {
                int currentCount = symbolsCount.get(symbol); //текущия бр. срещания
                //взимам стойността, стояща срещу ключа symbol
                symbolsCount.put(symbol, currentCount + 1);
            }

        }
        //отпечатваме
        //символ - > бр. срещания
        symbolsCount.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

    }

}



