import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Map<Character, int[]> shortcut = new HashMap<>();
		String[] inputs = new String[N];
		
		for(int i=0; i<N; i++) {
		    String input = br.readLine();
		    inputs[i] = input;
		    String[] now = input.split(" ");
		    
		    boolean flag = false;
		    
		    // now.length: 단어의 개수만큼 
		    for(int j=0; j<now.length; j++) {
		        char first = Character.toLowerCase(now[j].charAt(0));
		        
		        if(!shortcut.containsKey(first)) {
		            flag = true;
		            shortcut.put(first, new int[]{i, j, 0});
		            break;
		        }
		    }
		    
		    if(!flag) {
		        outer:
		        for(int j=0; j<now.length; j++) {
		            for(int k=1; k<now[j].length(); k++) {
		                char second = Character.toLowerCase(now[j].charAt(k));
		                
        		        if(!shortcut.containsKey(second)) {
        		            flag = true;
        		            shortcut.put(second, new int[]{i, j, k});
        		            break outer;
        		        }
		            }
		        }
		    }
		}
		
		for (int i = 0; i < N; i++) {
            String[] words = inputs[i].split(" ");
            StringBuilder sb = new StringBuilder();

            boolean flag = false;
            
            for (int j = 0; j < words.length; j++) {
                String word = words[j];
                boolean secondFlag = false;
                
                // 단축키로 지정되었는지 탐색 
                for (Map.Entry<Character, int[]> entry : shortcut.entrySet()) {
                    int[] pos = entry.getValue();

                    if (pos[0] == i && pos[1] == j && !flag) {
                        int idx = pos[2];
                        sb.append(word, 0, idx)
                          .append("[")
                          .append(word.charAt(idx))
                          .append("]")
                          .append(word.substring(idx + 1));
                        secondFlag = true;
                        flag = true;
                        break;
                    }
                }
                // 단축키로 지정되지 않은 경우 
                if (!secondFlag) {
                    sb.append(word);
                }
                // 단어 사이에 공백 
                if (j != words.length - 1) sb.append(" "); 
            }
            System.out.println(sb);
        }
	}
}