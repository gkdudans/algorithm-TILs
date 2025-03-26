import java.io.*;
import java.util.*;

public class Main {
    static int[] A, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        temp = new int[N + 1]; 

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine()); 
        }

        mergeSort(1, N);

        for (int i = 1; i <= N; i++) {
            bw.write(A[i] + "\n"); 
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void mergeSort(int s, int e){
        if(s >= e) return;
        int m = (s + e) / 2;
        // 왼쪽 부분 정렬 
        mergeSort(s, m);
        // 오른쪽 부분 정렬 
        mergeSort(m + 1, e);
        // 병합 
        merge(s, m, e);     
    }

    public static void merge(int s, int m, int e) {
        int index1 = s;      
        int index2 = m + 1;  
        int k = s;          

        while (index1 <= m && index2 <= e) {
            if (A[index1] <= A[index2]) {
                temp[k++] = A[index1++];
            } else {
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
