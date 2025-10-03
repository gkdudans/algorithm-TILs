import java.util.*;
import java.io.*;

public class Main
{
    static Queue<Node> queue;
    static boolean[] visited;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
		    
		    queue = new LinkedList<>();
		    queue.add(new Node(A, ""));
		    visited = new boolean[10000];
		    visited[A] = true;
		        
		    while(!queue.isEmpty()) {
		        Node node = queue.poll();
		        
		        if(node.value == B) {
		            System.out.println(node.path);
		            break;
		        }
		       
		        register_D(node);
		        register_S(node);
		        register_L(node);
		        register_R(node);
		    }
		}
	}
	
    static class Node {
        int value;
        String path;
        Node(int value, String path) {
            this.value = value;
            this.path = path;
        }
    }
	
	static void register_D(Node node) {
	    int next = 2 * node.value % 10000;
	    if(!visited[next]) {
	        visited[next] = true;
	        queue.add(new Node(next, node.path + "D"));
	    }
	}
	
	static void register_S(Node node) {
	    int next = node.value - 1 >= 0 ? node.value - 1 : 9999;
	    if(!visited[next]) {
	        visited[next] = true;
	        queue.add(new Node(next, node.path + "S"));
	    }
	}
	
    static void register_L(Node node) {
        int d1 = node.value / 1000;              
        int rest = node.value % 1000;           
        int next = rest * 10 + d1;
        if(!visited[next]) {
	        visited[next] = true;
	        queue.add(new Node(next, node.path + "L"));
	    }
    }
    
    static void register_R(Node node) {
        int d4 = node.value % 10;                
        int rest = node.value / 10;          
        int next = d4 * 1000 + rest;  
        if(!visited[next]) {
	        visited[next] = true;
	        queue.add(new Node(next, node.path + "R"));
	    }
    }
}
