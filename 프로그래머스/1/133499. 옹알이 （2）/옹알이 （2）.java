import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        set.add("aya");
        set.add("ye");
        set.add("woo");
        set.add("ma");
        
        for(int i=0; i<babbling.length; i++) {
            String word = "";
            String prev = "";
            boolean flag = true;
            for(int j=0; j<babbling[i].length(); j++) {
                String now = String.valueOf(babbling[i].charAt(j));
                word = word + now;

                if(word.length() >= 4) flag = false;
                if (set.contains(word)) {
                    if(prev.equals(word)) flag = false;
                    else {
                        prev = word;
                        word = "";
                    }
                } else {
                    continue;
                }
            }
            if(!word.isBlank()) flag = false;
            if(flag) answer++;
        }
        
        return answer;
    }
}