import java.util.*;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean visited[];
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        int M = sc.nextInt(); 
        int V = sc.nextInt(); 

        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        // // 연결 리스트에 양방향 데이터 삽입 
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);
        }

        // 정점 번호가 작은 순으로 방문하도록 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        // DFS
        visited = new boolean[N + 1];
        DFS(V);

        // BFS
        visited = new boolean[N + 1];
        System.out.println();
        queue.add(V);
        visited[V] = true;
        BFS(queue.poll()); 
    }

    // DFS (재귀)
    public static void DFS(int n) {
        if (visited[n]) return;

        System.out.print(n + " ");
        visited[n] = true;

        for (int i : A[n]) {
            if (!visited[i]) DFS(i);
        }
    }

    // BFS (재귀)
    public static void BFS(Integer n) {
        if (n == null) return;

        System.out.print(n + " ");

        for (int i : A[n]) {
            if (!visited[i]) {
                queue.add(i);
                visited[i] = true;
            }
        }

        BFS(queue.poll());
    }
}
