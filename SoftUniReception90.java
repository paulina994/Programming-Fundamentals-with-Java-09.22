package Fundamentals.EX;

import java.util.Scanner;

public class SoftUniReception90 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int secondEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int thirdEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        double  studentsCount = Double.parseDouble(scanner.nextLine());



int sumEfficiencyPerHour = firstEmployeeEfficiency +secondEmployeeEfficiency +thirdEmployeeEfficiency;
double neededHours = studentsCount / sumEfficiencyPerHour;
        for (int i = 1; i <= neededHours; i++) {
            if(i % 4 ==0){
                neededHours++;


            }

        }
        System.out.printf("Time needed: %dh." ,Math.round(neededHours));

    }
}
