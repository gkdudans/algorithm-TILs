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
        
        Arrays.fill(B, -1);
        Stack<Integer> stack = new Stack<>();
        // stack에는 index를 저장 
        
        for (int i = 1; i <= n; i++) {
            // 오큰수인 경우 
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                B[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        
        // 출력 
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(B[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
