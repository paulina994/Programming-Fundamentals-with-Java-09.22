package Fundamentals.EX;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, List<String>> map = new LinkedHashMap<>();
        while (!command.equals("Lumpawaroo")) {
            if (command.contains(" | ")) {
                String group = command.split("\\s+\\|\\s+")[0];
                String user = command.split("\\s+\\|\\s+")[1];

                // 1. дали имаме такава група
                if (!map.containsKey(group)) {
//група -> празен списък
                    map.put(group, new ArrayList<>());
                }
                //2.имаме такава група -> добавяме към групата user, ако го няма в никоя група
                boolean isExistUser = false; //user го има в дадена група
                for (List<String> listUsers : map.values()) {
                    if (listUsers.contains(user)) {
                        //user го има в някоя група
                        isExistUser = true;
                        break;
                    }
                }
                if (!isExistUser) {
                    //няма го в никоя група
                    map.get(group).add(user);
                }
            } else if (command.contains(" -> ")) {
                String user = command.split("\\s+->\\s+")[0];
                String group = command.split("\\s+->\\s+")[1];
                //1. ако дадения user го има в дадена група го премахваме
                //запис: група(key) -> списък с users (value)
                map.entrySet().forEach(entry -> entry.getValue().remove(user));

                //2. проверяваме дали имаме такава група
                if (map.containsKey(group)) {
                    map.get(group).add(user);
                } else {
                    //нямаме такава група, в която иска да отиде -> създаваме
                    map.put(group, new ArrayList<>());
                    map.get(group).add(user);
                }

                System.out.printf("%s joins the %s side!%n", user, group);
            }


            command = scanner.nextLine();
        }
        //запис: група -> списък с user-и
        //1. филтрирам записите -> бр. хората >0
        map.entrySet().stream().filter(entry -> entry.getValue().size() > 0)
                .forEach(entry -> {
                    System.out.printf("Side: %s, Members: %s%n", entry.getKey(), entry.getValue().size());
                    entry.getValue().forEach(user -> System.out.println("! " + user));

                });
        //оставяме само записите, които ми отг на условието
    }
}
