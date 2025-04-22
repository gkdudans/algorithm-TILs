import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		// lcm = A * B / gcd 
		for(int i=0; i<T; i++) {
		    int A = sc.nextInt();
		    int B = sc.nextInt();
		    int lcm = A * B / gcd(A, B); 
		    System.out.println(lcm);
		}
		
	}
	
	public static int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }
}