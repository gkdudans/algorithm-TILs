import java.util.*;
import java.io.*;

public class Main {
    static long[] num;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        num = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(num);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            long target = Long.parseLong(st.nextToken());
            int count = upperBound(target) - lowerBound(target);
            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }

    static int lowerBound(long target) {
        int left = 0;
        int right = num.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (num[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    static int upperBound(long target) {
        int left = 0;
        int right = num.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (num[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
