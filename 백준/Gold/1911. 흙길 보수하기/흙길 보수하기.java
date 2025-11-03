import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		List<Poll> polls = new ArrayList<>();
		for(int i=0; i<N; i++) {
		    st = new StringTokenizer(br.readLine());
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    polls.add(new Poll(s, e));
		}
		
		Collections.sort(polls);
		
		Deque<Integer> stack = new ArrayDeque<>();
	    // 시작점 
	    Poll start = polls.get(0);
	    int result = (int) Math.ceil((double)(start.e - start.s) / L);
	    int sum = result;
	    int end = start.s + result*L - 1;
	    stack.push(end);
		
		for(int i=1; i<polls.size(); i++) {
		    Poll now = polls.get(i);
		    
		    if(now.s > stack.peek()) {
		        result = (int) Math.ceil((double)(now.e - now.s) / L);
		        end = now.s + result*L - 1;
		    } else {
		        result = (int) Math.ceil((double)(now.e - stack.peek() - 1) / L);
		        end = stack.peek() + result*L;
		    }
		    sum += result;
		    stack.push(end);
		}
		System.out.println(sum);
	}
	
	static class Poll implements Comparable<Poll> {
	    int s;
	    int e;
	    
	    Poll(int s, int e) {
	        this.s = s;
	        this.e = e;
	    }
	    
	    @Override
	    public int compareTo(Poll o) {
	        if(this.s == o.s) return this.e - o.e;
	        return this.s - o.s;
	    }
	}
}