import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] num = new int[N+1];
		int[] prefixSum = new int[N+1];
		
		// 입력 
		for(int i=1; i<=N; i++){
		    num[i] = sc.nextInt();
		    prefixSum[i] = prefixSum[i-1] + num[i];
		}
		
		// M개의 질의 
		for(int a=0; a<M; a++){
		    int i = sc.nextInt();
		    int j = sc.nextInt();
		    int sum = 0;
		    
		    // 출력
		    System.out.println(prefixSum[j] - prefixSum[i - 1]);
		    }
		}
}