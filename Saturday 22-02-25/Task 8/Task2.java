import CRUDoperations.Jdbccontrol;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Task2{
    static String url = "jdbc:mysql://localhost:3306/abcd";
    static String username = "root";
    static String password = "Arun@123";
    static Scanner in = new Scanner(System.in);
    public static void updateRecordWithPreparedStatement(int id, String address) throws SQLException {
        String query = "update Persons set Address=? where PersonID=?;";
        Connection connect = DriverManager.
                getConnection(url, username, password);
        PreparedStatement pst = connect.prepareStatement(query);
        pst.setString(1, address);
        pst.setInt(2, id);
        System.out.println("Number of rows affected:"
                + pst.executeUpdate());
        connect.close();
    }

    public static void main(String[] args) throws SQLException {
        System.out.println("Enter the id");
        int id=in.nextInt();
        System.out.println("Enter the address");
        String address=in.next();
        updateRecordWithPreparedStatement(id,address);

    }
}
