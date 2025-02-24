import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Task4 {
    public static void main(String[] args) {
        String path = "C:\Users\user\Desktop\TM Training\Saturday 22-02-25\\Task4\\NumberFile.txt";
        try {
            ReadNoFromFile(path);
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (PostiveNoException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void ReadNoFromFile(String path) throws FileNotFoundException, PostiveNoException{
        File file = new File(path);
        Scanner scan = new Scanner(file);
            while(scan.hasNext()){
                if(scan.hasNextInt()){
                    if(scan.nextInt() > 0){
                        throw new PostiveNoException("The File have postive Nos ");
                    }
                }else{
                    scan.next();
                }
            }

    }
}
class PostiveNoException extends Exception{
    PostiveNoException(String msg){
        super(msg);
    }
}
