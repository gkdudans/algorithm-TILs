import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int count = 0;

        count += n / 5;
        n %= 5;

        if (n % 2 == 0) {
            count += n / 2;
            System.out.println(count);
        } else {
            if (count >= 1) {
                count -= 1;    
                n += 5;         
                count += n / 2; 
                System.out.println(count);
            } else {
                System.out.println(-1);
            }
        }
    }
}
