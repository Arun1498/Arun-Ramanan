import java.util.LinkedList;
public class Task16 {
    public static void main(String[] args) {
        LinkedList<String> languages = new LinkedList<>();
        languages.add("Python");
        languages.add("JavaScript");
        languages.addFirst("Java"); 
        languages.addLast("C++");
        System.out.println("Updated languages list: " + languages);
    }
}
