import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] A;
    static int[] indegree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        A = new ArrayList[N + 1];
        indegree = new int[N + 1];
        
        for (int i = 0; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            indegree[b]++;
        }

        // 위상 정렬: '순서가 정해져 있는 작업'을 차례로 수행
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 진입 차수가 0인 정점을 큐에 삽입
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            // 큐에서 원소를 꺼내 연결된 모든 간선을 제거
            int now = queue.poll();
            System.out.print(now + " ");

            for (int j = 0; j < A[now].size(); j++) {
                int next = A[now].get(j);
                indegree[next]--;
                // 간선 제거 이후 진입차수가 0이 된 정점 큐에 삽입 
                if (indegree[next] == 0)
                    queue.add(next);
            }
        }
    }
    
}
