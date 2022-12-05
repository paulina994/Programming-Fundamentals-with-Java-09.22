package Fundamentals.EX;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] usernames = input.split(", ");

        for (String username : usernames) {
            //ако username е валиден
            if (isValidUsername(username)) {
                System.out.println(username);
            }
        }
    }
    //метод, който проверява дали username е валиден
    //true -> ако username е валиден
    //false -> ако username не е валиден

    public static boolean isValidUsername(String username) {
        //1. валидна дължина -> [3,16]
        boolean isValidLenght = username.length() >= 3 && username.length() <= 16;


        //2.валидно съдържание -> букви, цифри, -,_
        //true -> съдържанието е валидно
        //true -> съдържанието не е валидно
        //username = "test"
        boolean isValidContent = false;
        for (char symbol : username.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                return false;
            }
        }
        isValidContent = true;
        return isValidLenght && isValidContent;
    }
}