import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> phoneNums = new HashSet<>();
        
        for(String num : phone_book) {
            phoneNums.add(num);
        }
        
        // 접두어 탐색
        for(String num : phone_book) {
            for(int i=1; i<num.length(); i++) {
                String prefix = num.substring(0, i);
                if(phoneNums.contains(prefix)) return false;
            }
        }
        return true;
    }
}