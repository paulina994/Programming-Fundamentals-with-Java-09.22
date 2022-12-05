package Fundamentals.EX.Exams;


import java.util.Scanner;

public class SecretChat2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());
        String line = scanner.nextLine();
        while (!line.equals("Reveal")) {
            String[] data = line.split(":\\|:");
            String command = data[0];
            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(data[1]);
                    sb.insert(index, " ");
                    System.out.println(sb);
                    break;
                case "Reverse":
                    StringBuilder substring = new StringBuilder(data[1]);
                    if (!sb.toString().contains(substring)) {
                        System.out.println("error");
                    } else {

                        int start = sb.indexOf(substring.toString());
                        int end = start + substring.length() - 1;
                        sb.delete(start, end + 1);
                        substring.reverse();
                        sb.append(substring);
                        System.out.println(sb);
                    }
                    break;
                case "ChangeAll":
                    String replacement = data[2];
                    String occurrence = data[1];
                    String replacedString = sb.toString().replaceAll(occurrence,replacement);
                    sb.setLength(0);
                    sb.append(replacedString);
                    System.out.println(sb);
                    break;

            }


            line = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", sb);

    }
}