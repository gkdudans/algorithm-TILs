import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Set<Integer> startNumSet = new HashSet<>();
    static int[][] S;
    static boolean[] pick;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = new int[N + 1][N + 1];
        pick = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        pick[1] = true;
        combination(2, 1);
        System.out.println(min);
    }

    // count는 start 팀의 인원 수 
    static void combination(int idx, int count) {
        // 종료 시점에 누적 합 계산 
        if (count == N / 2) {
            int startSum = 0;
            int linkSum = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    if (pick[i] && pick[j]) {
                        startSum += S[i][j] + S[j][i];
                    } else if (!pick[i] && !pick[j]) {
                        linkSum += S[i][j] + S[j][i];
                    }
                }
            }
            min = Math.min(min, Math.abs(startSum - linkSum));
            return;
        }
        
        if (idx > N)
            return;

        // idx가 스타트 팀에 들어가는 경우
        pick[idx] = true;
        combination(idx + 1, count + 1);

        // idx가 링크 팀에 들어가는 경우 
        pick[idx] = false; 
        combination(idx + 1, count);
    }
}
