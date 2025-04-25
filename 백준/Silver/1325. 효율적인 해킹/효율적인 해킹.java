import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] A;
    static int N, M;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // 입력 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        result = new int[N + 1];

        // 인접 리스트 형태로 신뢰 관계 저장 
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[b].add(a); 
        }
        
        // BFS 수행 
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            result[i] = BFS(i); 
        }

        // 조건을 만족하는 컴퓨터 번호 오름차순 출력 
        int max = Arrays.stream(result).max().getAsInt();
        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                System.out.print(i + " ");
            }
        }
    }
    
    // BFS 수행 
    static int BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : A[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    count++;
                    queue.add(next);
                }
            }
        }
        return count;
    }
}
