import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] indegree = new int[N + 1];
			int[] time = new int[N + 1];
			int[] sum = new int[N + 1];
			ArrayList<Integer>[] A = new ArrayList[N + 1];

            st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
			    A[i] = new ArrayList<>();
				time[i] = Integer.parseInt(st.nextToken());
				sum[i] = time[i];
			}

			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				A[X].add(Y);
				indegree[Y]++;
			}

			int W = Integer.parseInt(br.readLine());
			Queue<Integer> queue = new LinkedList<>();

			for(int i=1; i<=N; i++) {
				if(indegree[i] == 0) {
				    queue.add(i);
				}
			}

			while(!queue.isEmpty()) {
				int now = queue.poll();
				
				for(int next : A[now]) {
				    sum[next] = Math.max(sum[next], sum[now] + time[next]);
					indegree[next]--;
					if(indegree[next] == 0) {
						queue.add(next);
					}
				}
			}
			System.out.println(sum[W]);
		}
	}
}