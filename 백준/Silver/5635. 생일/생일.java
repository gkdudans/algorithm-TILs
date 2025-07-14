import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<LocalDate, String> students = new HashMap<>();
		
		int n = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
		    st = new StringTokenizer(br.readLine());
		    String name = st.nextToken();
		    int date = Integer.parseInt(st.nextToken());
		    int month = Integer.parseInt(st.nextToken());
		    int year = Integer.parseInt(st.nextToken());
		    LocalDate birth = LocalDate.of(year, month, date);
		    students.put(birth, name);
		}
		
		List<LocalDate> keySet = new ArrayList<>(students.keySet());
        Collections.sort(keySet);
		
		System.out.println(students.get(keySet.get(keySet.size()-1)));
		System.out.println(students.get(keySet.get(0)));
	}
}