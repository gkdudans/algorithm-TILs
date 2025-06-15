import java.util.*;

class Solution {
    // 2차원 Set: 조합의 size() 및 중복 불가능이 중요 
    static Set<Set<String>> result = new HashSet<>();
    // 2차원 List: banned_id 하나마다 여러 후보 user_id 존재 
    static List<List<String>> candidates = new ArrayList<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        // candidate: banned_id와 매칭 가능한 user_id 리스트 
        for(String banned : banned_id) {
            List<String> candidate = new ArrayList<>();
            for (String user : user_id) {
                if (isMatch(user, banned)) {
                    candidate.add(user);
                }
            }
            candidates.add(candidate);
        }
        
        // 백트래킹으로 모든 조합 탐색
        backtrack(new HashSet<>(), 0);
        
        return result.size();
    }
    
    // 백트래킹 함수
    static void backtrack(Set<String> hashSet, int idx) {
        // 선택 종료 
        if(idx == candidates.size()) {
            result.add(new HashSet<>(hashSet));
            return;
        }
        
        // idx(banned_id)의 candidate들을 순회 
        for(String user : candidates.get(idx)) {
            if(!hashSet.contains(user)) {
                hashSet.add(user); // 현재 user 선택 
                backtrack(hashSet, idx+1); // 재귀 호출 (다음으로 이동) 
                hashSet.remove(user); // 되돌아오기 (= 백트래킹) 
            }
        }
    }
    
    static boolean isMatch(String user, String banned) {
        if(user.length() != banned.length()) return false;
        else {
            for(int i=0; i<user.length(); i++) {
                int u = user.charAt(i) - '*';
                int b = banned.charAt(i) - '*';
                if(b == 0) continue;
                else if(u != b) return false;
            }
            return true;
        }
    }
}