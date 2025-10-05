import java.util.*;

class Solution {

    static ArrayList<Integer>[] A;
    static Map<Integer, int[]> usedCount; 
    static List<String> result = new ArrayList<>();
    static Map<String, Integer> idxMap = new HashMap<>();
    static Map<Integer, String> valueMap = new HashMap<>();
    static String[] answer;
    static boolean flag;

    public String[] solution(String[][] tickets) {

        A = new ArrayList[tickets.length * 2 + 1];
        for (int i = 0; i <= tickets.length * 2; i++) {
            A[i] = new ArrayList<>();
        }

        // 매핑
        for (int i = 0; i < tickets.length; i++) {
            String s = tickets[i][0];
            int s_index = idxMap.computeIfAbsent(s, k -> {
                int id = idxMap.size();
                valueMap.put(id, k);
                return id;
            });
            String e = tickets[i][1];
            int e_index = idxMap.computeIfAbsent(e, k -> {
                int id = idxMap.size();
                valueMap.put(id, k);
                return id;
            });
            A[s_index].add(e_index);
        }

        // 알파벳 순 정렬
        for (int i = 0; i < idxMap.size(); i++) {
            A[i].sort(Comparator.comparing(valueMap::get));
        }

        // 중복 티켓을 고려
        // key: 출발지, value: 목적지 개수만큼 0으로 채워진 int[] 
        usedCount = new HashMap<>();
        for(int i=0; i<idxMap.size(); i++) {
            usedCount.put(i, new int[A[i].size()]);
        }

        result.add("ICN"); 
        dfs(idxMap.get("ICN"), tickets, 0);

        return answer;
    }

    static void dfs(int now, String[][] tickets, int count) {
        if (flag) return;

        if (count == tickets.length) {
            answer = result.toArray(new String[0]);
            flag = true;
            return;
        }

        int[] used = usedCount.get(now);
        for (int i=0; i<A[now].size(); i++) {
            int next = A[now].get(i);
            // 0이면 사용 전, 1이면 사용 
            if (used[i] == 0) {
                used[i] = 1; 
                result.add(valueMap.get(next));

                dfs(next, tickets, count+1);
                // 백트래킹 
                result.remove(result.size()-1);
                used[i] = 0; 
            }
        }
    }
}
