import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        
        // 오름차순 정렬 
        for(int i=0; i<scoville.length; i++) {
			heap.add(scoville[i]);
		}
        
        int answer = 0;
        
        while(heap.size() >= 2 && heap.peek() < K) {
            int first = heap.poll();
            int second = heap.poll();
            heap.add(first + second*2);
            answer++;
        }
        
        if(heap.peek() < K) return -1;
        return answer;
    }
}