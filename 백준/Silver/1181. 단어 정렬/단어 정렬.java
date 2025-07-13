import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    Map<Integer, Set<String>> wordMap = new HashMap<>();
	    
	    int N = sc.nextInt();
	    for(int i=0; i<N; i++) {
	        String word = sc.next();
	        // TreeSet: 중복 제거 + 자동 정렬렬
	        wordMap
	           .computeIfAbsent(word.length(), k -> new TreeSet<>())
	           .add(word);
	    }
	    List<Integer> keySet = new ArrayList<>(wordMap.keySet());
        Collections.sort(keySet);
        
        for(int i=0; i<keySet.size(); i++) {
            for(String word : wordMap.get(keySet.get(i))) {
                System.out.println(word);
            }
        }
	}
}