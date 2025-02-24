import java.util.ArrayList;
import java.util.Collections;
public class Task10 {
    public static void main(String[] args) {
        ArrayList<String> animals = new ArrayList<>();
        animals.add("Lion");
        animals.add("Tiger");
        animals.add("Elephant");
        animals.add("Giraffe");
        Collections.shuffle(animals);
        System.out.println("Shuffled animals list: " + animals);
    }
}
