import java.sql.*;
import java.util.Scanner;
public class Task3 {
    static String url = "jdbc:mysql://localhost:3306/abcd";
    static String username = "root";
    static String password = "Arun@123";
    static Scanner in = new Scanner(System.in);
    public static void deleteRecordWithVariables(int id) throws SQLException {
        String DELETE_QUERY = "DELETE FROM persons WHERE PersonID = ?";
        Connection connect = DriverManager.getConnection(url, username, password);
        PreparedStatement pstmt = connect.prepareStatement(DELETE_QUERY);
        System.out.println("Number of rows affected:" + pstmt.executeUpdate());
        connect.close();
    }
    public static void main(String[] args) {
        try {
            deleteRecordWithVariables(2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}