import java.util.*;
import java.io.*;

public class Main {
    static boolean[] used = new boolean[10];
    static List<Integer> current = new ArrayList<>();
    static int K;
    static int M;
    static int count = 0;
    static final int MAX = 100000; // 최대 5자리 수
    static boolean[] isPrime = new boolean[MAX + 1];
    static List<Integer> primes = new ArrayList<>();

    static void sieveOfEratosthenes() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= MAX; i++) {
            if (isPrime[i]) primes.add(i);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sieveOfEratosthenes();
        dfs(0);
        System.out.println(count);
    }
    
    static void dfs(int depth) {
        if (depth == K) {
            // 0으로 시작하면 제외 
            if (current.get(0) == 0)
                return;
            int num = 0;
            for (int d : current) {
                num = num * 10 + d;
            }

            if (condition1(num) && condition2(num))
                count++;
            return;
        }

        for (int d = 0; d <= 9; d++) {
            if (!used[d]) {
                used[d] = true;
                current.add(d);
                dfs(depth + 1);
                // dfs + 백트래킹
                current.remove(current.size() - 1);
                used[d] = false;
            }
        }
    }
    
static boolean condition1(int num) {
    for (int p : primes) {
        if (p >= num) break;
        int q = num - p;
        if (q != p && isPrime[q]) {
            return true;
        }
    }
    return false;
}

static boolean condition2(int num) {
    while (num % M == 0) {
        num /= M;
    }
    for (int p : primes) {
        if (p > num) break;
        if (num % p == 0) {
            int q = num / p;
            if (isPrime[q]) {
                return true;
            }
        }
    }
    return false;
}

}
