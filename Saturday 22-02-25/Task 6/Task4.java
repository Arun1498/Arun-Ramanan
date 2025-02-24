import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Task4 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        List<Integer> reversedList = reverseList(list);
        System.out.println("Reversed List : "+reversedList);
        List<String> Cars = List.of("Audi", "Porsche", "Bugatti");
        System.out.println("Reversed List: " + reverseList(Cars));
    }
    public static <T> List<T> reverseList(List<T> list) {
        List<T> reversedList = new ArrayList<>(list);
        Collections.reverse(reversedList);
        return reversedList;
    }
}
