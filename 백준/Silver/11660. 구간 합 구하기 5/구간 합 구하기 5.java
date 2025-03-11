import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력 
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int A[][] = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++){
		    for(int j=1; j<=N; j++) 
		        A[i][j] = sc.nextInt();
		}
		
		// 구간 합
		int S[][] = new int[N+1][N+1];
		for(int i=1; i<=N; i++){
		    for(int j=1; j<=N; j++) 
		        S[i][j] = S[i][j-1] + S[i-1][j] - S[i-1][j-1] + A[i][j];
		}
		
		// M번의 질의
		for(int i=0; i<M; i++){
		    int x1 = sc.nextInt();
		    int y1 = sc.nextInt();
		    int x2 = sc.nextInt();
		    int y2 = sc.nextInt();
		    System.out.println(S[x2][y2] - S[x1-1][y2] - S[x2][y1-1] + S[x1-1][y1-1]);
		}
	}
}