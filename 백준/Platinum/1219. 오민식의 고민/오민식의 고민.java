import java.util.*;
import java.io.*;

public class Main
{
    static long[] totalCost; // 도시별 최대 이익
    static long[] earn;      // 도시 방문 시 얻는 수입
    static ArrayList<Edge>[] A;
    static ArrayList<Integer>[] revA;
    static final long INF = -Long.MAX_VALUE;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력: N=도시 수, S=시작 도시, E=도착 도시, M=간선 수
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 배열 및 인접 리스트 초기화
        totalCost = new long[N];
        earn = new long[N];
        A = new ArrayList[N];
        revA = new ArrayList[N];
        for(int i=0; i<N; i++){
            totalCost[i] = INF;
            A[i] = new ArrayList<Edge>();
            revA[i] = new ArrayList<Integer>();
        }

        // 간선 정보 입력 및 저장
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            A[s].add(new Edge(e,v));
            revA[e].add(s);
        }

        // 벌 수 있는 돈 정보 저장
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            earn[i] = Long.parseLong(st.nextToken());
        }

        // S로부터 도달 가능한 노드 표시
        boolean[] reachableFromStart = new boolean[N];
        dfsEdge(S, reachableFromStart);

        // E로부터 (역그래프) 도달 가능한 노드 표시
        boolean[] reachableToEnd = new boolean[N];
        dfsInt(E, reachableToEnd);

        // 시작 도시는 방문만 해도 수익을 얻도록 초기화
        totalCost[S] = earn[S];

        /*
         * 벨만-포드 알고리즘 변형
         * 최대 이익 경로 탐색
         * N-1회 반복하면서 모든 간선 완화
         * N번째 반복에서 추가 완화 발생 시 무한 이익(사이클) 판단
         */
        for(int i=0; i<N; i++){
            for(int u=0; u<N; u++){
                for(Edge edge : A[u]){
                    int n = edge.n;
                    long cost = earn[n]-edge.v;
                    if(totalCost[u] == INF) continue;  // 아직 못 간 곳
                    if(totalCost[n] < totalCost[u] + cost){
                        totalCost[n] = totalCost[u] + cost;
                        // N-1번째 반복 이후에도 갱신되면 사이클
                        if(i == N-1 && reachableFromStart[u] && reachableToEnd[n]){
                            System.out.println("Gee");
                            return;
                        }
                    }
                }
            }
        }

        // 최종 출력: 도달 불가 시 "gg", 아니면 최대 이익
        if(totalCost[E] == INF){
            System.out.println("gg");
        } else {
            System.out.println(totalCost[E]);
        }
    }

    // 원본 그래프를 타고 S로부터 방문 가능한 노드 표시
    static void dfsEdge(int u, boolean[] vis){
        vis[u] = true;
        for(Edge e : A[u]){
            if(!vis[e.n]) dfsEdge(e.n, vis);
        }
    }

    // 역그래프를 타고 E로부터 도달 가능한 노드 표시
    static void dfsInt(int u, boolean[] vis){
        vis[u] = true;
        for(int v : revA[u]){
            if(!vis[v]) dfsInt(v, vis);
        }
    }

    // 정점 클래스: 목적지 도시 n, 교통 비용 v
    static class Edge
    {
        int n, v;
        Edge(int n, int v){
            this.n = n;
            this.v = v;
        }
    }
}
