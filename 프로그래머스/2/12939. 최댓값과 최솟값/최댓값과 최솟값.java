import java.util.*;

class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = -Integer.MAX_VALUE;
        
        String[] A = s.split(" ");
        
        for(int i=0; i<A.length; i++) {
            int now = Integer.parseInt(A[i]);
            min = Math.min(min, now);
            max = Math.max(max, now);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(min);
        sb.append(" ");
        sb.append(max);
        return sb.toString();
    }
}