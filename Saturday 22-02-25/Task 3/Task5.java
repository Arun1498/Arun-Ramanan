import java.io.File;

public class Task5 {
    public static void main(String[] args) {
        String path1 = "C:/Users/user/Desktop/TM Training/Saturday 22-02-25";
        String path = "C:/Users/user/Desktop/TM Training/Saturday 22-02-25/Task3/Task1.java";
        File fileOrDirectory = new File(path);
        if (fileOrDirectory.exists()) {
            if (fileOrDirectory.isDirectory()) {
                System.out.println("The File Path mentioned Above is Directory");
            }
            if (fileOrDirectory.isFile()) {
                System.out.println("The File Path mentioned Above is A File!");
            }
        } else {
            System.out.println("No Directory Exists");
        }
    }
}
