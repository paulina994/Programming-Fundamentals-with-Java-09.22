package Fundamentals.EX;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Done")) {
            if (command.contains("TakeOdd")) {
                //1.взимаме символите на нечетни индекси (1,3,5,7,9...)
                //2.отпечатвам новата парола
                String newPassword = getCharsOnOddPosition(password); //новообразувана парола
                password = newPassword;
                System.out.println(newPassword);

            } else if (command.contains("Cut")) {
                int index = Integer.parseInt(command.split("\\s+")[1]);
                int length = Integer.parseInt(command.split("\\s+")[2]);
                //1.взимам от паролата текстът, който започва от index и е с дължина length
                String substringToRemove = password.substring(index, index + length);
                //2.премахна първото срещане на този текст от паролата
                password = password.replaceFirst(substringToRemove , "");

                System.out.println(password);
            } else if (command.contains("Substitute")) {
                String substring = command.split("\\s+")[1];
                String substitute = command .split("\\s+")[2];

                if(password.contains(substring)){
                    //заменя всички substring със substitute
                    password= password.replaceAll(substring, substitute);
                    System.out.println(password);
                }else{
                    //в паролата да нямам текст за замяна
                    System.out.println("Nothing to replace!");
                }

            }


            command = scanner.nextLine();
        }
        System.out.printf("Your password is: " + password);
    }

    private static String getCharsOnOddPosition(String password) {
        StringBuilder newPassword = new StringBuilder(); //конструирам новата парола
        for (int i = 0; i <= password.length() - 1; i++) {
            if (i % 2 != 0) {
                //позицията е нечетна
                char currentSymbol = password.charAt(i);
                newPassword.append(currentSymbol);
            }

        }
        return newPassword.toString();
    }
}
