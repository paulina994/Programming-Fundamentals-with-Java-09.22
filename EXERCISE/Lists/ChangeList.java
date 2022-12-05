package Fundamentals.EX.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. списък с числа - > входни данни
        //2. получаваме команди -> "end"
        // "Delete{element}" -> "Delete 3"
        //"Insert" {element}{position}

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine(); //команди
        while (!command.equals("end")) {
            //команда
            //1, command = "Delete 3"
            //2. command = "Insert 3 1"
            if (command.contains("Delete")) {
                //"Delete 3"

                int numberForRemove = Integer.parseInt(command.split(" ")[1]);
                //премахваме всички стойности от списъка равни на
                numbers.removeAll(Arrays.asList(numberForRemove));

            } else if (command.contains("Insert")) {
                //вмъкна element на index
//"Insert 3 1"
                int element = Integer.parseInt(command.split(" ")[1]);
                int index = Integer.parseInt(command.split(" ")[2]);
                numbers.add(index, element);

            }
            command = scanner.nextLine();


        }
        for (int number : numbers) {
            System.out.print(number + " ");
        }

    }

}




