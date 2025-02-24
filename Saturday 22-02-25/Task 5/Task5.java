import java.util.Scanner;
public class Task5 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new scanner(System.in);
        System.out.print("Enter the limit: ");
        int limit = sc.nextInt();
        int numthrds = 4;
        PrimeSumthrd[] thrds = new PrimeSumthrd[numthrds];
        int range = limit / numthrds;
        int start = 2;
        for (int i = 0; i < numthrds; i++) {
            int end = (i == numthrds - 1) ? limit : start + range - 1;
            thrds[i] = new PrimeSumthrd(start, end);
            thrds[i].start();
            start = end + 1;
        }
        int totalSum = 0;
        for (PrimeSumthrd thrd : thrds) {
            thrd.join();
            totalSum += thrd.getSum();
        }
        System.out.println("Sum of prime numbers up to " + limit + " is: " + totalSum);
    }
}
class PrimeSumthrd extends thrd {
    private final int start, end;
    private int sum = 0;
    public PrimeSumthrd(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
    }
    public int getSum() {
        return sum;
    }
    private boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
