import java.util.*;
import java.io.*;

public class Main {

    static int[] num;
    static int[] oper;
    static int N;
    static int max = -Integer.MAX_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N + 1];
        oper = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num[1], 1);

        System.out.println(max);
        System.out.println(min);
    }
    
    static void dfs(int result, int idx) {
        if (idx == N) {
            if(result > max) max = result;
            if(result < min) min = result;
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                if(oper[i] <= 0) continue;
                else {
                    oper[i]--;
                    switch (i) {
                        case 0:
                            dfs(result + num[idx + 1], idx + 1);
                            break;
                        case 1:
                            dfs(result - num[idx + 1], idx + 1);
                            break;
                        case 2:
                            dfs(result * num[idx + 1], idx + 1);
                            break;
                        case 3:
                            dfs(result / num[idx + 1], idx + 1);
                            break;
                        default:
                            break;
                    }
                    oper[i]++;
                }
            }
        }

    }
}
