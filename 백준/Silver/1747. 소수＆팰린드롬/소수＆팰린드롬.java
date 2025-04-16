import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        // N이 최대일 때 조건을 만족하는 수: 1003001
        int[] A = new int[1003002]; 
        
         // 에라토스테네스의 체로 소수 구하기
        for(int i=2; i<1003002; i++) {
            A[i] = i;
        }
        
        for(int i=2; i<1003002; i++) {
            if (A[i] == 0) continue;

            for(int j=i*2; j<A.length; j+=i) {
                A[j] = 0;
            }
        }
        
        // 조건을 만족하는 수 찾기 
        for(int i=N; i<1003002; i++) {
            // 짝수 제외 
            if(i != 2 && i%2 == 0) continue;
            // 소수가 아닌 것 제외 
            else if(A[i] == 0) continue;
            // 팰린드롬인 최솟값 
            else {
                String num = String.valueOf(i);
                String reversed = new StringBuilder(num).reverse().toString();
                if(num.equals(reversed)) {
                    System.out.println(i);
                    break;
                }
            }
        }
        
    }
}
