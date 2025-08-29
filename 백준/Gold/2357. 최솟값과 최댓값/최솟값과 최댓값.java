import java.util.*;
import java.io.*;

public class Main {
    static int[] maxTree;
    static int[] minTree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 세그먼트 트리 구현
        int h = (int) Math.ceil(Math.log(N) / Math.log(2)); // h = ⌈log₂ N⌉
        int base = (int) Math.pow(2, h); // 리프 시작 인덱스
        int size = base * 2; // 세그트리 크기 (리프 포함)
        maxTree = new int[size];
        minTree = new int[size];

        // 리프 노드에 N개의 정수 채우기
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            maxTree[base + i - 1] = num; 
            minTree[base + i - 1] = num;
        }

        // 트리 채우기(bottom-up)
        for (int i = base - 1; i > 0; i--) {
            maxTree[i] = Math.max(maxTree[i * 2], maxTree[i * 2 + 1]);
            // minTree는 0 초기값이 섞이지 않도록 주의
            if (minTree[i * 2] == 0) minTree[i] = minTree[i * 2 + 1];
            else if (minTree[i * 2 + 1] == 0) minTree[i] = minTree[i * 2];
            else minTree[i] = Math.min(minTree[i * 2], minTree[i * 2 + 1]);
        }

        // 결과 출력용 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 구간 쿼리 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int max = findMax(base + a - 1, base + b - 1); 
            int min = findMin(base + a - 1, base + b - 1); 
            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }

    static int findMax(int start, int end) {
        int max = Integer.MIN_VALUE;
        while (start <= end) {
            if (start % 2 == 1) {
                max = Math.max(max, maxTree[start]);
                start++;
            }
            if (end % 2 == 0) {
                max = Math.max(max, maxTree[end]);
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return max;
    }

    static int findMin(int start, int end) {
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            if (start % 2 == 1) {
                if (minTree[start] != 0) // 공백 노드 방지
                    min = Math.min(min, minTree[start]);
                start++;
            }
            if (end % 2 == 0) {
                if (minTree[end] != 0)
                    min = Math.min(min, minTree[end]);
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return min;
    }
}
