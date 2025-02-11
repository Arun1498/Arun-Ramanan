package mon;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Methods {
    static void ScannerClass ()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string :");
        String s1 = sc.nextLine();
        System.out.println("Entered string :" + s1);

        System.out.println("Enter integer :");
        int a = sc.nextInt();
        System.out.println("Entered integer: " + a);

        System.out.println("Enter float :");
        float b = sc.nextFloat();
        System.out.println("Entered float: " + b);
    }
    static void BufferReaderClass() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter  input:");
        String str = br.readLine();
        System.out.println("The given input:" + str);
    }

}
