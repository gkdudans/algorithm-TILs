import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] distance = new int[n + 1];
        ArrayList<Integer>[] A = new ArrayList[n + 1];
        
        for(int i=0; i<A.length; i++) {
            A[i] = new ArrayList<>();
        }
        for(int i=0; i<A.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        
        // roads를 인접 리스트 형태로 저장하기 
        for(int i=0; i<roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            // a <-> b 왕복 가능 
            A[a].add(b);
            A[b].add(a);
        }
    
        // destination에 시작해서 역 BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(destination);
        distance[destination] = 0;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int next : A[now]) {
                // 방문하지 않은 노드인 경우 
                if (distance[next] == Integer.MAX_VALUE) {
                    queue.add(next);
                    distance[next] = Math.min(distance[next], distance[now] + 1);
                }
            }
        }
        
        int[] answer = new int[sources.length];
        for(int i=0; i<sources.length; i++) {
            if(distance[sources[i]] == Integer.MAX_VALUE) {
                answer[i] = -1;
            } else{
                answer[i] = distance[sources[i]];
            }
        }
        
        return answer;
    }
}