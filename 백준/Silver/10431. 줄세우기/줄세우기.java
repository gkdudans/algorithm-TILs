import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int P = Integer.parseInt(br.readLine());
	    
	    for(int i=0; i<P; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int[] student = new int[20];
	        int count = 0;
	        List<Integer> line = new ArrayList<>();
	        int num = Integer.parseInt(st.nextToken());
	        
	        for(int j=0; j<20; j++) {
	            int now = Integer.parseInt(st.nextToken());
	            int k;
	            
    	        for(k=0; k<line.size(); k++) {
    	            if(line.get(k) < now) break;
    	        }
    	        
    	        count += k;
    	        line.add(k, now);
	        }
	        
	        System.out.printf("%d %d\n", num, count);
	    }
	}
}