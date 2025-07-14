import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
		    int score = Integer.parseInt(st.nextToken());
		    pq.add(score);
		}
		
		int count = 1;
		int lastScore = 0;
		while(count <= k && !pq.isEmpty()) {
		    lastScore = pq.poll();
		    count++;
		}
		
		System.out.println(lastScore);
	}
}