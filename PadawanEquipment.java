package Fundamentals.EX;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceOfLightsabers = Double.parseDouble(scanner.nextLine());
        double priceOfRobes = Double.parseDouble(scanner.nextLine());
        double priceOfBelts = Double.parseDouble(scanner.nextLine());

        //sabresPrice * (studentsCount + 10%) + robesPrice * (studentsCount) + beltsPrice * (studentsCount - freeBelts)
        double sumSabres = Math.ceil(students*1.1) * priceOfLightsabers;
        double sumRobes = students * priceOfRobes;
        double sumBelts = (students - students/6) * priceOfBelts;
        double totalPrice = sumSabres + sumRobes + sumBelts;

                if(totalPrice <= money){
                    System.out.printf("The money is enough - it would cost %.2flv." , totalPrice);
                }else{
                    System.out.printf("George Lucas will need %.2flv more." , totalPrice-money);
                }
    }
}
