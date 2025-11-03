import java.util.*;
import java.io.*;

public class Main
{
    static int sum;
    static int N;
    static boolean flag;
    static List<Coin> coins;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while((line = br.readLine()) != null && !line.isEmpty()) {
    		N = Integer.parseInt(line.trim());
    		flag = false;
    		sum = 0;
    		coins = new ArrayList<>();
    		
    		for(int i=0; i<N; i++) {
    		    StringTokenizer st = new StringTokenizer(br.readLine());
    		    int value = Integer.parseInt(st.nextToken());
    		    int count = Integer.parseInt(st.nextToken());
    		    sum += value * count;
    		    coins.add(new Coin(value, count));
    		}
    		
    		if(sum % 2 != 0) {
                System.out.println("0");
                continue;
            }

    		int target = sum / 2;
    		// dp[value]: 현재까지 사용한 동전들로 합이 value가 가능한지 
    		// 배낭형 dp: 배낭의 무게 k를 넘지 않게 물건을 넣는 문제와 유사 
            boolean[] dp = new boolean[target + 1];
            dp[0] = true; 

            for (Coin coin : coins) {
                int value = coin.value;
                int count = coin.count;
                boolean[] next = dp.clone();

                for(int j=0; j<=target; j++) {
                    if (!dp[j]) continue; 
                    // 현재 동전을 1~count개 사용할 수 있음
                    for(int k=1; k<=count; k++) {
                        // 이전합 j, 현재 값 value*k
                        int nextSum = j + value * k;
                        if (nextSum > target) break;
                        next[nextSum] = true;
                    }
                }
                dp = next; // 이번 동전까지 썼을 때 가능한 상태 
            }
    	
    		if (dp[target]) System.out.println("1");
            else System.out.println("0");
		}
	}
	
	static class Coin {
	    int value;
	    int count;
	    
	    Coin(int value, int count) {
	        this.value = value;
	        this.count = count;
	    }
	}
}