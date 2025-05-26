import java.io.*;
import java.util.*;

public class Main
{
    static int N;
    static List<Edge> edgeList = new ArrayList<>(); // 간선 정보 저장 
    static int total = 0; // 랜선 길이의 총합 
    static int mstCost = 0; // 필요 랜선 길이 총합 
    static int connectCount = 0; // 간선 개수 count 
    static int[] parent;; // union find용 부모 배열 
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[N];

        // 부모 배열: 자기 자신을 부모로 설정 
		for (int i=0; i<N; ++i) {
			parent[i] = i;
		} 
		
		// 간선 정보 저장 
		for(int i=0; i<N; i++) {
		    String line = br.readLine();
		    for(int j=0; j<N; j++) {
		        int value = charToLength(line.charAt(j));
		        total += value; 
		        if (i != j && value > 0) {
		            edgeList.add(new Edge(i, j, value));
		        }
		    }
		}
		
	
		/*
		* Kruskal 알고리즘: Edge List 사용 
		* cycle이 발생하는지 확인하기 위해 Union Find 사용 
		* 가중치가 작은 간선부터 꺼내서, 사이클이 생기지 않으면 MST에 포함 
		*/
		Queue<Edge> pq = new PriorityQueue<>();
		pq.addAll(edgeList);
		
		
		while(!pq.isEmpty() && connectCount < N-1) {
		    Edge now = pq.poll();
		    int nowFrom = now.from;
		    int nowTo = now.to;
		    
		    // 사이클이 발생하지 않을 경우에만 연결 
		    if (find(nowFrom) != find(nowTo)) {
		        // 이미 연결되지 않은 경우에만 union 
		        union(nowFrom, nowTo);
		        mstCost += now.weight; // MST에 포함된 간선 길이 누적 
		        connectCount++; // 연결된 간선 수 증가 
		    }
		}
		
		if(connectCount != N-1) {
		    // MST를 만들 수 없는 경우 
		    System.out.println(-1); 
		} else {
		    // 기부 랜선 길이 = 전체 - MST에 필요한 랜선 길이 
		    System.out.println(total - mstCost);
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
            // 재귀 함수 형태로 구현 
            return parent[a] = find(parent[a]);
        }
    }
	
	// 간선 클래스 
	static class Edge implements Comparable<Edge> {
	    int from, to, weight;
	    
	    public Edge(int from, int to, int weight) {
	        this.from = from;
	        this.to = to;
	        this.weight = weight;
	    }
	    
	    // 오름차순 정렬을 위한 비교 
	    @Override
	    public int compareTo(Edge o) {
	        return this.weight - o.weight;
	    }
	}
	
	// 문자 → 정수 가중치로 변환 
	// ('a'~'z' = 1~26, 'A'~'Z' = 27~52, '0' = 0) 
	static int charToLength(char c) {
	    if (c == '0') return 0;
	    if ('a' <= c && c <= 'z') return c - 'a' + 1;
	    if ('A' <= c && c <= 'Z') return c - 'A' + 27;
	    return 0;
	}
}