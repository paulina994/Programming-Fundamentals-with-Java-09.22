package Fundamentals.EX;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPieces = Integer.parseInt(scanner.nextLine());

        Map<String, String> pieceAndComposer = new LinkedHashMap<>();
        Map<String, String> pieceAndKey = new LinkedHashMap<>();

        for (int i = 0; i < numberOfPieces; i++) {
            String input = scanner.nextLine();
            String[] inputData = input.split("\\|");
            String piece = inputData[0];
            String composer = inputData[1];
            String key = inputData[2];

            pieceAndComposer.put(piece, composer);
            pieceAndKey.put(piece, key);

        }
        String inputLine = scanner.nextLine();
        while (!inputLine.equals("Stop")) {
            String[] input = inputLine.split("\\|");
            String command = input[0];
            String piece = input[1];

            switch(command){
                case"Add":
                 String composer = input[2];
                 String key = input[3];

                 if(pieceAndComposer.containsKey(piece)){
                     System.out.printf("%s is already in the collection!%n" , piece);
                 }else{
                     pieceAndComposer.put(piece, composer);
                     pieceAndKey.put(piece,key);
                     System.out.printf("%s by %s in %s added to the collection!%n" , piece, composer,key);
                 }
                    break;
                case"Remove":
                    if(!pieceAndComposer.containsKey(piece)){
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n" , piece);
                    }else{
                        pieceAndComposer.remove(piece);
                        pieceAndKey.remove(piece);
                        System.out.printf("Successfully removed %s!%n" ,piece);
                    }
                    break;
                case"ChangeKey":
                    String newKey = input[2];
                    if(!pieceAndKey.containsKey(piece)){
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                    }else{
                        pieceAndKey.put(piece, newKey);
                        System.out.printf("Changed the key of %s to %s!%n" , piece,newKey);
                    }
                    break;
            }

            inputLine = scanner.nextLine();
        }
        pieceAndComposer.entrySet()
                .forEach(entry->{
                    String key = entry.getKey();
                    System.out.printf("%s -> Composer: %s, Key: %s%n" , entry.getKey(), entry.getValue(), pieceAndKey.get(key));
                });
    }
}
