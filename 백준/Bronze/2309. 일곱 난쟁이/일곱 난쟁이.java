import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    int[] dwarfs = new int[9];
	    
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		for(int i=0; i<9; i++) {
		    int now = sc.nextInt();
		    dwarfs[i] = now;
		    sum += now;
		}
		
		sum -= 100;
		Arrays.sort(dwarfs);
		
		for(int i=0; i<9; i++) {
		    for(int j=i+1; j<9; j++) {
		        if(dwarfs[i] + dwarfs[j] == sum) {
		            for(int k=0; k<9; k++) {
		                if(k == i || k == j) continue;
		                else System.out.println(dwarfs[k]);
		            }
		            System.exit(0);
		        }
		    }
		}
	}
}