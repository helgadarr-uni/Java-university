package labs.serializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileContent {
    public String fileContent(String fileName) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(fileName));
            StringBuilder sb = new StringBuilder();
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
