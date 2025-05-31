import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = 2 * w + 1;
        int start = 1;  
        
        for(int station : stations) {
            int left = station - w;
            int right = station + w;
            
            // 왼쪽 빈 구간 처리 
            if(start < left) {
                int gap = left - start; 
                answer += (int)Math.ceil((double)gap / coverage);
            }
            start = right + 1;
        }
        
        // 오른쪽 구간 처리 
        if (start <= n) {
            int gap = n - start + 1;
            answer += (int)Math.ceil((double)gap / coverage);
        }
        
        return answer;
        
    }
        
}