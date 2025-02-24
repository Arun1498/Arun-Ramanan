import java.util.ArrayList;
public class Task5 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.set(1, 50); 
        System.out.println("Updated numbers list: " + numbers);
    }
}
