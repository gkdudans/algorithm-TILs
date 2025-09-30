import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Student> countMap = new HashMap<>();
		PriorityQueue<Student> pq = new PriorityQueue<>();
		
		for(int i=0; i<M; i++) {
		    int now = Integer.parseInt(st.nextToken());
		    
		    if (countMap.containsKey(now)) {
                Student prev = countMap.get(now);
                pq.remove(prev);
                // 게시된 지 가장 오래된 사진을 삭제 -> Index 업데이트 X
                Student updated = new Student(prev.num, prev.count + 1, prev.lastIndex);
                countMap.put(now, updated);
                pq.offer(updated);
            } else {
                if (countMap.size() >= N) {
                    Student victim = pq.poll();
                    countMap.remove(victim.num);
                } 
                Student student = new Student(now, 1, i);
                countMap.put(now, student);
                pq.add(student);
            }
		}
		
		List<Student> A = new ArrayList<>(pq);
		A.sort((o1, o2) -> {
		    return o1.num - o2.num;
		});
		
		for(int i=0; i<A.size(); i++) {
		    System.out.printf(A.get(i).num + " ");
		}
	}
	
	static class Student implements Comparable<Student> {
	    int num;
	    int count;
	    int lastIndex;
	    
	    Student(int num, int count, int lastIndex) {
	        this.num = num;
	        this.count = count;
	        this.lastIndex = lastIndex;
	    }
	    
	    @Override
	    public int compareTo(Student o) {
	        // lastIndex 기준 오름차순 
	        if(this.count == o.count) return this.lastIndex - o.lastIndex;
	        // count 기준 오름차순 
	        return this.count - o.count;
	    }
	}
}