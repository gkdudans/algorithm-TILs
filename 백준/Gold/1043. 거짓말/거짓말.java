import java.util.*;

public class Main
{
    static int[] truth; 
    static int[] parent;
    static ArrayList<Integer>[] party; 
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        
        truth = new int[T+1];
        parent = new int[N+1]; 
        party = new ArrayList[M+1];
        
        // 진실을 아는 사람의 배열 초기화 
        for(int i=0; i<T; i++) {
            truth[i] = sc.nextInt();
        }
        // 대표 노드 초기화 
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }
        // 파티 데이터 ArrayList로 저장 
        for(int i=0; i<M; i++) {
            party[i] = new ArrayList<Integer>();
            int P = sc.nextInt();
            for(int j=0; j<P; j++) {
                party[i].add(sc.nextInt());
            }
        }
        
        // 파티에 참석한 모든 인원 union 
        for(int i=0; i<M; i++) {
            int first = party[i].get(0); 
            for(int j=1; j<party[i].size(); j++) {
                union(first, party[i].get(j));
            }
        }
        
        // 진실을 아는 사람과 같은 그룹에 속해있다면 FALSE
        int count = 0; 
        for(int i=0; i<M; i++) {
            boolean flag = true;
            int current = find(party[i].get(0));
            for(int j=0; j<truth.length; j++) {
                if(current == find(truth[j])) {
                    flag = false;
                }
            }
            if(flag) count++;
        }
        System.out.println(count);
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
            // 재귀 함수 형태로 구현 
            return parent[a] = find(parent[a]);
        }
    }
}