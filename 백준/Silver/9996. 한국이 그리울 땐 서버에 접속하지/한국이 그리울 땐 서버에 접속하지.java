import java.util.regex.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    String[] patterns = br.readLine().split("\\*");
	    String p = "^" + patterns[0] + ".*" + patterns[1] + "$";
	    // ^: 시작
	    // .: 임의의 문자 1개
	    // $: $ 앞의 문자열로 끝나는 단어 

	    Pattern pattern = Pattern.compile(p);
	    
	    for(int i=0; i<N; i++) {
	        String now = br.readLine();
	        Matcher matcher = pattern.matcher(now);
	        
	        if(matcher.matches()) {
	            System.out.println("DA");
	        } else {
	            System.out.println("NE");
	        }
	    }
	}
}