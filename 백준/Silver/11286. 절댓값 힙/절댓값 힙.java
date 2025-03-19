import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) ->{
		    int x = Math.abs(o1);
		    int y = Math.abs(o2);
		    
		    if (x == y){
		        if (o1 > o2){
		            return 1;
		            // x가 +, y가 -인 경우 우선순위 x < y
		        }
		        else{
		            return -1;
		             // x가 -, y가 +인 경우 우선순위 x > y
		        }
		    }
		    else {
		        return x - y;
		        // x, y 중 더 작은 것을 우선순위 높게 배치 
		    }
		});
		
		for(int i=0; i<N; i++){
		    int newValue = sc.nextInt();
		    
		    if(newValue != 0){
		        queue.offer(newValue);
		    }
		    else {
		        if(queue.size() == 0){
    		        System.out.println(0);
    		        continue;
		        }
		        int min = queue.poll();
		        System.out.println(min);
		    }
		}
	}
}