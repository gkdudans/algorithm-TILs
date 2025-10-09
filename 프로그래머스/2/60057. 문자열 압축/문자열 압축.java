import java.util.*;

class Solution {
    public int solution(String s) {
        
        List<Integer> sizeList = new ArrayList<>();
        
        for(int i=1; i<=s.length()/2+1; i++) {
            // i: length 
            String prev = s.substring(0, i); 
            int count = 1;
            StringBuilder sb = new StringBuilder();
            
            for(int j=i; j<s.length(); j+=i) {
                String now = s.substring(j, Math.min(j+i, s.length()));
                // 압축 가능할 경우 
                if(prev.equals(now)) {
                    count++;
                } 
                // 압축 불가능할 경우 
                else {
                    if(count != 1) {
                        // 현재 문자열 전까지 
                        sb.append(count + prev);
                    } else {
                        sb.append(prev);
                    }
                    prev = now;
                    count = 1;
                } 
            }
            if (count > 1) sb.append(count).append(prev);
            else sb.append(prev);
            sizeList.add(sb.length());
        }

        Collections.sort(sizeList);
        return sizeList.get(0);
    }
}