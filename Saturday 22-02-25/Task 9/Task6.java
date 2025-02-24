import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Task6 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "apple", "cherry", "apricot", "blueberry");
        List<String> ascending = words.stream()
                .sorted()
                .collect(Collectors.toList());
        List<String> descending = words.stream()
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.toList());
        System.out.println("Ascending: " + ascending);
        System.out.println("Descending: " + descending);
    }
}
