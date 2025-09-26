import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        int max = 0;
        for(int i=0; i<citations.length; i++) {
            int h = citations.length - i;          
            if (citations[i] >= h) {
                max = Math.max(max, h);
            }
        }
        return max;
    }
}