package Fundamentals.EX.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> listSeparatedByPipe = Arrays.stream(input.split("\\|"))
                .collect(Collectors.toList());
        Collections.reverse(listSeparatedByPipe);
        System.out.println(listSeparatedByPipe.toString()
                .replace("[" , "")
                .replace("]" , "")
                .trim()// премахваме излищните интервали в началото и в края на текста
                .replaceAll("," , "")
                .replaceAll("\\s+" , " ")); //заменяме интервалите с един интервал
    }
}