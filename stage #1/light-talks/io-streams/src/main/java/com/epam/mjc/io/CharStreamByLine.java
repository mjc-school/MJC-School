package main.java.com.epam.mjc.io;

import java.io.*;

public class CharStreamByLine {
    public static void main(String[] args) throws IOException {
        try (BufferedReader inputStream = new BufferedReader(new FileReader("demo1.txt"));
        PrintWriter outputStream = new PrintWriter(new FileWriter("characteroutput.txt"))) {
            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        }
    }
}
