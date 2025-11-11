import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String now = br.readLine();
	    String target = br.readLine();
	    StringBuilder sb = new StringBuilder();

        // 폭발 문자열의 마지막 알파벳 
        char trigger = target.charAt(target.length() - 1);

        for(char c : now.toCharArray()) {
            sb.append(c);
            if (c == trigger) {
                int start = sb.length() - target.length();
                int end = sb.length();

                if(start < 0) continue;
                if(sb.substring(start, end).equals(target))
                    sb.delete(start, end);
            }
        }

        if (sb.toString().isEmpty()) System.out.println("FRULA");
        else System.out.println(sb);
    }
}