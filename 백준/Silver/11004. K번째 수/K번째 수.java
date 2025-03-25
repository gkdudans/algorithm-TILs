import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(A, 0, N - 1, K - 1);

        System.out.println(A[K - 1]);
    }

    public static void quickSort(int[] A, int start, int end, int K) {
        if (start < end) {
            int pivotIdx = partition(A, start, end);

            if (pivotIdx == K) return;
            if (pivotIdx > K) quickSort(A, start, pivotIdx - 1, K);
            else quickSort(A, pivotIdx + 1, end, K);
        }
    }

    public static int partition(int[] A, int start, int end) {
        if (end - start == 1) {
            if (A[start] > A[end]) {
                swap(A, start, end);
            }
            return end;
        }
    
        int mid = (start + end) / 2;
        int pivot = A[mid];
        swap(A, mid, end);
    
        int left = start, right = end - 1;
        while (left <= right) {
            while (left <= end && A[left] < pivot) {
                left++;
            } 
            while (right >= start && A[right] > pivot) {
                right--;
            }
            
            if (left <= right) {
                swap(A, left, right);
                left++;
                right--;
            } 
            else {
                break;
            }
        }
        swap(A, left, end);
        return left;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
