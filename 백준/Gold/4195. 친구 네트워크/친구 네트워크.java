import java.util.*;
import java.io.*;

public class Main
{
    static int[] parent;
    static int[] size;
        
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 테스트 케이스 수 
		
		for(int i=1; i<=N; i++) {
		    int K = Integer.parseInt(br.readLine()); // 친구 관계 수 
            parent = new int[K * 2]; 
            size = new int[K * 2];
            int count = 0;
		    
		    Map<String, Integer> nameIdMap = new HashMap();
		    // <name, count>로 저장 -> 새로운 name이면 union 
		    
		    for(int j=1; j<=K; j++) {
		        StringTokenizer st = new StringTokenizer(br.readLine());
		        String first = st.nextToken();
		        String second = st.nextToken();
		        
		        if (!nameIdMap.containsKey(first)) {
                    nameIdMap.put(first, count);
                    parent[count] = count;
                    size[count] = 1;
                    count++;
                }
                
                if (!nameIdMap.containsKey(second)) {
                    nameIdMap.put(second, count);
                    parent[count] = count;
                    size[count] = 1;
                    count++;
                }
                
                int firstId = nameIdMap.get(first);
                int secondId = nameIdMap.get(second);
                
                int root = union(firstId, secondId);
                int network = size[find(root)];
                
                System.out.println(network);
		    }
		}
	}
	
	// union 연산 
    static int union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
            size[a] += size[b];
        }
        return a; // root 반환 
    }
    
    // find 연산
    static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}