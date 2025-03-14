import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] N = new int[n];
        StringBuffer bf = new StringBuffer();

        for (int i = 0; i < n; i++) {
            N[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int nextPush = 1;  

        for (int i = 0; i < N.length; i++) {
            int now = N[i];

            // stack.peek() < now
            if (stack.isEmpty() || stack.peek() < now) {
                // push
                while (nextPush <= now) {
                    stack.push(nextPush);
                    bf.append("+\n");
                    nextPush++;  
                }
                // pop
                stack.pop();
                bf.append("-\n");
            }
            
            // stack.peek() == now
            else if (stack.peek() == now) {
                stack.pop();
                bf.append("-\n");
            }
            
            // stack.peek() > now
            else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(bf.toString());
    }
}