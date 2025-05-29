import java.io.*;
import java.util.*;

public class Main
{
    static long[] tree;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// *중요* 세그먼트 트리의 h, size, base
		int h = (int)Math.ceil(Math.log(N) / Math.log(2));
		int base = (int)Math.pow(2, h);
		int size = base * 4;
		tree = new long[size];
		
		// 리프 노드 입력
        for(int i=1; i<=N; i++) {
            tree[base + i] = Long.parseLong(br.readLine());
        }
        // 트리 채우기 (bottom-up)
        for(int i=base-1; i>0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        } 
		
		
		// 수의 변경: 세그먼트 + 구간 합 트리 
		for(int i=0; i<M+K; i++) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    long c = Long.parseLong(st.nextToken());
		    
		    if(a == 1) {
		        change(base+b, c);
		    } 
		    else if(a==2) {
		        sum(base+b, base+c);
		    }
		}
		
	}
	
	static void change(int index, long c) {
        long diff = (long)c - tree[index]; 
        while(index > 0) {
            tree[index] += diff;
            index /= 2;
        }
    }

	
	static void sum(int start, long end) {
	    long sum = 0;
	    while(start <= end) {
	        // start가 오른쪽 자식인 경우 
	        if(start%2 == 1) {
	            sum += tree[start];
	            start++; 
	        }
	        // end가 왼쪽 자식인 경우 
	        if(end%2 == 0) {
	            sum += tree[(int)end];
	            end--;
	        }
	        start /= 2;
	        end /= 2;
	    }
	    System.out.println(sum);
	}
}