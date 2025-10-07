import java.util.*;

class Solution {
    static Map<String, Integer> menuMap = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        
        ArrayList<Integer>[] A = new ArrayList[course.length];
        for(int i=0; i<course.length; i++) {
            A[i] = new ArrayList<>();
        }
        
        List<String> result = new ArrayList<>();

        // 1. menuMap에 <메뉴 구성, 카운트> 저장 
        for (String order : orders) {
            char[] menus = order.toCharArray();
            Arrays.sort(menus);
            
            for (int c : course) {
                if (menus.length < c) continue;
                combine(menus, 0, c, new StringBuilder());
            }
        }
        
        // 2. course마다 maxCount, 코스요리 메뉴 구성후보 저장
        for (int c : course) {
            int maxCount = 0;
            for (Map.Entry<String, Integer> e : menuMap.entrySet()) {
                if (e.getKey().length() == c) {
                    maxCount = Math.max(maxCount, e.getValue());
                }
            }
            if (maxCount < 2) continue; // 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합
            for (Map.Entry<String, Integer> e : menuMap.entrySet()) {
                if (e.getKey().length() == c && e.getValue() == maxCount) {
                    result.add(e.getKey());
                }
            }
        }
        
        // 3. 오름차순 정렬 
        Collections.sort(result);

        String[] answer = result.toArray(new String[0]);
        return answer;
    }
    
    static void combine(char[] menus, int start, int course, StringBuilder sb) {
        if(sb.length() == course) {
            menuMap.put(sb.toString(), menuMap.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        for(int i=start; i<menus.length; i++) {
            sb.append(menus[i]);
            combine(menus, i+1, course, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}