package Fundamentals.EX;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> nameAndComposer = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String[] piecePart = input.split("\\|");
            String pieceName = piecePart[0];
            String composer = piecePart[1];
            String key = piecePart[2];
            List<String> pieceInfo = new ArrayList<>();
            pieceInfo.add(composer);
            pieceInfo.add(key);

            nameAndComposer.put(pieceName, pieceInfo);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String pieceName = command.split("\\|")[1];
            if (command.contains("Add")) {
                if (nameAndComposer.containsKey(pieceName)) {
                    System.out.printf("%s is already in the collection!%n", pieceName);
                } else {
                    String composer = command.split("\\|")[2];
                    String key = command.split("\\|")[3];
                    List<String> info = new ArrayList<>();
                    info.add(composer);
                    info.add(key);

                    nameAndComposer.put(pieceName, info);


                    System.out.printf("%s by %s in %s added to the collection!%n", pieceName, composer, key);
                }

            } else if (command.contains("Remove")) {
                if (nameAndComposer.containsKey(pieceName)) {
                    nameAndComposer.remove(pieceName);
                    System.out.printf("Successfully removed %s!%n", pieceName);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);

                }
            } else if (command.contains("ChangeKey")) {
                String newKey = command.split("\\|")[2];
                if (!nameAndComposer.containsKey(pieceName)) {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", pieceName);
                } else {
                    List<String> currentInfo = nameAndComposer.get(pieceName);
                    currentInfo.remove(1);
                    currentInfo.add(newKey);
                    nameAndComposer.put(pieceName, currentInfo);
                    System.out.printf("Changed the key of %s to %s!%n", pieceName, newKey);
                }
            }
            command = scanner.nextLine();
        }
        //  "{Piece} -> Composer: {composer}, Key: {key}"
        //entry.getKey() ->име на пиесата
        // entry.getValue().get(0) -> име на композитора
        //entry.getValue().get(1) -> име на тоналността
        nameAndComposer.entrySet()
                .forEach(entry -> System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
    }
}