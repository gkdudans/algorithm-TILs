import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();        

        // φ(n) = n - n / p = n × (1 - 1/p) 
        long result = n;               
        
        for(long p=2; p*p<=n; p++) {
            // p가 n의 소인수인 경우
            if(n%p == 0) {
                // 거듭제곱 제거 
                while (n%p == 0) {
                    n /= p;
                }
                // φ 값을 갱신 
                result = result * (p - 1) / p;
            }
        }
        // 마지막으로 남은 n>1인 경우 
        if (n > 1) {
            result = result / n * (n - 1);
        }

        System.out.println(result);
    }
}
