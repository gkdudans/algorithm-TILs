import java.util.*;
import java.io.*;

public class Main
{
    static long[] tree;
    static final long MOD = 1_000_000_007; // 오버플로우 방지 
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
	    
	    // 세그먼트 트리의 h, base, tree size 정의 
        int h = (int)Math.ceil(Math.log(N) / Math.log(2)); 
        int base = (int)Math.pow(2, h);
        tree = new long[4*N];
    	
    	// 리프 노드 데이터 추가 
    	for(int i=1; i<=N; i++) {
    	    tree[base+i] = Long.parseLong(br.readLine());
    	}
    	
    	// 트리 채우기 (bottom-up)
    	// 누적 곱셈이 커지기 전에 매 연산마다 MOD 적용 
    	for(int i=base; i>0; i--) {
    	    tree[i] = (tree[2*i] * tree[2*i+1]) % MOD;
    	}
    	
    	// a, b, c에 대한 결과 계산 
    	for(int i=0; i<M+K; i++) {
    	    st = new StringTokenizer(br.readLine()); 
    	    int a = Integer.parseInt(st.nextToken());
    	    int b = Integer.parseInt(st.nextToken());
    	    int c = Integer.parseInt(st.nextToken());
    	    if(a == 1) {
    	        change(base+b, c);
    	    } else if(a == 2) {
    	        getMultiple(base+b, base+c);
    	        
    	    }
    	}
	}
	
	// a==1인 경우 b번째 수를 c로 change
	static void change(int index, long newValue) {
        tree[index] = newValue;
        while (index > 1) {
            index /= 2;
            tree[index] = (tree[2*index] * tree[2*index+1]) % MOD;
        }
    }
	
	// a==2인 경우 b번째부터 c번째까지의 곱을 출력
	static void getMultiple(int start, int end) {
	    long result = 1;
	    while(start <= end) {
	        // 홀수 index: 오른쪽 자식인 경우 
	        if(start%2 == 1) {
	            result = (result * tree[start]) % MOD;
	            start++;
	        }
	        // 짝수 index: 왼쪽 자식인 경우 
	        if(end%2 == 0) {
	            result = (result * tree[end]) % MOD;
	            end--;
	        }
	        start /= 2;
	        end /=2;
	    }
	    System.out.println(result % MOD);
	}
}