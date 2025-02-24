import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Task11 {
    public static void main(String[] args) {
        String path = "C:\\Users\\user\\Desktop\\TM Training\\Saturday 22-02-25\\Task3\\Text.txt";
        try {
            List<String> lineList = Files.readAllLines(Paths.get(path));
            System.out.println("File content:");
            for (String line : lineList) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
