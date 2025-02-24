import java.util.ArrayList;
public class Task6 {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");
        fruits.add("Raspberry");
        fruits.remove(3);
        System.out.println("Updated fruits list: " + fruits);
    }
}
