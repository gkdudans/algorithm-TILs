import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] sum = new int[N+1]; 
        
        st = new StringTokenizer(br.readLine());
        int max = 0;
        int count = 0;
        
        for(int i=1; i<=N; i++) {
            int now = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + now;
            if(i-X >= 0) { 
                if(sum[i] - sum[i-X] > max) {
                    count = 1;
                    max = sum[i] - sum[i-X];
                }
                else if(sum[i] - sum[i-X] == max) {
                    count++;
                }
            }
        }
        
        if(max > 0) {
            System.out.println(max);
            System.out.println(count);
        } else {
            System.out.println("SAD");
        }
    }
}
