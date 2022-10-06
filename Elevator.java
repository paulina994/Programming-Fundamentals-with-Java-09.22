package Fundamentals.EX;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int persons = Integer.parseInt(scanner.nextLine());
        int personsByOneCourse = Integer.parseInt(scanner.nextLine());

        int courses = (int) Math.ceil((double) persons/personsByOneCourse);
        System.out.println(courses);
    }
}
