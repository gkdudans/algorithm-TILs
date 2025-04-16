import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        long A = sc.nextLong();
        long B = sc.nextLong();
        
        double sqrtA = Math.sqrt(A);
        double sqrtB = Math.sqrt(B);
        
        int intPartA = (int) sqrtA;
        double fracPartA = sqrtA - intPartA;
        int intPartB = (int) sqrtB;
        double fracPartB = sqrtB - intPartB;
        
        int[] num = new int[intPartB + 1]; 
        
        // 에라토스테네스의 체로 소수 구하기
        for(int i=0; i<=intPartB; i++) {
            num[i] = i;
        }
        
        for(int i=2; i<=intPartB; i++) {
            if (num[i] == 0) continue;

            for(int j=i*2; j<num.length; j+=i) {
                num[j] = 0;
            }
        }

        int count = 0;
        
        // 거의 소수 개수 연산
        for(int i=2; i<=sqrtB; i++) {
            if(num[i] == 0) continue;
            
            long base = i;
            long power = base * base;
            
            while(power <= B) {
                if(power >= A) count++;
                
                // overflow 방지
                if(power > Long.MAX_VALUE / base) break;

                power *= base;
            }
        }
        
        System.out.println(count);
    }
}
