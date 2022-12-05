package Fundamentals.LAB.BasicSyntax;

import java.util.Scanner;

public class ExperienceGaining {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededExperience = Double.parseDouble(scanner.nextLine());
        int countOfBattles = Integer.parseInt(scanner.nextLine());
        double sum = 0;
        for (int i = 1; i <= countOfBattles; i++) {
            double experienceEarnedPerBattle = Double.parseDouble(scanner.nextLine());
            if (i % 3 == 0){
                experienceEarnedPerBattle += experienceEarnedPerBattle *0.15;
            }if( i % 5== 0){
                experienceEarnedPerBattle -= experienceEarnedPerBattle * 0.10;
            }if(i % 15 ==0){
                experienceEarnedPerBattle += experienceEarnedPerBattle *0.05;
            }
            sum += experienceEarnedPerBattle;
       if(sum >= neededExperience){
           System.out.printf("Player successfully collected his needed experience for %d battles." ,  i);
                   break;
       }
        } if (sum < neededExperience){
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", neededExperience - sum);

        }
    }
}
