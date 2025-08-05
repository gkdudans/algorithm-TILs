import java.io.*;
import java.util.*;

public class Main
{
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		int[] time = new int[10*100000];
		Arrays.fill(time, Integer.MAX_VALUE);
		
		queue.add(N);
		time[N] = 0;
		boolean[] visited = new boolean[10*100000];
		int now = N;
		
		while(now != K) {
		    now = queue.poll();
		    visited[now] = true;
		    
		    // X-1로 이동
		    if(now-1 >= 0 && !visited[now-1]) {
		        time[now-1] = Math.min(time[now-1], time[now] + 1);
		        queue.add(now-1);
		    }
		    // X+1로 이동 
		    if(now+1 <= 100000 && !visited[now+1]) {
		        time[now+1] = Math.min(time[now+1], time[now] + 1);
		        queue.add(now+1);
		    }
		    // 2*X로 이동 
		    if(now*2 <= 100000 && !visited[now*2]) {
		        time[2*now] = Math.min(time[2*now], time[now] + 1);
		        queue.add(now*2);
		    }
		}
		
		System.out.println(time[K]);
	}
}
	