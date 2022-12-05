package Fundamentals.LAB.Lists;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.*;
import java.util.stream.Collectors;

public class NumbersProblemDescriptionNOT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        double sum = 0;
        int counter = 0;
        for (int i : numbers) {
            sum += i;
            counter++;
        }
        double averageNumber = sum / counter;

        List<Integer> top5 = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) > averageNumber){
                top5.add(numbers.get(i));
            }
        }
        Collections.sort(top5);
        Collections.reverse(top5);

        if(top5.isEmpty()){
            System.out.println("No");
        }else if(top5.size() >=5 ){
            for (int i = 0; i < 5; i++) {
                System.out.print(top5.get(i) + " ");
            }
        }else{
            for (int item:top5){
                System.out.print(item + " ");
            }
        }
        }
    }
