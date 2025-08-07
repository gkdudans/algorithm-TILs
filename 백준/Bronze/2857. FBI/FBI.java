import java.util.regex.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Pattern pattern  = Pattern.compile(".*FBI.*");
		boolean flag = false;
		
	    for(int i=0; i<5; i++) {
	        String now = br.readLine();
	        Matcher matcher = pattern.matcher(now);
	        
	        if(matcher.matches()) {
	            System.out.print(i+1 + " ");
	            flag = true;
	        }
	        
	    }
	    
	    if(!flag) System.out.println("HE GOT AWAY!");
	}
}