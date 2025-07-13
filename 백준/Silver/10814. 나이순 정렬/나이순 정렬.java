import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    List<Member> memberList = new ArrayList<>();
	    
	    for(int i=0; i<N; i++) {
	        st = new StringTokenizer(br.readLine());
	        int age = Integer.parseInt(st.nextToken());
	        String name = st.nextToken();
	        memberList.add(new Member(age, name));
	    }
	    
	    Collections.sort(memberList);
	    
	    for(int i=0; i<memberList.size(); i++) {
	        System.out.println(memberList.get(i).age + " " + memberList.get(i).name);
	    }

	}
	
	static class Member implements Comparable<Member> {
	    int age;
	    String name;
	    
	    Member(int age, String name) {
	        this.age = age;
	        this.name = name;
	    }
	    
	    @Override
	    public int compareTo(Member o) {
	        return Integer.compare(this.age, o.age);
	    }
	}
}