package org.example.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerManager {
    public void scanFile(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/main/java/org/example/test.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    //same code with try-with-resources
//    public void scanFile(){
//        try (Scanner scanner = new Scanner(new File("src/main/java/org/example/test.txt"))){
//            while (scanner.hasNext()) {
//                System.out.println(scanner.nextLine());
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
}
