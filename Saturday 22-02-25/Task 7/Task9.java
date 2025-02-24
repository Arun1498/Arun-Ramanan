import java.util.ArrayList;
import java.util.Collections;
public class Task9 {
    public static void main(String[] args) {
        ArrayList<String> movies = new ArrayList<>();
        movies.add("Despicable Me");
        movies.add("Incredibles");
        movies.add("Kung Fu Panda");
        ArrayList<String> copiedMovies = new ArrayList<>(movies);
        System.out.println("Original movies list: " + movies);
        System.out.println("Copied movies list: " + copiedMovies);
    }
}
