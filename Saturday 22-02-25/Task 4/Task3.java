import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        String path = "C:\Users\user\Desktop\TM Training\Saturday 22-02-25\\Task3\\Text.txt";
        try {
            FileRead(path);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void FileRead(String path) throws FileNotFoundException {
        File file = new File(path);

        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
        scan.close();
    }
}
