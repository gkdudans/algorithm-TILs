import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n + 1];
        int[] B = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            A[i] = sc.nextInt();
        }
        
        Arrays.fill(B, -1); // 모든 값을 -1로 초기화 (오큰수가 없는 경우)
        Stack<Integer> stack = new Stack<>();
        
        // 모든 원소를 처리 (1부터 n까지)
        for (int i = 1; i <= n; i++) {
            // 스택이 비어있지 않고, 스택 맨 위 인덱스의 원소가 현재 원소보다 작으면
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                // 오큰수 설정
                B[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(B[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}