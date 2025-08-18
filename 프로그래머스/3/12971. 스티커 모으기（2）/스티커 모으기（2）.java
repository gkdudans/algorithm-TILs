import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        
        int N = sticker.length;

        if(N == 1) return sticker[0];
        
        // CASE 1: 첫 번째 인덱스를 포함 
        int[] dp1 = new int[N];
        dp1[0] = sticker[0];
        dp1[1] = Math.max(sticker[0], sticker[1]); 
        for(int i=2; i<N-1; i++) {
            // 자신 포함 / 포함하지 않는 경우의 수 중에 큰 것을 선택 
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
        }
        
        // CASE 2
        int[] dp2 = new int[N];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for(int i=2; i<N; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }

        int answer = (dp1[N-2] > dp2[N-1]) ? dp1[N-2] : dp2[N-1];
        
        return answer;
    }
}