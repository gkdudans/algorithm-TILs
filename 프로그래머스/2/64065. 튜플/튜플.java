import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        // s의 중첩 {}를 나눈다.
        // 가장 원소의 개수가 작은 것부터 탐색해서
        // List에 넣고, 그걸 다시 int[]로 변환해서
        // 정답을 출력하면 된다.
        
        // 1. s의 바깥쪽 {}를 제거한다.
        String inner = s.substring(2, s.length() - 2);
        
        // 2. s의 안쪽을 {} 단위로 쪼개고, 길이 오름차순 정렬한다.
        String[] parts = inner.split("\\},\\{");
        Arrays.sort(parts, Comparator.comparingInt(a -> a.split(",").length));
        
        // 3.
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        
        for(String part : parts) {
            for (String t : part.split(",")) {
                // Set.add는 새 원소 추가되면 true를 반환 
                int a = Integer.parseInt(t);
                if (seen.add(a)) result.add(a);
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}