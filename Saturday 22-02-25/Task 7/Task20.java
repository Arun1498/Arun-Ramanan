import java.util.LinkedList;
public class Task20 {
    public static void main(String[] args) {
        LinkedList<String> flowers = new LinkedList<>();
        flowers.add("Rose");
        flowers.add("Lily");
        flowers.add("Tulip");
        flowers.add("Rose");
        int firstOccurrence = flowers.indexOf("Rose");
        int lastOccurrence = flowers.lastIndexOf("Rose");
        System.out.println("First occurrence of 'Rose': " + firstOccurrence);
        System.out.println("Last occurrence of 'Rose': " + lastOccurrence);
    }
}
