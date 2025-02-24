public class Task1 extends Thread{
    public static void main(String[] args) {
        Task1 T1 = new Task1();
        T1.start();
    }
    @Override
    public void run(){
        System.out.println("Hello, Java!");
    }
}
