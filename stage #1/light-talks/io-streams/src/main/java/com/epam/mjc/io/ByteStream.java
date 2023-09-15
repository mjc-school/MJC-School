package main.java.com.epam.mjc.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {
    public static void main(String[] args) throws IOException {

        try (FileInputStream in = new FileInputStream("demo1.txt");
             FileOutputStream out = new FileOutputStream("outagain.txt")) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }
    }
}
