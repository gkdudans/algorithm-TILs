import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // [유저 아이디], [닉네임]
        Map<String, String> IdtoNickname = new HashMap<>();
        
        for(int i=0; i<record.length; i++) {
            String[] now = record[i].split(" ");
            if(now[0].equals("Enter") || now[0].equals("Change")) {
                IdtoNickname.put(now[1], now[2]);
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for(int i=0; i<record.length; i++) {
            String[] now = record[i].split(" ");
            String nickname = IdtoNickname.get(now[1]);
            if(now[0].equals("Enter")) {
                result.add(nickname + "님이 들어왔습니다.");
            } 
            else if(now[0].equals("Leave")) {
                result.add(nickname + "님이 나갔습니다.");
            } 
        }
        
        String[] answer = result.toArray(new String[0]);
        return answer;
    }
}