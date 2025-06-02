import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 의상 종류별 개수 카운트하는 해시맵 정의 
        Map<String, Integer> categoryCount = new HashMap<>();
        
        for(String[] item : clothes) {
            String type = item[1];
            // HashMap.put(key, value)
            // getOrDefault: type이라는 키가 없으면 0 기본값, +1 
            categoryCount.put(type, categoryCount.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        for(int count : categoryCount.values()) {
            // (key, value) 중 count를 저장한 value를 순회
            answer *= (count + 1); // 안 입는 선택 포함 
        }
        
        return answer - 1;
    }
}