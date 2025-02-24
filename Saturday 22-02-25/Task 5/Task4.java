import java.util.Arrays;
public class Task4 {
    public static void main(String[] args) throws InterruptedException {
        int[][] A = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int[][] B = {
                { 9, 8, 7 },
                { 6, 5, 4 },
                { 3, 2, 1 }
        };
        int[][] res = new int[A.length][B[0].length];
        Thread[] threads = new Thread[A.length];
        for (int i = 0; i < A.length; i++) {
            threads[i] = new Thread(new MatrixMulTask(A, B, res, i));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("resant Matrix:");
        for (int[] row : res) {
            System.out.println(Arrays.toString(row));
        }
    }
}
class MatrixMulTask implements Runnable {
    private final int[][] A, B, res;
    private final int row;
    public MatrixMulTask(int[][] A, int[][] B, int[][] res, int row) {
        this.A = A;
        this.B = B;
        this.res = res;
        this.row = row;
    }
    @Override
    public void run() {
        for (int j = 0; j < B[0].length; j++) {
            res[row][j] = 0;
            for (int k = 0; k < A[0].length; k++) {
                res[row][j] += A[row][k] * B[k][j];
            }
        }
    }
}
