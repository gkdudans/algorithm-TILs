import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<Edge> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.add(new Edge(begin, 0));
        
        while(!queue.isEmpty()) {
            Edge now = queue.poll();
            if(now.word.equals(target)) return now.depth; 

            for(int i=0; i<words.length; i++) {
                if(!visited[i] && isConnected(now.word, words[i])) {
                    queue.add(new Edge(words[i], now.depth + 1));
                    visited[i] = true;
                }
            }
        }
        
        
        return 0;
    }
    
    static class Edge {
        String word;
        int depth;
        
        public Edge(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
        
    }
    
    static boolean isConnected(String first, String second) {
        int diff = 0;
        for(int i=0; i<first.length(); i++) {
            if(first.charAt(i) - second.charAt(i) != 0) diff++;
            if(diff > 1) return false;
        }
        return true;
    }
}