import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        long count = gcd(A, B);  

        // count만큼 "1" 반복
        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < count; i++) {
            sb.append("1");
        }
        System.out.println(sb);
    }

    // 최대공약수 구하기 
    public static long gcd(long A, long B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }
}
