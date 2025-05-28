import java.io.*;
import java.util.*;

public class Main
{
    static int[][] tree;  // 트리 데이터를 저장하기 위한 2차원 배열 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		tree = new int[26][2];
		
		// tree[node][0] -> left
		// tree[node][1] -> right 저장 
		for(int i=0; i<N; i++) {
		    st = new StringTokenizer(br.readLine());
		    int node = st.nextToken().charAt(0) - 'A';
		    char left = st.nextToken().charAt(0);
		    char right = st.nextToken().charAt(0);
		    
		    tree[node][0] = (left == '.') ? -1 : left - 'A';
            tree[node][1] = (right == '.') ? -1 : right - 'A';
		}
		
		// A가 항상 루트 노드 -> 0부터 시작 
		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0); 
	}
	
	// 전위 순회 
	static void preOrder(int s) {
	    if(s == -1) return;
	    
	    System.out.print((char)(s + 'A'));
	    
	    preOrder(tree[s][0]);
	    preOrder(tree[s][1]);
	    
	}
	
	// 중위 순회 
	static void inOrder(int s) {
	    if(s == -1) return;
	    
	    inOrder(tree[s][0]);
	    System.out.print((char)(s + 'A')); 
	    inOrder(tree[s][1]);
	}
	
	// 후위 순회 
	static void postOrder(int s) {
	    if(s == -1) return;
	    
	    postOrder(tree[s][0]);
	    postOrder(tree[s][1]);
	    System.out.print((char)(s + 'A'));
	}
}