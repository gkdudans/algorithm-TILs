import java.io.*;
import java.util.*;

/*
 * "트리의 지름 문제"
 * 임의의 한 점으로부터 가장 멀리 떨어져 있는 점을 구한 뒤,
 * 해당 점을 시작 정점으로 해서 가장 멀리 있는 점을 구한다.
 * 두 점 사이의 거리가 트리의 지름
 */
public class Main {
    static int distance[];
    static boolean visited[];
    static ArrayList<Edge>[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        if (n == 1) {
            System.out.println(0);
            System.exit(0);
        }

        A = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        distance = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<Edge>();
            distance[i] = -Integer.MAX_VALUE;
        }
        
        for (int i = 2; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            // 트리: 양방향 그래프
            A[parent].add(new Edge(child, value));
            A[child].add(new Edge(parent, value)); 
        }
        
        // 1. 임의의 한 점으로부터 가장 멀리 떨어져 있는 점을 구하 
        Queue<Edge> queue = new LinkedList<>();
        queue.add(new Edge(1, 0));
        visited[1] = true;
        distance[1] = 0;
        int maxNum = 0;
        int maxValue = 0;

        while (!queue.isEmpty()) {
            Edge now = queue.poll();

            for (Edge next : A[now.n]) {
                if (visited[next.n])
                    continue;
                else {
                    distance[next.n] = Math.max(distance[next.n], distance[now.n] + next.value);
                    if (distance[next.n] > maxValue) {
                        maxNum = next.n;
                        maxValue = distance[next.n];
                    }
                    visited[next.n] = true;
                    queue.add(next);
                }
            }
        }

        // 2. 해당 점을 시작 정점으로 해서 가장 멀리 있는 점을 구함
        Queue<Edge> nextQueue = new LinkedList<>();
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        maxValue = 0;

        for(int i=1; i<=n; i++) {
            distance[i] = -Integer.MAX_VALUE;
		}

        nextQueue.add(new Edge(maxNum, 0));
        visited[maxNum] = true;
        distance[maxNum] = 0;
        
        while (!nextQueue.isEmpty()) {
            Edge now = nextQueue.poll();

            for (Edge next : A[now.n]) {
                if (visited[next.n])
                    continue;
                else {
                    distance[next.n] = Math.max(distance[next.n], distance[now.n] + next.value);
                    if (distance[next.n] > maxValue) {
                        maxValue = distance[next.n];
                    }
                    visited[next.n] = true;
                    nextQueue.add(next);
                }
            }
        }

        System.out.println(maxValue);
    }

    static class Edge {
        private int n;
        private int value;

        Edge(int n, int value) {
            this.n = n;
            this.value = value;
        }

    }

}
