package Col;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class CollectionTask1 {
    public static void main(String[] args) {
        Arraylist arrayListThread = new Arraylist();
        Stacklist stackListThread = new Stacklist();
        Linkedlist linkedListThread = new Linkedlist();
        Vectorlist vectorListThread = new Vectorlist();
        arrayListThread.start();
        stackListThread.start();
        linkedListThread.start();
        vectorListThread.start();
    }
}
class Listmtd {
    public static void listdsp(List list1) {
        list1.add(35);
        list1.add(23);
        list1.add(67);
        list1.add(82);
        list1.add(56);
        list1.add(49);
        list1.add(49);
        list1.add(49);
        //System.out.println("Is list1 empty? "+list1.isEmpty());
        //  System.out.println("The given list is:"+list1);
        System.out.println("Number of elements in the list: " + list1.size());
        //Adding one element
        list1.add(12);
        System.out.println("After adding one element:");
        System.out.println("The given list is :" + list1);
        System.out.println("The number of elements in the list: " + list1.size());
//Checking for an element
        System.out.println("Is 566 available in the list:" + list1.contains(566));
        System.out.println("The given list before removing elements is :" + list1);
        list1.remove(2);//Removing element by its index
        list1.remove(3);//Removing element by its index
        System.out.println("After removing elements:");
        System.out.println("The given list is :" + list1);
        System.out.println("The number of elements in the list: " + list1.size());
    }
}
class Arraylist extends Thread {
    @Override
    public void run() {
        List<Integer> list = new ArrayList<>();
        Listmtd.listdsp(list);
    }
}
class Linkedlist extends Thread {
    @Override
    public void run() {
        List<Integer> list = new LinkedList<>();
        Listmtd.listdsp(list);
    }
}
class Stacklist extends Thread {
    @Override
    public void run() {
        Listmtd.listdsp(new Stack<Integer>());
    }
}
class Vectorlist extends Thread {
    @Override
    public void run() {
        List<Integer> list = new Vector<>();
        Listmtd.listdsp(list);
    }
}
