package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Integer, List<String>> listMap = new HashMap<>();
        listMap.put(2, List.of(null, null, "dvf"));
        List<String> strings = listMap.get(2);
        for (String string : strings) {
            if(string != null)
                string.hashCode();
            try(Scanner scanner = new Scanner(new File("test.txt"))) {
                while (scanner.hasNext()) {
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
