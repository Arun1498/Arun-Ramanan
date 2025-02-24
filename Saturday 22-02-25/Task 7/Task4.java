import java.util.ArrayList;
public class Task4 {
    public static void main(String[] args) {
        ArrayList<String> carBrands = new ArrayList<>();
        carBrands.add("Maserati");
        carBrands.add("Lexus");
        carBrands.add("Acura");
        int index = 2;
        String brand = carBrands.get(index);
        System.out.println("Element at index " + index + ": " + brand);
    }
}
