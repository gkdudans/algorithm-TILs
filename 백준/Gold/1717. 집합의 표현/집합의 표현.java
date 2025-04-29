import java.util.*;

public class Main {
    static int[] parent; 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n + 1];
        
        // 대표 노드 초기화 
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        
        // m번 연산 
        for (int i = 0; i < m; i++) {
            int temp = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            if (temp == 0) {
                union(a, b);
            } else {
                if (checkSame(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
    
    // union 연산 
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
    
    // find 연산 
    static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            // 대표 노드가 아니면 find(parent[a]) 값으로 저장 
            // 재귀 함수 형태 
            return parent[a] = find(parent[a]);
        }
    }
    
    // 두 원소가 같은 집합인지 확인 
    static boolean checkSame(int a, int b) { 
        return find(a) == find(b);
    }
}
