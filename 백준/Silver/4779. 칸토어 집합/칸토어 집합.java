import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while ((line = br.readLine()) != null) {
		    int N = Integer.parseInt(line);
		    int length = (int) Math.pow(3, N);
		    StringBuilder sb = new StringBuilder();
		     
		    for (int i = 0; i < length; i++) {
                sb.append('-');
            }
            
            makeCantor(length, 0, sb);
            System.out.println(sb.toString());
		}
	}
		
    static void makeCantor(int length, int start, StringBuilder sb) {
        if(length == 1) {
            return;
        }
        
        int next = length / 3;
        
        // 가운데를 공백으로 변경 
        for(int i=start+next; i<start+next*2; i++) {
            sb.setCharAt(i, ' ');
        }
        
        // 좌측 재귀 
        makeCantor(next, start, sb);
        // 우측 재귀
        makeCantor(next, start+next*2, sb);
    }
}