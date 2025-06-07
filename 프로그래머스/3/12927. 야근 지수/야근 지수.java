import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
        // 평탄화 필요
        // 가장 큰 수를 줄이는 것이 제곱합을 가장 많이 줄이는 방법
        for(int i=0; i<works.length; i++) {
            pq.add(works[i]);
        }
        
        while(n > 0 && !pq.isEmpty()) {
            int max = pq.poll();
            if(max-1>0) pq.add(max-1);
            n--;
        }
        
        while(!pq.isEmpty()) {
            int now = pq.poll();
            answer += Math.pow(now, 2);
        }
        
        
        return answer;
    }
}