import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        String path = "C:\\Users\\user\\Desktop\\TM Training\\Saturday 22-02-25\\Task4\\NumberFile.txt"; 
        try {
            ReadNoFromFile(path);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (PositiveNoException e) { 
            System.out.println(e.getMessage());
        }
    }

    public static void ReadNoFromFile(String path) throws FileNotFoundException, PositiveNoException {
        File file = new File(path);
        Scanner scan = new Scanner(file);

        
        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                int number = scan.nextInt();
                if (number > 0) { 
                    throw new PositiveNoException("The file contains positive numbers: " + number);
                }
            } else {
                scan.next(); 
            }
        }
        scan.close();
        System.out.println("No positive numbers found in the file.");
    }
}


class PositiveNoException extends Exception {
    PositiveNoException(String msg) {
        super(msg);
    }
}
