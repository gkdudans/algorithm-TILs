import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[5];
		
		for(int i=0; i<5; i++) {
		    num[i] = Integer.parseInt(st.nextToken());
		}
		
		while(true) {
		    if(isResult(num)) break;
		    
		    for(int i=0; i<=3; i++) {
		        if(num[i] > num[i+1]) {
		            int temp = num[i];
		            num[i] = num[i+1];
		            num[i+1] = temp;
		            printResult(num);
		        }
		    }
		}
	}
	
	static boolean isResult(int[] num) {
	    for(int i=0; i<5; i++) {
	        if(num[i] != i+1) return false;
	    }
	    return true;
	}
	
	static void printResult(int[] num) {
	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i<5; i++) {
	        sb.append(num[i] + " ");
	    }
	    System.out.println(sb);
	}
}