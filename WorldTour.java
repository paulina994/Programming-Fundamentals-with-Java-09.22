package Fundamentals.EX;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();
        StringBuilder stopsBuilder = new StringBuilder(stops);
        String input = scanner.nextLine();

        while (!input.equals("Travel")) {
            String[] inputData = input.split(":");


            String command = inputData[0];
            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(inputData[1]);
                    String stopToAdd = inputData[2];
                    if (isValidIndex(index, stopsBuilder)) {
                        stopsBuilder.insert(index, stopToAdd);


                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(inputData[1]);
                    int endIndex = Integer.parseInt(inputData[2]);
                    if (isValidIndex(startIndex, stopsBuilder) && isValidIndex(endIndex, stopsBuilder)) {
                        stopsBuilder.delete(startIndex, endIndex + 1);

                    }
                    break;
                case "Switch":
                    String oldString = inputData[1];
                    String newString = inputData[2];
                    if (stops.contains(oldString)) {
                        String updatedText = stopsBuilder.toString().replace(oldString, newString);
                        stopsBuilder = new StringBuilder(updatedText);
                    }


                    break;
            }
            System.out.println(stopsBuilder);
            input = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", stopsBuilder);


    }

    public static boolean isValidIndex(int index, StringBuilder builder) {
        return index >= 0 && index <= builder.length() - 1;

    }
}
