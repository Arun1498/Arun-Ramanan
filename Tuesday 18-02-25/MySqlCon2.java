import java.sql.*;
import java.util.Scanner;

public class MySqlCon2 {
    static Scanner sc=new Scanner(System.in);
    static String url = "jdbc:mysql://localhost:3306/shopping";
    static String username = "root";
    static String password = "Arun@123";

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String action = "";
        while (!action.equals("Exit")) {
            System.out.println("------------------------------------------");
            System.out.println("Menu");
            System.out.println("Enter Choice:\n 1)Insert\n 2)Display\n 3)Update\n 4)Delete\n Exit\n");
            action = sc.nextLine();

            switch (action) {
                case "Insert":
                    Insert();
                    break;
                case "Display":
                    Select();
                    break;
                case "Update":
                    System.out.println("Enter id:");
                    int id = sc.nextInt();
                    System.out.println("Enter Price:");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    Update(id, price);
                    break;
                case "Delete":
                    System.out.println("Enter id to be deleted:");
                    int id1 = sc.nextInt();
                    sc.nextLine(); // Consume the newline character
                    Delete(id1);
                    System.out.println("Id deleted successfully.");
                    break;
                case "Exit":
                    System.out.println("Exited Successfully");
                    break;
                default:
                    System.out.println("Invalid action. Please choose a valid option.");
            }
        }
    }

    public static void Insert() throws SQLException {
        String query = "INSERT INTO product  VALUES (?,?, ?, ?);";
        System.out.println("Product Id:");
        int id=sc.nextInt();
        System.out.println("Product Name:");
        sc.nextLine();
        String name=sc.nextLine();
        System.out.println("Product Price:");
        int price=sc.nextInt();
        System.out.println("Product Quantity:");
        int quantity=sc.nextInt();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement stmt = connection.createStatement()) {
            PreparedStatement pst=connection.prepareStatement(query);
            pst.setInt(1,id);
            pst.setString(2,name);
            pst.setInt(3,price);
            pst.setInt(4,quantity);
            pst.executeUpdate();

        }
    }

    public static void Select() throws SQLException {
        String query = "SELECT id, name, price, quantity FROM product";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", Price: " + rs.getDouble("price") + ", Quantity: " + rs.getInt("quantity"));
            }
        }
    }
    public static void Update(int id, double price) throws SQLException {
        System.out.println("Enter price and id");
        String query = "UPDATE product SET price = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setDouble(1, price);
            pst.setInt(2, id);
            pst.executeUpdate();
        }
    }

    public static void Delete(int id) throws SQLException {
        String query = "DELETE FROM product WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }
}
