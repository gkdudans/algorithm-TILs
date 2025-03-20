import java.util.*;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.next();
		String[] num = str.split("");
		
		int[] A = new int[num.length];
		
		for(int i=0; i<num.length; i++){
		    A[i] = Integer.parseInt(num[i]);
		}
		
		for(int i=0; i<num.length; i++){
		    int max = A[i];
		    int maxIndex = i;
		    for(int j=i; j<num.length; j++){
		        if (max < A[j]){
		            max = A[j];
		            maxIndex = j;
		        }
		    }
		    int tmp = A[i];
		    A[i] = max;
		    A[maxIndex] = tmp;

		}
		
		for(int i=0; i<num.length; i++){
		    System.out.print(A[i]);
		}
	
    }
}