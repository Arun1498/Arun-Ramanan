import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class Task10 {
    public static void main(String[] args) {
        String path = "C:\Users\user\Desktop\TM Training\Saturday 22-02-25\\Task3\\Text.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line ;
            System.out.println("File Content Read by Line by Line : ");
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
