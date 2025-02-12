package bbb;
public class MultiThread3 {
    public static void main(String[] args) {
        ATask3Thread3 AT1=new ATask3Thread3();
        ATask3Thread3 AT2=new ATask3Thread3();
        ATask3Thread3 AT3=new ATask3Thread3();
        AT1.start();
        AT2.start();
        AT3.start();
    }
}
class ATask3Thread3 extends Thread {
    @Override
    public void run() {
        System.out.println("From ATask3Thread3");
        System.out.println("From ATask3Thread3");
        System.out.println("From ATask3Thread3");
        System.out.println("From ATask3Thread3");
        System.out.println("From ATask3Thread3");


    }
}

