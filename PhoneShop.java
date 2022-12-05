package Fundamentals.EX;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PhoneShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phones = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!"End".equals(line)) {
            List<String> commands = Arrays.stream(line.split(" - ")).collect(Collectors.toList());
            String command = commands.get(0);

            switch (command) {
                case "Add":
                    String phone1 = commands.get(1);
                    if (!phones.contains(phone1)) {
                        phones.add(phone1);
                    }
                    break;
                case "Remove":
                    String phone2 = commands.get(1);
                    for (int i = 1; i < phones.size(); i++) {
                        if (phones.contains(phone2)) {
                            phones.remove(phone2);
                        }
                    }
                    break;
                case "Bonus phone":
                    String phone3 = commands.get(1);
                    List<String> commands2 = Arrays.stream(phone3.split(":")).collect(Collectors.toList());
                    String oldPhone = commands2.get(0);
                    String newPhone = commands2.get(1);
                    for (int i = 1; i < phones.size(); i++) {
                        if (phones.contains(oldPhone)) {
                            phones.add(i + 1, newPhone);
                            break;
                        }
                    }

                case "Last":
                    String phone4 = commands.get(1);
                    for (int i = 1; i < phones.size(); i++) {
                        if (phones.contains(phone4)) {
                            phones.remove(phone4);
                            phones.add(phone4);
                        }
                        break;
                    }
            }
            line = scanner.nextLine();
        }

        System.out.print(String.join(", ", phones));
    }
}

