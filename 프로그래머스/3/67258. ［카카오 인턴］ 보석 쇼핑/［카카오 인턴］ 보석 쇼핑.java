import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // 보석 종류 개수 N
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));
        int N = gemSet.size();
        int[] answer = new int[2];
        
        // 윈도우에 포함된 각 보석 개수 카운트
        // key: 보석 종류, value: 각 보석 개수 
        Map<String, Integer> window = new HashMap<>();
        
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        
        // end 왼쪽으로 이동하면서 반복 
        while(end < gems.length) {
            window.put(gems[end], window.getOrDefault(gems[end], 0) + 1);
            end++;
            
            while(window.size() == N) {
                if(end-start < min) {
                    min = end - start;
                    answer[0] = start + 1;    
                    answer[1] = end; 
                } 
                // start 오른쪽으로 이동
                // gem[start]의 개수 하나 제거
                window.put(gems[start], window.get(gems[start]) - 1);
                if (window.get(gems[start]) == 0) {
                    window.remove(gems[start]);
                }
                start++;
            }
        }
        return answer;
    }
}
