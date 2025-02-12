package bbb;
public class MultiThread {
    public static void main(String[] args) {
        ATask1Thread1 obj= new ATask1Thread1();
    obj.start();
    }
}

class ATask1Thread1 extends Thread{
    public void run(){
        System.out.println("From ATask1Thread1");
        System.out.println("From ATask1Thread1");
        System.out.println("From ATask1Thread1");
    }


    }
