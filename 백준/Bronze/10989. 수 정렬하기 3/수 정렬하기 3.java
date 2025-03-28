import java.util.*;
import java.io.*;

public class Main
{
    static int[] A;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine()); 
        }

        redixSort(A, 5);

        for (int i = 1; i <= N; i++) {
            bw.write(A[i] + "\n"); 
        }

        bw.flush();
        br.close();
        bw.close();
    }
    
    public static void redixSort(int[] A, int max_size){
        int m = 1; // 자릿수 
        int n = 0; // 연산 횟수 

        while(n <= max_size) {
            // 0~9까지 숫자의 개수 저장하는 배열 
            int[] bucket = new int[10];
            
            // 숫자의 빈도수 계산 
            for(int i=0; i<A.length; i++){
                bucket[(A[i]/m)%10]++;
            }
            // 누적합:  bucket[i]가 해당 숫자의 최종 위치를 나타내도록 만듦
            for(int i=1; i<10; i++){
                bucket[i] += bucket[i-1];
            }
            
            // 정렬된 결과 임시 저장
            int[] temp = new int[A.length];
            
            for (int i=A.length-1; i>=0; i--){
                int digit = (A[i] / m) % 10;
                temp[--bucket[digit]] = A[i];  
            }
                // ex) bucket[6] = 1 (6의자리 1개)
                // 436 → digit = 6
                // temp[bucket[6]-1] = temp[0] = 436 → bucket[6]--
                
                // ex) bucket[7] = 3 (7의자리 2개)
                // 657 → temp[bucket[7]-1] = temp[2] = 657 → bucket[7]--
                // 457 → temp[bucket[7]-1] = temp[1] = 457 → bucket[7]--
                
                // temp → 436, 457, 657 
            
            // 정렬된 결과를 원래 배열 A로 복사
            for (int i = 0; i < A.length; i++) {
                A[i] = temp[i];
            }

            // 다음 자릿수로 이동
            m *= 10;
            n++;
            
        }
        
        
    }
}