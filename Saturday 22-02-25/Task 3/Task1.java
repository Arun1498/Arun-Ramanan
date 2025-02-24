import java.io.File;
public class Task1 {
    public static void main(String[] args) {
        String Path = "C:\Users\user\Desktop\TM Training\Saturday 22-02-25";
        File directory = new File(Path);
        if(directory.isDirectory()){
            String[] files = directory.list();
            if(files != null && files.length > 0){
                System.out.println("The Files and Directory present in this path \""+Path+"\" are : ");
                for(String file : files){
                    System.out.println(file);
                }
            }else{
                System.out.println("The Directory is Empty !!!");
            }
        }else{
            System.out.println("The given path is not a directory.");
        }
    }
}
