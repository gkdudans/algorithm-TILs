import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> minPositive = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> maxNegative = new PriorityQueue<>();
		int zeroCount = 0;
		int oneCount = 0;
		int sum = 0;
		for(int i=0; i<N; i++) {
		    int temp = sc.nextInt();
		    if(temp == 0) {
		        zeroCount++;
		    }
		    else if(temp == 1) {
		        oneCount++;
		    }
		    else if(temp > 1) {
		        minPositive.offer(temp);
		    }
		    else if(temp < 0){
		        maxNegative.offer(temp);
		    }
		}
		
		// 1보다 큰 양수
		while(minPositive.size() > 1) {
		    int pdata1 = minPositive.poll();
		    int pdata2 = minPositive.poll();
		    sum += pdata1*pdata2;
		}
		
		// 양수의 개수 홀수인 경우
		if(minPositive.size() == 1) {
		    sum += minPositive.poll();
		}
		
		// 음수
		while(maxNegative.size() > 1) {
		    int ndata1 = maxNegative.poll();
		    int ndata2 = maxNegative.poll();
		    sum += ndata1*ndata2;
		}
		
		// 음수의 개수 홀수인 경우
		if(maxNegative.size() == 1 && zeroCount >= 1) {
		    sum += 0;
		}
		else if (maxNegative.size() == 1) {
		    sum += maxNegative.poll();
		}
		
		// 1은 묶지 않고 더하기 
		sum += oneCount;
		
		System.out.println(sum);
	}
}