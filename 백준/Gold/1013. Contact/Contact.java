import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String pattern = "^(100+1+|01)+$";
        Pattern p = Pattern.compile(pattern);

        for(int i=0; i<T; i++) {
            String now = br.readLine();
            Matcher matcher = p.matcher(now);

            if(matcher.matches()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}