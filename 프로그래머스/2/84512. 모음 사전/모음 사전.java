import java.util.*;

class Solution {
    static String[] vowel = new String[]{"A", "E", "I", "O", "U"};
    static int count = 0;
    static int answer = 0;
    
    public int solution(String word) {
        dfs("", word);
        return answer - 1;
    }
    
    static void dfs(String now, String word) {
        if(now.length() > 5) return;
        
        count++;
        if(now.equals(word)) {
            answer = count;
            return;
        }
        
        for(int i=0; i<5; i++) {
            dfs(now + vowel[i], word);
        }
    }
}