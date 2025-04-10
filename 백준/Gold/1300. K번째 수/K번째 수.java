import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();
		
		// N은 10^5보다 작거나 같은 자연수
		long s = 1, e = k;
		long result = 0;
		
		while(s <= e) {
		    long mid = (s+e)/2;
		    int count = 0;
		    // 각 행마다 mid보다 작거나 같은 수의 개수 count
		    for(int i=1; i<=N; i++) {
		        count += Math.min(mid / i, N); 
		    }
		    if(count < k) {
		        s = mid + 1;
		    }
		    else {
		        // result가 유효한 후보
		        // 이진 탐색 알고리즘을 돌면서 최소값을 구함
		        e = mid - 1;
		        result = mid;
		    }
		}
		
		// result: 가장 처음으로 count>=k인 mid값 
		System.out.println(result);
		
	}
}