import java.util.*;

public class Main
{
    static long MOD = 1000000000; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		long[][] D = new long[N+1][11]; 
		/*
		D[N][H]: 길이가 N인 계단에서 H로 끝나는 계단을 만들 수 있는 경우의 수 
		D[i][0] = D[i-1][1] // i-1번째 자리가 1인 경우의 수 
        D[i][9] = D[i-1][8] // i-1번째 자리가 8인 경우의 수 
        D[i][H] = D[i-1][H-1] + D[i-1][H+1] // H : 1 ~ 8
        */ 
        
        // 초기화 
        for(int i=1; i<=9; i++) {
            D[1][i] = 1;
        }
        
        // 점화식 사용
        for(int i=2; i<=N; i++) {
            D[i][0] = (D[i-1][1]) % MOD;
            D[i][9] = (D[i-1][8]) % MOD;
            for(int j=1; j<=8; j++) {
                D[i][j] = (D[i-1][j-1] + D[i-1][j+1]) % MOD; 
            }
        }
        
        // D[N][0~9]인 값 더해서 출력
        long sum = 0;
        for(int i=0; i<=9; i++) {
            sum = (sum + D[N][i]) % MOD; 
        }
        System.out.println(sum);
	}
}