import java.util.*;

class Solution {
    
    static Map<String, Integer> map = new HashMap<>();
    
    public int solution(String s) {
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            int now = s.charAt(i) - '0';
            if(0 <= now && now <= 9) sb.append(now);
            else {
                temp.append(s.charAt(i));
                int flag = isNum(temp.toString()); 
                if(flag != 10) {
                    sb.append(flag);
                    temp = new StringBuilder();
                } 
            }
        }
        
        String answer = sb.toString();
        return Integer.parseInt(answer);
    }
    
    static int isNum(String temp) {
        if(map.containsKey(temp)) {
            return map.get(temp);
        } else return 10;
    }
}