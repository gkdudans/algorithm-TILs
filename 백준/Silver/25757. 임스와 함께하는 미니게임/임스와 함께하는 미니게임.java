import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    String kind = st.nextToken();
	    
	    int num = 0;
	    if(kind.equals("Y")) {
	        num = 2;
	    } else if(kind.equals("F")) {
	        num = 3;
	    } else {
	        num = 4;
	    }
	    
	    Set<String> names = new HashSet<>();
	    
	    for(int i=0; i<N; i++) {
	        String name = br.readLine();
	        names.add(name);
	    }
	    
	    System.out.println((names.size() / (num - 1)));
	}

}