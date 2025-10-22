import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] num, parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            if (n == 0 && k == 0) break;

            num = new int[n + 1];
            parent = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            // 노드 번호 k의 노드 index 찾기 
            int k_index = -1;
            for(int i=1; i<=n; i++) {
                if (num[i] == k) {
                    k_index = i;
                    break;
                }
            }
            // 모든 노드의 부모 idx 저장 
            int parent_idx = 0;
            
            parent[1] = 0;
            for(int i=2; i<=n; i++) {
                if (num[i] != num[i - 1] + 1) {
                    parent_idx++;
                }
                parent[i] = parent_idx;
            }

            int k_parent = parent[k_index];
            int k_grandparent = parent[k_parent];
            int count = 0;
            
            // 사촌 개수 카운트 
            if (k_grandparent != 0) {
                for (int i = 2; i <= n; i++) {
                    if (parent[i] == 0) continue;
 
                    if (parent[parent[i]] == k_grandparent && parent[i] != k_parent) {

                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
