import java.util.*;

class Solution {
    public int[] solution(String s) {
        int count1 = 0; // 이진 변환 횟수
        int count2 = 0; // 제거된 0의 개수 
        
        while(!s.equals("1")) {
            // x의 모든 0 제거 
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); i++) {
                int now = s.charAt(i) - '1';
                if(now == 0) sb.append("1");
                else count2++;
            }
            // x의 길이를 2진법 변환
            s = Integer.toString(sb.length(), 2);
            count1++;
        }
        
        int[] answer = {count1, count2};
        return answer;
    }
}