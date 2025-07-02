import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int num = 0;
        int count = 0;
        Set<String> wordlist = new HashSet<>();
        
        boolean flag = false;
        for(int i=0; i<words.length; i++) {
            // 글자수 검사
            if(words[i].length() <= 1) flag = true;
            
            // 중복 검사
            if(wordlist.contains(words[i])) flag = true;
            
            // 유효성 검사
            if(i > 0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) flag = true;

            
            if(flag) {
                num = i%n + 1;
                count = i/n + 1;
                break;
            } else {
                wordlist.add(words[i]);
            }
        }
        
        int[] answer = {num, count};
        return answer;
    }
}