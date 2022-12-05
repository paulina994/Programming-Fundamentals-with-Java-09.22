package Fundamentals.EX;

import java.util.*;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        Map<String, List<Integer>> carsInfo = new LinkedHashMap<>();

        for (int i = 1; i <= numberOfCars; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String car = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);


            carsInfo.putIfAbsent(car, new ArrayList<>());
            carsInfo.get(car).add(0, mileage);
            carsInfo.get(car).add(1, fuel);
        }
        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] inputData = input.split("\\s+:\\s+");
            String command = inputData[0];
            String car = inputData[1];

            int mileage = carsInfo.get(car).get(0);
            int fuel = carsInfo.get(car).get(1);

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(inputData[2]);
                    int consumedFuel = Integer.parseInt(inputData[3]);

                    if (fuel >= consumedFuel) {
                        carsInfo.get(car).set(0, mileage + distance);
                        carsInfo.get(car).set(1, fuel - consumedFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, consumedFuel);

                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }

                    if (mileage + distance >= 100000) {
                        System.out.printf("Time to sell the %s!%n", car);
                        carsInfo.remove(car);
                    }
                    break;
                case "Refuel":
                    int refillFuel = Integer.parseInt(inputData[2]);
                    int totalFuel = fuel + refillFuel;
                    int diff = 0;
                    if (totalFuel > 75) {
                        diff = 75 - fuel;
                        totalFuel = 75;
                    } else {
                        diff = refillFuel;
                    }
                    carsInfo.get(car).set(1, totalFuel);
                    System.out.printf("%s refueled with %d liters%n", car, diff);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(inputData[2]);
                    int totalMileage = mileage - kilometers;
                    if (totalMileage < 10000) {
                        totalMileage = 10000;
                    } else {


                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                    }
                    carsInfo.get(car).set(0, totalMileage);
                    break;

            }
            input = scanner.nextLine();
        }
        carsInfo.forEach((key, value) ->
                System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", key, value.get(0), value.get(1)));


/* for (Map.Entry<String, List<Integer>> entry : carsInfo.entrySet()){
    String car = entry.getKey();
    int mileage = entry.getValue().get(0);
    int fuel = entry.getValue().get(1);
    System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n" , car , mileage ,fuel);} */
    }
}


