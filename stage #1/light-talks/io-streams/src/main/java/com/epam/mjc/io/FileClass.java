package main.java.com.epam.mjc.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FileClass {
    public static void main(String[] args) {
        String path = "src/main/java/com/epam/mjc/io";
        System.out.println(Arrays.toString(listFiles(path, null)));
        FilenameFilter filter = (dir, name) -> name.startsWith("C");
        System.out.println(Arrays.toString(listFiles(path, filter)));
    }

    public static String[] listFiles(String path, FilenameFilter filter) {
        File file = new File(path);
        if (filter != null) {
            return file.list(filter);
        }
        return file.list();
    }
}
