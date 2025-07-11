import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int start = 1; 
        int end = 1; 
        int mid = 1;
        int answer = 0;
        for(int i : stones) {
            end = Math.max(end, i);
        }

        while(start <= end) {
            mid = (start + end) / 2;
            
            if(canCross(mid, stones, k)) {
                // mid를 정답 후보로 저장
                start = mid + 1; // 더 큰 범위에서 탐색 
                answer = mid;   
            } else {
                end = mid - 1;
            }

        }
        return answer;
    }

    
    static boolean canCross(int mid, int[] stones, int k) {
        int count = 0; // 연속 개수 count 
        boolean flag = false; // 연속 여부 판단 
        int max = 0; // 최대 연속 개수 
        
        // stones를 순회하며 stones[i] < mid인 개수 count (mid는 사람 수) 
        for(int i : stones) {
            if(i < mid) {
                count++;
                max = Math.max(count, max);
                if(!flag) flag = true;
            } else if(i >= mid && flag) {
                count = 0;
                flag = false;
            }
        }
        
        // stones[i]가 0이 되는 최대 연속 개수 >= k
        if(max >= k) return false; 
        // stones[i]가 0이 되는 최대 연속 개수 < k
        else return true;
    }

}