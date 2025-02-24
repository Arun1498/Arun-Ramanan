import java.util.LinkedList;
public class Task11 {
    public static void main(String[] args) {
        LinkedList<String> fruits = new LinkedList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.addLast("Mango"); 
        System.out.println("Updated fruits list: " + fruits);
    }
}
