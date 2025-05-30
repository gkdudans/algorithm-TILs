import java.io.*;
import java.util.*;

public class Main
{
    static int[] tree;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// *중요* 세그먼트 트리의 h, size, base
		int h = (int)Math.ceil(Math.log(N) / Math.log(2));
		int base = (int)Math.pow(2, h);
		tree = new int[4*N];
	
	    // 리프 노드 입력 
		for(int i=1; i<=N; i++) {
		    tree[base+i] = Integer.parseInt(br.readLine());
		}
		
		// 트리 채우기 (bottom-up)
        for(int i=base-1; i>0; i--) {
            tree[i] = Math.min(tree[i*2], tree[i*2+1]);
        }  
		
		// a, b에 대한 답 출력 
		for(int i=0; i<M; i++) {
		    st = new StringTokenizer(br.readLine()); 
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    getMin(base+a, base+b);
		}
	}
	
	// 최솟값 구하기
	static void getMin(int start, int end) {
	    int min = Integer.MAX_VALUE;
	    
	    while(start <= end) {
	        // 홀수 인덱스 -> 오른쪽 자식 
	        if(start%2 == 1) {
	            min = Math.min(min, tree[start]);
	            start++;
	        }
	        // 짝수 인덱스 -> 왼쪽 자식 
	        if(end%2 == 0) {
	            min = Math.min(min, tree[end]);
	            end--;
	        }
	        start /= 2;
	        end /= 2; 
	    }
	    System.out.println(min); 
	}
}