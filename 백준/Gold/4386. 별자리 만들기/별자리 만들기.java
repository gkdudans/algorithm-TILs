import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] x = new double[n], y = new double[n];
        
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Double.parseDouble(st.nextToken());
            y[i] = Double.parseDouble(st.nextToken());
        }
        
        double[][] cost = new double[n][n];
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                double dx = x[i] - x[j];
                double dy = y[i] - y[j];
                double d = Math.hypot(dx, dy);
                cost[i][j] = cost[j][i] = d;
            }
        }

        boolean[] visited = new boolean[n];
        double[] dist = new double[n]; 
        Arrays.fill(dist, Double.MAX_VALUE);
        dist[0] = 0;  

        double total = 0;
        for(int i = 0; i < n; i++) {
            int s = -1;
            double min = Double.MAX_VALUE;
            // 가중치가 가장 작은 간선 선택 
            // MST에 포함되지 않은 정점 중 dist[]가 가장 작은 정점  추가 
            for(int j=0; j<n; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    s = j; 
                }
            }
            visited[s] = true;
            total += min;

            // 외곽 간선 선택 
            // 새로 포함된 s와의 cost[s][j]를 비교하고 최소 업데이트
            for (int j = 0; j < n; j++) {
                if (!visited[j] && cost[s][j] < dist[j]) {
                    dist[j] = cost[s][j];
                }
            }
        }
        System.out.printf("%.2f%n", total);
    }
}
