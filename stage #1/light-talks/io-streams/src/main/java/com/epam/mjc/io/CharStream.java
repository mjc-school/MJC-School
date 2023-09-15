package main.java.com.epam.mjc.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStream {
    public static void main(String[] args) throws IOException {
        try (FileWriter outputStream = new FileWriter("characteroutput.txt");
             FileReader inputStream = new FileReader("demo1.txt")) {
            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        }
    }
}
