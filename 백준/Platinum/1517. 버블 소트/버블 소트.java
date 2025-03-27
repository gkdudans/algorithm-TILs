import java.io.*;
import java.util.*;

public class Main
{
    static int[] A, temp;
    static long result=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
        temp = new int[N + 1]; 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i=1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        mergeSort(1, N);
        
        System.out.println(result);
        br.close();
		
	}
	
	public static void mergeSort(int s, int e){
	    if(s >= e) return;
	    int m = (s + e) / 2;
	    mergeSort(s, m);
	    mergeSort(m+1, e);
	    merge(s, m, e);
	}
	
	public static void merge(int s, int m, int e){
	    int index1 = s;      
        int index2 = m + 1;  
        int k = s;          

        while (index1 <= m && index2 <= e) {
            if (A[index1] <= A[index2]) {
                temp[k++] = A[index1++];
            } else {
                result += index2 - k;
                temp[k++] = A[index2++];
            }
        }

        // 남은 요소 복사
        while (index1 <= m) {
            temp[k++] = A[index1++];
        }
        while (index2 <= e) {
            temp[k++] = A[index2++];
        }

        // 병합된 결과를 원본 배열 A에 복사
        for (int i = s; i <= e; i++) {
            A[i] = temp[i];
        }
    }
}