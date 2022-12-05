package Fundamentals.EX.Exams;

import java.util.Scanner;

public class WorldTour2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();

        StringBuilder newStops = new StringBuilder(stops);
        String input = scanner.nextLine();
        while (!input.equals("Travel")) {
            String[] commands = input.split(":");
            String command = commands[0];
            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(commands[1]);
                    String city = commands[2];
                    if (index >= 0 && index <= newStops.length() - 1) {
                        newStops.insert(index, city);


                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commands[1]);
                    int endIndex = Integer.parseInt(commands[2]);
                    if (startIndex >= 0 && startIndex <= newStops.length() - 1 && endIndex >= 0 && endIndex <= newStops.length() - 1) {

                        newStops.delete(startIndex, endIndex + 1);

                    }
                    break;
                case "Switch":
                    String oldCity = commands[1];
                    String newCity = commands[2];

                    if (stops.contains(oldCity)) {
                        String update = newStops.toString().replace(oldCity, newCity);
                        newStops = new StringBuilder(update);

                        break;
                    }
            }
            System.out.println(newStops);
            input = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", newStops);

    }
}
