import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Any Number  :");
        int num = scan.nextInt();
        try{
            CheckOddNo(num);
            System.out.println("The Number is Even");
        }catch(OddNoException e){
            System.out.println(e.getMessage());
        }
    }
    public static void CheckOddNo(int num) throws OddNoException{
        if(num % 2 != 0){
            throw new OddNoException("The Given Number "+num+" is OddNumber");
        }
    }
}
class OddNoException extends Exception{
    OddNoException(String msg){
        super(msg);
    }
}
