import java.io.File;

public class Task3 {
    public static void main(String[] args) {
        String path = "C:/Users/user/Desktop/TM Training/Saturday 22-02-25";
        File fileOrDirectory = new File(path);
        if (fileOrDirectory.exists()) {
            if (fileOrDirectory.isDirectory()) {
                System.out.println("The path refers to an existing directory.");
            } else if (fileOrDirectory.isFile()) {
                System.out.println("The path refers to an existing file.");
            }
        } else {
            System.out.println("The specified file or directory does not exist.");
        }
    }
}
