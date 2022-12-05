package Fundamentals.EX.Exams;


import java.util.*;


public class HeroRecruitment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> heroesSpells = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commands = input.split(" ");
            String command = commands[0];
            String heroName = commands[1];
            switch (command) {
                case "Enroll":
                    if (heroesSpells.containsKey(heroName)) {
                        System.out.printf("%s is already enrolled.%n", heroName);
                    } else {
                        heroesSpells.put(heroName, new ArrayList<>());
                    }

                    break;
                case "Learn":
                    String spellName = commands[2];
                    if (!heroesSpells.containsKey(heroName)) {
                        System.out.printf("%s doesn't exist.%n", heroName);
                    } else {
                        for (List<String> values : heroesSpells.values()) {
                            if (values.contains(spellName)) {
                                System.out.printf("%s has already learnt %s.%n", heroName, spellName);
                            } else {
                                heroesSpells.get(heroName).add(spellName);
                                break;
                            }
                        }
                    }
                    break;

                case "Unlearn":
                    String spell = commands[2];
                    if (!heroesSpells.containsKey(heroName)) {
                        System.out.printf("%s doesn't exist.%n", heroName);
                    } else {
                        for (List<String> values : heroesSpells.values()) {
                            if (!values.contains(spell)) {
                                System.out.printf("%s doesn't know %s.%n", heroName, spell);
                            } else {
                                heroesSpells.get(heroName).remove(spell);
                            }
                       break;
                        }
                        break;
                    }
            }
            input = scanner.nextLine();
        }
        System.out.println("Heroes:");
        heroesSpells.entrySet()
                .forEach(entry -> {
                    if(entry.getValue().size() == 0) {
                        System.out.printf("== %s:", entry.getKey());
                    }else{
                        System.out.printf("== %s: ", entry.getKey());
                    }
                    System.out.println(String.join(", ", entry.getValue()));
                });
    }
}
