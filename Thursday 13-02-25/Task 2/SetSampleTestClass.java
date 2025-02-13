package Col;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetSampleTestClass {
    public static void main(String a[]) {
        System.out.println("-------------------------------------");
        HashSet<Integer> hs = new HashSet<>();
        setSample(hs);
        System.out.println("-------------------------------------");
        LinkedHashSet<String> hsl = new LinkedHashSet<>();
        setSample(hsl);
        System.out.println("-------------------------------------");
        TreeSet<Double> hst = new TreeSet<>();
        setSample(hst);
        System.out.println("-------------------------------------");
    }

    public static void setSample(HashSet<Integer> hs) {
        hs.add(10);
        hs.add(20);
        hs.add(15);
        hs.add(5);
        hs.add(25);
        hs.add(30);
        hs.add(35);
        hs.add(40);
        System.out.println("HashSet Size: " + hs.size());
        System.out.println("Elements in HashSet: " + hs);
        System.out.print("Using iterator: ");
        Iterator<Integer> iterator = hs.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.print("Using enhanced for loop: ");
        for (Integer element : hs) {
            System.out.print(element + " ");
        }
        hs.remove(5);
        System.out.println("\nHashSet after removing element: " + hs);
        System.out.print("Elements divisible by 7: ");
        for (Integer element : hs) {
            if (element % 7 == 0) {
                System.out.print(element + " ");
            }
        }
        System.out.println("\nFinal HashSet: " + hs);
    }
    public static void setSample(LinkedHashSet<String> hsl) {
        hsl.add("Bheem");
        hsl.add("Amudesh");
        hsl.add("Gowtham");
        hsl.add("Arun");
        hsl.add("Ravitej");
        hsl.add("Harihar");
        hsl.add("Dhoni");
        hsl.add("Kohli");
        System.out.println("\nLinkedHashSet Size: " + hsl.size());
        System.out.println("Elements in LinkedHashSet: " + hsl);
        System.out.print("Using iterator: ");
        Iterator<String> iterator = hsl.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.print("Using enhanced for loop: ");
        for (String element : hsl) {
            System.out.print(element + " ");
        }
        hsl.remove("Ravitej");
        System.out.println("\nLinkedHashSet after removing element: " + hsl);
        System.out.print("Elements with length greater than 5: ");
        for (String element : hsl) {
            if (element.length() > 5) {
                System.out.print(element + " ");
            }
        }
        System.out.println("\nFinal LinkedHashSet: " + hsl);
    }
    public static void setSample(TreeSet<Double> hst) {
        hst.add(10.5);
        hst.add(20.7);
        hst.add(15.3);
        hst.add(5.8);
        hst.add(25.2);
        hst.add(30.6);
        hst.add(35.1);
        hst.add(40.9);
        System.out.println("\nTreeSet Size: " + hst.size());
        System.out.println("Elements in TreeSet: " + hst);
        System.out.print("Using iterator: ");
        Iterator<Double> iterator = hst.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.print("Using enhanced for loop: ");
        for (Double element : hst) {
            System.out.print(element + " ");
        }
        hst.remove(35.1);
        System.out.println("\nTreeSet after removing element: " + hst);
        System.out.print("Elements greater than 20.0: ");
        for (Double element : hst) {
            if (element > 20.0) {
                System.out.print(element + " ");
            }
        }
        System.out.println("\nFinal TreeSet: " + hst);
    }
}
