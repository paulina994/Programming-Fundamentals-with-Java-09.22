package Fundamentals.EX.Exams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SpaceTravel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List< String > list =
                Arrays.stream ( scanner.nextLine ( ).split ( "\\|\\|" ) ).collect ( Collectors.toList ( ) );
        int gas = scanner.nextInt ( );
        int stock = scanner.nextInt ( );
        boolean fail = false;
        for ( int i = 0 ; i < list.size ( ) ; i++ ) {
            String[] input = list.get ( i ).split ( " " );

            switch (input[ 0 ]) {
                case "Travel":
                    int number = Integer.parseInt ( input[ 1 ] );
                    if ( gas < number ) {
                        System.out.printf ( "Mission failed.%n" );
                        fail = true;
                        break;
                    } else {
                        gas = gas - number;
                        System.out.printf ( "The spaceship travelled %d light-years.%n" , number );
                    }
                    break;
                case "Enemy":
                    number = Integer.parseInt ( input[ 1 ] );
                    if ( stock >= number ) {
                        stock = stock - number;
                        System.out.printf ( "An enemy with %d armour is defeated.%n" , number );
                    } else {
                        if ( gas - ( 2 * number ) > 0 ) {
                            gas = gas - ( 2 * number );
                            System.out.printf ( "An enemy with %d armour is outmaneuvered.%n" , number );

                        } else {
                            System.out.printf ( "Mission failed.%n" );
                            fail = true;
                            break;
                        }

                    }
                    break;
                case "Repair":
                    number = Integer.parseInt ( input[ 1 ] );
                    gas = gas+number;
                    stock = stock + (2*number);
                    System.out.printf ( "Ammunitions added: %d.%n",number*2 );
                    System.out.printf ( "Fuel added: %d.%n",number );
                    break;
                case "Titan":
                    System.out.printf ( "You have reached Titan, all passengers are safe." );

            }
            if (fail){
                break;
            }
        }
    }
}