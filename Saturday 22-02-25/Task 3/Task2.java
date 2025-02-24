import java.io.File;
import java.io.FilenameFilter;

public class Task2 {
    public static void main(String[] args) {
        String path = "C:/Users/user/Desktop/TM Training/Saturday 22-02-25";
        String extension = ".pdf";
        File directory = new File(path);
        if (directory.isDirectory()) {
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(extension);
                }
            };
            String[] files = directory.list(filter);
            if (files != null && files.length > 0) {
                System.out.println("The Files with extension \"" + extension + "\" present in this path \"" + path + "\" are:");
                for (String file : files) {
                    System.out.println(file);
                }
            } else {
                System.out.println("No files with '" + extension + "' extension found.");
            }
        } else {
            System.out.println("The given path is not a directory.");
        }
    }
}
