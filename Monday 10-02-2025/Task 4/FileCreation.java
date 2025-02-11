package mon;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class FileCreation {
        static Scanner in=new Scanner(System.in);
        public static  String createfolder(String path) {
            System.out.println("Enter the folder name");
            String foldername=in.nextLine();
            File f= new File(path+foldername);
            f.mkdir();
            System.out.println(foldername +" is created");
            return path+foldername;
        }
        public static void createfile(String path) throws IOException{
            System.out.println("Enter the File name");
            String filename=in.nextLine();
            File f= new File(path+ filename);
            f.createNewFile();
            System.out.println(filename+"is Created");
        }
    }
