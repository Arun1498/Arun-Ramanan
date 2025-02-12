package bbb;

public class MultiThread2 {
    public static void main(String[] args) {
        ATask1Thread2 obj=new ATask1Thread2();
        ATask1Thread2 obj1=new ATask1Thread2();
        obj.start();
        obj1.start();
        obj.run();
    }
}
class ATask1Thread2 extends Thread {
    public void run() {
        System.out.println("From ATask1Thread2");
        System.out.println("From ATask1Thread2");
        System.out.println(10 / 0);
    }
}
