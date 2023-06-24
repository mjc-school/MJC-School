package org.example.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileManager {

    //fix suppressed exceptions with .addSuppressed method
//    public void readInformation(String filePath) throws IOException {
//        Throwable throwable = null;
//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream(filePath);
//            System.out.println(fileInputStream.read());
//        } catch (FileNotFoundException e) {
//            throwable = e;
//        } finally {
//            try {
//                fileInputStream.close();
//            } catch (NullPointerException e) {
//                if (throwable != null) {
//                    e.addSuppressed(throwable);
//                }
//                throw e;
//            }
//        }
//    }

    //method that suppresses IOException and only logs NullPointerException
//    public void readInformation(String filePath) throws IOException {
//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream(filePath);
//            System.out.println("fileInputStream was created successfully!");
//        } catch (FileNotFoundException e) {
//            throw new IOException();
//        } finally {
//            fileInputStream.close();
//        }
//    }
}
