package Fundamentals.EX;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());



            numberList.removeIf(e -> e <0);

            Collections.reverse(numberList);

            if(numberList.size() ==0){
                System.out.println("empty");
            }else{
                System.out.println(numberList.toString().replaceAll("[\\[\\],]", ""));
            }
        }
    }

