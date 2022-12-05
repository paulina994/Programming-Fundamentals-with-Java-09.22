package Fundamentals.EX.TextProcessing;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();
        String[] pathParts = path.split("\\\\");
        String fullFileName = pathParts[pathParts.length - 1];
        String fileName = fullFileName.split("\\.")[0];
        String extension = fullFileName.split("\\.")[1];

        //String fileName = path.substring(path.lastIndexOf("\\" +1, path.indexOf(".")));
        //String fileExtension = path.substring(path.indexOf("."));

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);

    }
}
