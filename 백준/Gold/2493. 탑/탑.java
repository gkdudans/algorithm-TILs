import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Tower> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());

            // 현재 탑보다 낮은 탑들은 신호 수신 불가 → stack에서 제거
            while (!stack.isEmpty() && stack.peek().height <= height) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek().index; 
            } else {
                result[i] = 0; 
            }
            stack.push(new Tower(height, i + 1)); // 1-based
        }

        StringBuilder sb = new StringBuilder();
        for (int x : result) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }

    static class Tower {
        int height;
        int index; 

        Tower(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
}
