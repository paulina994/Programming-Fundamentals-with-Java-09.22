package Fundamentals.EX;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinnerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resourse = scanner.nextLine();
        Map<String, Integer> resourcesQuantity = new LinkedHashMap<>();

        while (!resourse.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            //да нямам такъв ресурс
            if (!resourcesQuantity.containsKey(resourse)) {
                resourcesQuantity.put(resourse, quantity);
            } else {
                resourcesQuantity.put(resourse, resourcesQuantity.get(resourse) + quantity);

            }


            resourse = scanner.nextLine();
        }
        //resourcesQuantity.forEach(k, v) -> System.out.println(k + " -> " + v);
        resourcesQuantity.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
