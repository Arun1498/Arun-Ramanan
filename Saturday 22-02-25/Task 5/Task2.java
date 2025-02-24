public class Task2 {
    public static void main(String[] args) {
        Thread evenNo = new Thread(new EvenNo());
        Thread oddNo = new Thread(new OddNo());
        evenNo.start();
        oddNo.start();
    }
}
class OddNo implements Runnable{
    @Override
    public void run(){
        for(int i = 1 ; i <= 20 ; i += 2){
            System.out.println("Odd No "+i);
        }
    }
}
class EvenNo implements Runnable{
    @Override
    public void run(){
        for(int i = 2 ; i <= 20 ; i += 2){
            System.out.println("Even No "+i);
        }
    }
}
