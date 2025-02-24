import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
public class Menu {
    static String url = "jdbc:mysql://localhost:3306/abcd";
    static String username = "root";
    static String password = "Arun@123";
    static Scanner in = new Scanner(System.in);
 public static void menu()
 {
     System.out.println();
     System.out.println("-------Menu---------");
     System.out.println("1. Insert a new Row ");
     System.out.println("2. Update a Row");
     System.out.println("3. Delete a Row");
     System.out.println("4. Select the row");
     System.out.println("5. Exit");
 }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int ch=0;
        while (ch!=5)
        {
            menu();
            System.out.println("Enter the choice");
            ch=sc.nextInt();
            try {
                Connection connect = DriverManager.getConnection(url, username, password);
                switch (ch) {
                    case 1: {
                        Query.insertRow(connect);
                        break;
                    }
                    case 2: {
                        Query.updateRow(connect);
                        break;
                    }
                    case 3: {
                        Query.deleteRow(connect);
                        break;
                    }
                    case 4: {
                        Query.selectRow(connect);
                        break;
                    }
                    case 5: {
                        System.out.println("Exit success");
                        break;
                    }
                    default:
                        System.out.println("Invalid choice");

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
