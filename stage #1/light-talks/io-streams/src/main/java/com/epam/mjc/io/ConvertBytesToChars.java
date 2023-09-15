package main.java.com.epam.mjc.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ConvertBytesToChars {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fis = new FileInputStream("demo.xml");
             Reader r = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(r)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        }
        
    }
}
