package Fundamentals.EX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> furnitureNames = new ArrayList<>();
        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        String input = scanner.nextLine();

        double totalSum = 0; //общо изхарчена сума
        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);// съхранява се текста, който отговаря на шаблона

            //true -> input отговарят на шаблона
            //false -> input не отговаря на шаблона
            if (matcher.find()) {
                String furnitureName = matcher.group("furniture"); //"Sofa"
                double price = Double.parseDouble(matcher.group("price")); //312.23
                int quantity = Integer.parseInt(matcher.group("quantity"));

                furnitureNames.add(furnitureName);
                double currentFurniturePrice = price * quantity; //платено за текущата мебел
                totalSum += currentFurniturePrice;

            }
            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        furnitureNames.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", totalSum);
    }
}
