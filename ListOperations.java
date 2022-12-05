package Fundamentals.EX;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //списък с цели числа
        //въвеждаме команди -> спираме: "End"
        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            if (command.contains("Add")) {
                int numberToAdd = Integer.parseInt(command.split("\\s+")[1]);
                numbers.add(numberToAdd);

            } else if (command.contains("Insert")) {
                int numberToInsert = Integer.parseInt(command.split("\\s+")[1]);
                int index = Integer.parseInt(command.split("\\s+")[2]);
                //проверка дали индексът същеструва в списъка
                if (isValidIndex(index, numbers)) {
                    numbers.add(index, numberToInsert);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (command.contains("Remove")) {
                int indexForRemove = Integer.parseInt(command.split("\\s+")[1]);
                if (isValidIndex(indexForRemove, numbers)) {
                    numbers.remove(indexForRemove);
                } else {
                    System.out.println("Invalid index");
                }

                //проверка дали индексът същеструва в списъка
            } else if (command.contains("Shift left")) {
                int countShiftLeft = Integer.parseInt(command.split("\\s+")[2]);
                //повтаряме нещо countShift left пъти
                for (int time = 1; time <= countShiftLeft; time++) {
                //first number becomes last
                int firstNumber = numbers.get(0);
                numbers.remove(0);
                numbers.add(firstNumber);
                }
            } else if (command.contains("Shift right")) {
                int countShiftRight = Integer.parseInt(command.split("\\s+")[2]);
                //повтаряне на дейност -> countShiftRight пъти
                for (int time = 1; time <= countShiftRight; time++) {
                    //last number becomes first
                    //1. взимам последното число от списъка -> index = size - 1
                    int lastNumber = numbers.get(numbers.size() - 1);
                    //2. премахвам последното число от списъка
                    numbers.remove(numbers.size() - 1);
                    //3. добавям го в началото на списъка
                    numbers.add(0, lastNumber);
                }

            }


            command = scanner.nextLine();
        }
        for(int number : numbers){
            System.out.print(number + " ");
        }
    }//метод, който проверява дали индексът е валиден

    // true -> валиден индекс -> [0, size - 1]
    //false -> невалиден индекс
    public static boolean isValidIndex(int index, List<Integer> numbers) {
        return index >= 0 && index <= numbers.size() - 1;

    }

}
