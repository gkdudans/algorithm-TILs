import java.util.*;
import java.io.*;


public class Main
{
    static int N, max;
    static int[] B = new int[1000001]; // 현재 가장 유리한 증가 수열 
    static int[] A = new int[1000001]; // 수열 데이터 
    static int[] D = new int[1000001]; // 0~i까지 i를 포함하는 최장증가수열 길이
    static int[] ans = new int[1000001]; // 정답 수열 
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
		    A[i] = Integer.parseInt(st.nextToken());
		}
		
		int index;
		B[++max] = A[1];
		D[1] = 1;
		
		for(int i=2; i<=N; i++) {
		    if(B[max] < A[i]) {
		        max++;
		        B[max] = A[i]; // 현재 가장 유리한 증가 수열 업데이트 
		        D[i] = max; // i를 포함하는 최장증가수열 길이
		    } else {
		        // B 배열에서 A[i]보다 처음으로 크거나 같아지는 원소의 index 찾기
		        index = binarySearch(1, max, A[i]);
		        B[index] = A[i]; // 작은 값(A[i])으로 교체 
		        D[i] = index; // 1-based, index가 곧 i를 포함하는 최장증가수열 길이
		    }
		}
		
		System.out.println(max);
		
		index = max;
		int x = Integer.MAX_VALUE;
		
		// 뒤에서부터 탐색하면서 정답 수열 저장 (역추적)
		for(int i = N; i >= 1; i--) {
            if(D[i] == index && A[i] < x) {
                ans[index] = A[i]; // 뒤에서부터 채움
                x = A[i]; // 이전에 채운 값보다 작아야 함
                index--;
            }
        }
        
        for(int i = 1; i <= max; i++) {
            System.out.print(ans[i] + " ");
        }
	}
	
	// A[i]가 들어갈 위치를 찾는 이분 탐색
	// B[k-1] < A[i] <= B[k]를 만족하는 k를 찾는 과정
    static int binarySearch(int l, int r, int now) {
        int mid;
        while(l < r) {
            mid = (l + r) / 2;
            if(B[mid] < now) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
	
}