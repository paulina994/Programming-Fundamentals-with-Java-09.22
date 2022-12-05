package Fundamentals.EX.Exams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> cityPopulation = new LinkedHashMap<>();
        Map<String, Integer> cityGold = new LinkedHashMap<>();
        while (!input.equals("Sail")) {
            String[] inputData = input.split("\\|\\|");
            String city = inputData[0];
            int population = Integer.parseInt(inputData[1]);
            int gold = Integer.parseInt(inputData[2]);

            if (!cityPopulation.containsKey(city)) {
                cityPopulation.put(city, population);
                cityGold.put(city, gold);
            } else {
                int currentPopulation = cityPopulation.get(city);
                cityPopulation.put(city, currentPopulation + population);
                int currentGold = cityGold.get(city);
                cityGold.put(city, currentGold + gold);
            }
            input = scanner.nextLine();
        }
        String inputLine = scanner.nextLine();
        while (!inputLine.equals("End")) {
            String[] inputData = inputLine.split("=>");
            String command = inputData[0];
            String city = inputData[1];

            switch (command) {
                case "Plunder":
                    int peopleKilled = Integer.parseInt(inputData[2]);
                    int goldStolen = Integer.parseInt(inputData[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, goldStolen, peopleKilled);

                    int currentPeople = cityPopulation.get(city);
                    cityPopulation.put(city, currentPeople - peopleKilled);

                    int currentGold = cityGold.get(city);
                    cityGold.put(city, currentGold - goldStolen);
                    if (cityGold.get(city) == 0 || cityPopulation.get(city) == 0) {
                        cityPopulation.remove(city);
                        cityPopulation.remove(city);
                        System.out.printf("%s has been wiped off the map!%n", city);
                    }

                    break;
                case "Prosper":
                    int goldAdded = Integer.parseInt(inputData[2]);
                    if (goldAdded < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        int currentAmount = cityGold.get(city);
                        cityGold.put(city, goldAdded + currentAmount);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldAdded, city, currentAmount + goldAdded);
                    }


                    break;

            }


            inputLine = scanner.nextLine();
        }
        if (cityPopulation.size() == 0) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cityPopulation.size());
            cityPopulation.entrySet()
                    .forEach(entry ->
                    {
                        String city = entry.getKey();
                        System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", entry.getKey(), entry.getValue(), cityGold.get(city))
                        ;

                    });
        }
    }
}
