import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();

        for (int i=1; i<=N; i++) {
            queue.offer(i);
        }
        
        int index=1;
        while (queue.size() > 1) {
            if (index % 2 != 0) {
                queue.poll(); 
            } else {
                int tmp = queue.poll(); 
                queue.offer(tmp); 
            }
            index++; 
        }
        System.out.println(queue.peek());
	}
}