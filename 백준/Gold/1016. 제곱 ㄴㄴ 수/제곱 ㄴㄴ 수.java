import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();     
        long max = sc.nextLong();

        int size = (int)(max - min + 1);
        boolean[] A = new boolean[size];
        Arrays.fill(A, true); 
        
        // 제곱ㄴㄴ수가 아닌 것은 false로 변경 
        for(long i=2; i*i<=max; i++) {
            long square = i*i;
            long start = ((min+square-1) / square)*square;

            for (long j=start; j<=max; j+=square) {
                // A 배열은 0부터 시작 
                A[(int)(j - min)] = false;
            }
        }

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (A[i]) count++;
        }

        System.out.println(count);
    }
}
