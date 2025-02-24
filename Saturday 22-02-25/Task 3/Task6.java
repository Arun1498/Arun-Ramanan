import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task6 {
    public static void main(String[] args) {
        String path = "C:/Users/user/Desktop/TM Training/Saturday 22-02-25/Task3/Task1.java";
        File file = new File(path);
        if (file.exists()) {
            long lastModified = file.lastModified();
            String DateandTime = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(new Date(lastModified));
            System.out.println("The Last Modified date of file is " + DateandTime);
        }
    }
}
