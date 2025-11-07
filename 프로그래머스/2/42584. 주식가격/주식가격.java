import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        // prices의 인덱스 저장 
        Deque<Integer> deque = new ArrayDeque<>(); 

        for(int i=0; i<n; i++) {
            while(!deque.isEmpty() && prices[i] < prices[deque.peek()]) {
                int idx = deque.pop();
                answer[idx] = i - idx; 
            }
            deque.push(i); 
        }

        // 끝까지 떨어지지 않은 이유 
        while(!deque.isEmpty()) {
            int idx = deque.pop();
            answer[idx] = n-1 - idx;
        }

        return answer;
    }
}
