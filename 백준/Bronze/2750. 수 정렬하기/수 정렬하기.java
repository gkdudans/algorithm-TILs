import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		
		// 버블 정렬 사용
		for(int i=0; i<N; i++){
		    num[i] = sc.nextInt();
		}
		
		// 오름차순 정렬: 작은 것이 앞에 오도록 swap 
		for(int i=1; i<=N-1; i++){
		    for(int j=1; j<=N-i; j++){
		        // 정렬된 데이터 제외
		        if(num[j-1] > num[j]){
    		        int tmp = num[j];
    		        num[j] = num[j-1];
    		        num[j-1] = tmp;
		        }
		    }
		}
		
		// 출력
		for(int i=0; i<N; i++){
		    System.out.println(num[i]);
		}
	}
}