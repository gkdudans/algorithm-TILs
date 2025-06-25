import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int D[][][] = new int[100001][5][5];
		// mp[i][j]: i -> j로 옮기기 위해 드는 힘
		int mp[][] = {
		    {0, 2, 2, 2, 2},
            {2, 1, 3, 4, 3},
            {2, 3, 1, 3, 4},
    		{2, 4, 3, 1, 3},
    		{2, 3, 4, 3, 1}};
		
		// 충분히 큰 수로 배열 초기화 
		for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 100001; k++)
                    D[k][i][j] = 100001 * 4;
            }
        }
        
        D[0][0][0] = 0;
        
        int n = 0; // 0, 1, 2, 3, 4
        int s = 1; // step 
        
        while(true) {
            n = sc.nextInt();
            if(n == 0) {
                s--;
                break;
            }
            
            // -1. 오른발을 n으로 이동 
            for(int i=0; i<5; i++) {
                for(int j=0; j<5; j++) {
                    if(n == i) continue;
                    D[s][i][n] = Math.min(D[s][i][n], D[s-1][i][j] + mp[j][n]);
                }
            }
            
            // -2. 왼발을 n으로 이동 
            for(int i=0; i<5; i++) {
                for(int j=0; j<5; j++) {
                    if(n == i) continue;
                    D[s][n][i] = Math.min(D[s][n][i], D[s-1][j][i] + mp[j][n]);
                }
                
            }
            s++;
            
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                min = Math.min(min, D[s][i][j]);
            }
        }
        
        System.out.println(min);
	}
}