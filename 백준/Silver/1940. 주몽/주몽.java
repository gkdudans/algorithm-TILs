import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    // 입력 
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int count = 0;
        int[] A = new int [N];
        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }
        
        // 정렬
        Arrays.sort(A);
        
        // 투 포인터 사용 
        int start_idx = 0;
        int end_idx = N-1;
        
        while(start_idx < N && start_idx < end_idx){
            int sum = A[start_idx] + A[end_idx];
            if (sum == M){
                count++;
                start_idx++;
            }
            else if (sum < M){
                start_idx++;
            }
            else{
                end_idx--;
            }
        }
        
        System.out.println(count);
    
	}
}