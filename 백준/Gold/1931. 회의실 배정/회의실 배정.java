import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    // 입력 
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Meeting> meetings = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
		    int s = sc.nextInt();
		    int e = sc.nextInt();
		    meetings.add(new Meeting(s, e));
		}
		
		// 정렬 
		meetings.sort((a, b) -> {
		    // e 기준 오름차순 
            if (a.e != b.e) return a.e - b.e;
            // e가 같으면 s 기준 오름차순 
            return a.s - b.s;  
        });
        
        int count = 1;
        int temp = meetings.get(0).e;
        
        for(int i=1; i<N; i++) {
            if(temp <= meetings.get(i).s) {
                temp = meetings.get(i).e;
                count++;
            }
        }
        System.out.println(count);
	}
	
	public static class Meeting {
	    int s, e;
	    
	    Meeting(int s, int e) {
	        this.s = s;
	        this.e = e;
	    }
	}
}