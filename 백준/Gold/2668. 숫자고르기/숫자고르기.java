import java.io.*;
import java.util.*;

public class Main {
    static int n, num;
    static int[] arr;
    static boolean[] check;
    static List<Integer> answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        check = new boolean[N + 1];
        for(int i=1; i <=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        answer = new LinkedList<>(); 

        for(int i=1; i<=N; i++) {
            check[i] = true;
            num = i;
            dfs(i);
            check[i] = false;
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }

    public static void dfs(int i) {
        // 사이클이 발생하는지 체크 
        if (arr[i] == num) { 
            answer.add(num); 
        }
        if (!check[arr[i]]) {
            check[arr[i]] = true;
            dfs(arr[i]);
            check[arr[i]] = false;
        }
    }
}