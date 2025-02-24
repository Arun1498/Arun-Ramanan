import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Task1{
    static String url = "jdbc:mysql://localhost:3306/abcd";
    static String username = "root";
    static String password = "Arun@123";
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
            Object[][] data = {
                    {1, "John", "Doe", "123 Street", "CityA"},
                    {2, "Jane", "Doe", "456 Avenue", "CityB"},
                    {3, "Alice", "Smith", "789 Road", "CityC"}
            };
            insertRows(data);
        }

    public static void insertRows(Object[][] data) throws SQLException
    {
        Connection connect = DriverManager.getConnection(url, username, password);
        String query = "INSERT INTO persons VALUES (?, ?, ?, ?, ?);";

        try (PreparedStatement pstmt = connect.prepareStatement(query)) {
            for (int i=0;i< data.length;i++) {
                pstmt.setInt(1, (int) data[i][0]);
                pstmt.setString(2, (String) data[i][1]);
                pstmt.setString(3, (String) data[i][2]);
                pstmt.setString(4, (String) data[i][3]);
                pstmt.setString(5, (String) data[i][4]);

                System.out.println("Number of rows affected: " + pstmt.executeUpdate());
            }
        }
    }
}
