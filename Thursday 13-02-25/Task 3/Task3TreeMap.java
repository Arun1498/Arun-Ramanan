package Col;

import java.util.TreeMap;
import java.util.Map;

public class Task3TreeMap {
    public static void main(String[] args) {
        // HashMap<Integer, String> hm = new HashMap<>();
        TreeMap<Integer, String> hm = new TreeMap<>();
        hm.put(1, "one");
        hm.put(2, "two");
        hm.put(3, "three");
        System.out.println("Initial HashMap hm1 are : "
                + hm);
        hm.put(2, "For");
        System.out.println("Updated Map " + hm);
        hm.remove(1);
        System.out.println("Mappings after removal are : "
                + hm);
        System.out.println("Map traversal:");

        for (Map.Entry<Integer, String> e : hm.entrySet())
            System.out.println("Key: " + e.getKey()
                    + " Value: " + e.getValue());
    }

}
