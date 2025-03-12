import java.util.*;

class Main {
    public static void main(String[] args) {
        // 입력 
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int count = 0;
        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }
        
        // 정렬
        Arrays.sort(A);
        
        // 투 포인터 사용 
        for(int i=0; i<N; i++){
            int start_idx = 0;
            int end_idx = N-1;
            while(start_idx < end_idx){
                int sum = A[start_idx] + A[end_idx];

                if (sum == A[i]){
                    if (start_idx != i && end_idx != i) {
                        count++;
                        break;
                    }
                    else if (start_idx == i) {
                        start_idx++;
                    }
                    else if (end_idx == i) {
                        end_idx--;
                    }
                }
                else if (sum < A[i]){
                    start_idx++;
                }
                else {
                    end_idx--;
                }
            }
        }
        System.out.println(count);
    }
}