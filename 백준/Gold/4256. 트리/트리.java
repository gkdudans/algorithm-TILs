import java.util.*;
import java.io.*;

public class Main
{
    static int[] preorder;
    static int[] inorder;
    static int N;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
		    N = Integer.parseInt(br.readLine());
		    preorder = new int[N];
		    inorder = new int[N];
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for(int i=0; i<N; i++) {
		        preorder[i] = Integer.parseInt(st.nextToken());
		    }
		    st = new StringTokenizer(br.readLine());
		    for(int i=0; i<N; i++) {
		        inorder[i] = Integer.parseInt(st.nextToken());
		    }
		    
		    // 전위순회: R -> 왼 -> 오
		    // 중위순회: 왼 -> R -> 오 
		    Node root = fillTree(0, 0, N-1);
		    postorder(root);
		    System.out.print("\n");
		}
	}
	
	static Node fillTree(int r, int s, int e) {
	    if(s > e) return null;
	    
	    // inorder에서의 root index 
	    int r_index = -1; 
	    for(int i=s; i<=e; i++) {
	        if (inorder[i] == preorder[r]) {
	            r_index = i;
	            break;
	        }
	    }
	    if (r_index == -1) return null;
	    int leftSize = r_index - s;
	    
	    Node rootNode = new Node(preorder[r]);
	    rootNode.leftNode = fillTree(r + 1, s, r_index - 1);
	    rootNode.rightNode = fillTree(r + leftSize + 1, r_index + 1, e);
	    
	    return rootNode;
	}
	
	static void postorder(Node node) {
        if(node == null) return;
        // 왼 -> 오 -> R 순서 
        postorder(node.leftNode);  
        postorder(node.rightNode); 
        System.out.print(node.num + " "); 
    }
	
	static class Node {
	    int num;
	    Node leftNode;
	    Node rightNode;
	    
	    Node(int num) {
	        this.num = num;
	    }
	}
}