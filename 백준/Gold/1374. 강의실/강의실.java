import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Course> A = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A.add(new Course(start, end));
        }

        // 시작시간 기준으로 정렬 
        Collections.sort(A, (c1, c2) -> c1.start - c2.start);
        // 종료시간 기준으로 정렬 
        PriorityQueue<Course> pq = new PriorityQueue<>((c1, c2) -> c1.end - c2.end);
        
        for (Course now : A) {
            // 강의실 재사용 가능: 현재 강의를 pq에 넣고 가장 빨리 끝나는 강의 pq에서 poll 
            if (!pq.isEmpty() && pq.peek().end <= now.start) {
                pq.poll();
            }
            pq.offer(now);
        }
        
        System.out.println(pq.size());
    }
    
    static class Course{
        int start;
        int end;

        Course(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
}
