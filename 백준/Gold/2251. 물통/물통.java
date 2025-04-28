import java.util.*;

public class Main
{
    // 6가지 이동 케이스를 From-To로 표현 
    static int[] F = {0, 0, 1, 1, 2, 2};
    static int[] T = {1, 2, 0 ,2, 0, 1};
    static boolean[][] visited;
    static boolean[] answer;
    static int[] volume = new int[3];
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		volume[0] = sc.nextInt();
		volume[1] = sc.nextInt();
		volume[2] = sc.nextInt();
		
		// 1 <= A,B,C <= 200
		visited = new boolean[201][201];
		answer = new boolean[201];
		
		// BFS 수행
		BFS();
		
		// 정답 출력
		for(int i=0; i<answer.length; i++) {
		    if(answer[i]) {
		        System.out.print(i + " ");
		    }
		}
	}
	
	static void BFS(){
	    Queue<State> queue = new LinkedList<>();
	    queue.add(new State(0, 0, volume[2]));
	    // 현재 노드 (A, B)는 (0, 0)
	    visited[0][0] = true; 
        answer[volume[2]] = true;
        
        while(!queue.isEmpty()) {
            State state = queue.poll();
            int[] current = {state.a, state.b, state.c};
            
            // 6가지 케이스 시도 
            for(int i=0; i<6; i++) {
                int[] next = {current[0], current[1], current[2]};
                int from = F[i];
                int to = T[i];
                
                /* 
                * 부을 수 있는 최대 물 양:
                * From에 있는 물 양 중, To에 남은 빈 공간만큼 
                * F 물 양 > T 빈 공간: T의 빈 공간만큼 move
                * F 물 양 < T 빈 공간: F의 물 양만큼 move */
                int move = Math.min(next[from], volume[to]-next[to]);
                
                // 실제 이동 
                next[from] -= move;
                next[to] += move;
                
                // 방문 체크 
                if(!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new State(next[0], next[1], next[2]));
                    
                    if (next[0] == 0) {
                        answer[next[2]] = true; 
                    }
                }
                
                
            }
        }
	    
	}
	
	static class State {
        int a, b, c;
        
        State(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
}
}