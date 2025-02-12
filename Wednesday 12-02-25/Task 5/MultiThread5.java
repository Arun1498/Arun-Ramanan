package bbb;
public class MultiThread5 {
    public static void main(String[] args) {
        ATask5ThreadRunnableTwo ATR2 =new ATask5ThreadRunnableTwo();
        ATask5ThreadRunnableTwo ATR3 =new ATask5ThreadRunnableTwo();
        ATR2.start();
        ATR3.start();
    }
}
class ATask5ThreadRunnableTwo extends Thread
{
    @Override
    public void run() {
        System.out.println("From ATask5ThreadRunnableTwo");
        System.out.println("From ATask5ThreadRunnableTwo");
        System.out.println("From ATask5ThreadRunnableTwo");

    }
}
