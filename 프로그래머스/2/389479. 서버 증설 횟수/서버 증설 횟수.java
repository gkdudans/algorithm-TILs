import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int count = 0;
        int now = 0;
        int prev = 0;
        Queue<Server> queue = new LinkedList<>();
        
        for(int t=0; t<24; t++) {
            // t에서 queue에서 제외되는 게 있는지 확인 
            if(!queue.isEmpty() && queue.peek().time + k <= t) {
                prev -= queue.poll().x;
            }
            
            now = players[t] / m;

            if(now > prev) {
                queue.add(new Server(now - prev, t));
                count += now - prev;
                prev = now;
            }
        }
        return count; 
    }
    
    static class Server {
        int x;
        int time;
        
        Server(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
