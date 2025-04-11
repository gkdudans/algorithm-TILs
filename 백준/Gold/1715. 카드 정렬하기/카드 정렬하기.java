import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
		    queue.offer(sc.nextInt());
		}
		
		int count = 0;
		
		while(queue.size() > 1) {
		    // pq에서의 poll -> size 작은 순서대로 
		    int data1 = queue.poll();
		    int data2 = queue.poll();
		    count += data1 + data2;
		    queue.offer(data1 + data2);
		}
		
		System.out.println(count);
	}

}