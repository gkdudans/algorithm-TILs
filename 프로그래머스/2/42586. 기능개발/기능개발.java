import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>(); 
        for(int i=0; i<progresses.length; i++) {
            int temp = needTime(progresses[i], speeds[i]);
            queue.offer(temp); 
            // 예시: 7 2 9 
        }
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            int count = 1;
            
            while(!queue.isEmpty() && queue.peek() <= now) {
                queue.poll();
                count++;
            }
            result.add(count);
        }
        
         int[] answer = new int[result.size()];
        
         for (int i = 0; i < result.size(); i++) {
             answer[i] = result.get(i);
         }
        
        return answer;
    }
    
    static int needTime(int need, int speed) {
        // 정수 나눗셈 방지: double로 연산 
        return (int) Math.ceil((100.0 - need) / speed);
    }
}