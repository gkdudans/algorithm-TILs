import java.util.*;

public class Main {
    static int N;
    static ArrayList<Edge>[] A;
    static long[] num;
    static long[] den;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new ArrayList[N];
        num = new long[N];
        den = new long[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            A[i] = new ArrayList<>();
        }

        // 연결 리스트에 양방향 데이터 삽입
        for(int i=0; i<N-1; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            long p = sc.nextLong();
            long q = sc.nextLong();
            
            // 기약분수 형태로 저장
            long gcd = gcd(p, q);
            p /= gcd;
            q /= gcd;
            A[s].add(new Edge(e, p, q));
            A[e].add(new Edge(s, q, p));
        }

        num[0] = 1;
        den[0] = 1;
        dfs(0);
        
        long lcm = 1;
        for(int i=0; i<N; i++) {
            lcm = lcm(lcm, den[i]);
        }
        for(int i=0; i<N; i++) {
            System.out.printf("%d ", num[i]*lcm/den[i]);
        }
        
        
    }

    // DFS(재귀적으로 수행)
    static void dfs(int current) {
        visited[current] = true;
        for(Edge edge : A[current]) {
            if(!visited[edge.e]) {
                num[edge.e] = num[current] * edge.q;
                den[edge.e] = den[current] * edge.p;
                
                // 기약분수 형태로 저장 
                long gcd = gcd(num[edge.e], den[edge.e]);
                num[edge.e] /= gcd;
                den[edge.e] /= gcd;
                
                dfs(edge.e);
            }
        }
    }

    static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    static long lcm(long a, long b) {
    return a / gcd(a, b) * b; 
    }
    
    
    static class Edge {
        int e;
        long p;
        long q;

        Edge(int e, long p, long q) {
            this.e = e;
            this.p = p;
            this.q = q;
        }
    }
}
