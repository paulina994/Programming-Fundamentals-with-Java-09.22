package Fundamentals.EX;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> heroesHP = new LinkedHashMap<>();
        Map<String, Integer> heroesMP = new LinkedHashMap<>();

        int countHeroes = Integer.parseInt(scanner.nextLine());
        for (int hero = 1; hero <= countHeroes; hero++) {
            String heroInfo = scanner.nextLine();
            String[] heroData = heroInfo.split("\\s+");
            String heroName = heroData[0]; //име на героя
            int hp = Integer.parseInt(heroData[1]); // хит точки
            int mp = Integer.parseInt(heroData[2]); // мана точки

            //проверка за hp -> hp <= 100
            if (hp <= 100) {
                heroesHP.put(heroName, hp);
            }
//проверка за mp -> mp <= 200
            if (mp <= 200) {
                heroesMP.put(heroName, mp);
            }
        }//всеки един герой колко hp има
                // всеки един герой колко mp има
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            if (command.contains("CastSpell")) {
                String heroName = command.split("\\s+-\\s+")[1];
                int mpNeeded = Integer.parseInt(command.split("\\s+-\\s+")[2]);
                String spellName = command.split("\\s+-\\s+")[3];

                int currentMP = heroesMP.get(heroName); //mp на героя
                if (currentMP >= mpNeeded) {
                    int mpLeft = currentMP - mpNeeded;
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, mpLeft);
                    heroesMP.put(heroName, mpLeft);//намаляме стойността на MP
                } else {
                    System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                }
            } else if (command.contains("TakeDamage")) {
                String heroName = command.split("\\s+-\\s+")[1]; //герой
                int damage = Integer.parseInt(command.split("\\s+-\\s+")[2]); // отнети точни
                String attacker = command.split("\\s+-\\s+")[3];

                int currentHP = heroesHP.get(heroName);
                currentHP -= damage;

                //проверка дали е жив след атаката
                if (currentHP > 0) {
                    //жив
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, currentHP);
                    heroesHP.put(heroName, currentHP);
                } else {
                    System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    heroesHP.remove(heroName);
                    heroesMP.remove(heroName);
                }
            } else if (command.contains("Recharge")) {
                String heroName = command.split("\\s+-\\s+")[1];
                int amount = Integer.parseInt(command.split("\\s+-\\s+")[2]);
                int currentMp = heroesMP.get(heroName);
                currentMp += amount;

                if (currentMp > 200) {
                    currentMp = 200;
                }
                System.out.printf("%s recharged for %d MP!%n", heroName, currentMp - heroesMP.get(heroName)  );
                heroesMP.put(heroName, currentMp);
            } else if (command.contains("Heal")) {
                String heroName = command.split("\\s+-\\s+")[1];
                int amount = Integer.parseInt(command.split("\\s+-\\s+")[2]);

                int currentHP = heroesHP.get(heroName);
                //възстановява;
                currentHP += amount;
                if (currentHP > 100) {
                    currentHP = 100;
                }
                System.out.printf("%s healed for %d HP!%n", heroName, currentHP - heroesHP.get(heroName));
                heroesHP.put(heroName, currentHP);
            }


            command = scanner.nextLine();
        }
        heroesHP.entrySet() //име на героя -> hp
                .forEach(entry ->{ //за всеки един запис
                    System.out.println(entry.getKey());
                    System.out.println("  HP: "+entry.getValue());
                    System.out.println("  MP: " + heroesMP.get(entry.getKey()));
                });
    }
}
