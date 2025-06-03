import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>(); 
        
        for(int i=0; i<s.length(); i++) {
            int now = s.charAt(i) - '(';
            queue.add(now); 
        }
        
        int count = 0;
        if(queue.peek() != 0) return false;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            if(count < 0) return false;
            
            if(now == 0) {
                count++;
            } else {
                count--;
            }
        }
        
        if(count == 0) return true;
        else return false;
    }
}