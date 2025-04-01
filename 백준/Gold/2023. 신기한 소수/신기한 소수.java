import java.util.*;

public class Main
{
    static int N;
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);
		
	}
	
	public static void DFS(int n, int digit){
	    if(!isDecimal(n)) return;
	    
	    if(digit == N) {
	        System.out.println(n);
	        return;
	    }
	    
	    for(int i=1; i<=5; i++) {
	        int j = i*2-1;
	        DFS(n*10 + j, digit+1);
	    }
	}
	
	public static boolean isDecimal(int n){
	    for(int i=2; i<=n/2; i++){
	        if(n%i == 0) return false;
	    }
	    return true;
	}
}