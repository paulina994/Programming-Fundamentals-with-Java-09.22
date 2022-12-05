package Fundamentals.LAB.TextProcessing;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] banWordsArr = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String banWord : banWordsArr) {
            text = text.replace(banWord, repeatString("*", banWord.length()));


        }
        System.out.println(text);
    }
    public  static String repeatString(String s, int count){
        String result = ""; //StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result += s; //sb.append(s)
        }
        return result; // return sb.toString
    }
}
