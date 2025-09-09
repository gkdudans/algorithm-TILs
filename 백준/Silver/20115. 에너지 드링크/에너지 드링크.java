import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] drink = new int[N];
        double max = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            drink[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(drink);
        max = drink[0] / 2.0 + drink[N-1];

        for (int i = 1; i < N - 1; i++) {
            max = Math.max(max / 2.0 + drink[i], max + (drink[i] / 2.0));
        }

        System.out.println(max);
    } 
}
