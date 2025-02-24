import java.io.File;
public class Task4 {
    public static void main(String[] args) {
        String path = "C:\Users\user\Desktop\TM Training\Saturday 22-02-25"; 
        File fileOrDirectory = new File(path);
        if (fileOrDirectory.exists()) {
            System.out.println("Read permission: " + (fileOrDirectory.canRead() ? "Yes" : "No"));
            System.out.println("Write permission: " + (fileOrDirectory.canWrite() ? "Yes" : "No"));
        } else {
            System.out.println("The specified file or directory does not exist.");
        }
    }
}
