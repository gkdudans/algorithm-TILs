import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int bitmask = 0; 

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            String cmd = input[0];
            int num = 0;

            if (input.length == 2) num = Integer.parseInt(input[1]);

            switch (cmd) {
                case "add":
                    bitmask |= (1 << num);
                    break;
                case "remove":
                    bitmask &= ~(1 << num);
                    break;
                case "check":
                    sb.append((bitmask & (1 << num)) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    bitmask ^= (1 << num);
                    break;
                case "all":
                    bitmask = (1 << 21) - 1; 
                    break;
                case "empty":
                    bitmask = 0;
                    break;
            }
        }

        System.out.print(sb);
    }
}
