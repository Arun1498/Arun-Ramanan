import java.util.LinkedList;
public class Task13 {
    public static void main(String[] args) {
        LinkedList<String> books = new LinkedList<>();
        books.add("Harry Potter");
        books.add("The Hobbit");
        books.add("1984");
        books.add("The Lord of the Rings");
        int startIndex = 2;
        System.out.println("Books from index " + startIndex + ":");
        for (int i = startIndex; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }
}
