package Fundamentals.EX.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //1.взимам първата карта от тестето
        //2.премахвам картата от ръката
        //3.проверка кой печели:
        //карта 1>карта 2-слагам накрая на ръката на първия -> карта 1 -> карта 2
        //карта 2>карта 1-слагам накрая на ръката на първия -> карта 2 -> карта 1
        //карта 2 = карта 1- не ги добавям отново никъде

        //играта спира, когато някой остане без карти
        while (firstPlayerCards.size() != 0 && secondPlayerCards.size() != 0) {
            int firstPlayerCard = firstPlayerCards.get(0);
            int secondPlayerCard = secondPlayerCards.get(0);

            firstPlayerCards.remove(0);
            secondPlayerCards.remove(0);
            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerCards.add(firstPlayerCard);
                firstPlayerCards.add(secondPlayerCard);

            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerCards.add(secondPlayerCard);
                secondPlayerCards.add(firstPlayerCard);
            }
        }
        if (firstPlayerCards.size() == 0) {
            //вторият печели - > сума от картите на втория
            System.out.printf("Second player wins! Sum: %d", getCardsSum(secondPlayerCards));
        } else if (secondPlayerCards.size() == 0) {
            //първият печели
            System.out.printf("First player wins! Sum: %d", getCardsSum(firstPlayerCards));
        }
    }

    private static int getCardsSum(List<Integer> listCards) {
        int sum = 0;
        for (int card : listCards) {
            sum += card;
        }
        return sum;
    }
}

