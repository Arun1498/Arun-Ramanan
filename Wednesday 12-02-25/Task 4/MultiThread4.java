package bbb;
public class MultiThread4
{
    public static void main(String[] args) {
        ATask4ThreadRunnableOne ATR1=new ATask4ThreadRunnableOne();
        ATR1.start();
    }
}
class ATask4ThreadRunnableOne extends Thread
{
    @Override
    public void run() {
        System.out.println("From ATask4ThreadRunnableOne");
        System.out.println("From ATask4ThreadRunnableOne");
    }
}
