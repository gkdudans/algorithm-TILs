import java.io.*;
import java.util.*;

public class Main
{
    static ArrayList<Integer>[] A;
    static int[] tree;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int length = (int)Math.pow(2, K) - 1;
		tree = new int[length + 1];
		A = new ArrayList[K + 1];
		
		for(int i=1; i<=length; i++) {
		    tree[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=K; i++) {
		    A[i] = new ArrayList<>();
		}
		
		addNode(1, length, 1);
		
		int index = 0;
		
		for(int i=1; i<=K; i++) {
		    for(int j=0; j<A[i].size(); j++) {
		        System.out.print(A[i].get(j) + " ");
		    }
		    System.out.println();
		}
		
	}
	
	static void addNode(int start, int end, int level) {
	    if(start > end) return;
	    
	    int mid = (start + end) / 2;
	    A[level].add(tree[mid]);
	    
	    // 왼쪽 자식 
	    addNode(start, mid-1, level+1);
	    // 오른쪽 자식
	    addNode(mid+1, end, level+1);
	}
}