import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) return cities.length * 5;

        Map<String, Integer> cityMap = new HashMap<>();

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();

            if (cityMap.containsKey(city)) {
                // cache hit
                answer += 1;
                cityMap.put(city, i); // 덮어쓰기
            } else {
                // cache miss
                answer += 5;
                if (cityMap.size() == cacheSize) {
                    int minVal = Collections.min(cityMap.values());
                    cityMap.entrySet().removeIf(e -> e.getValue().equals(minVal));
                }
                cityMap.put(city, i);
            }
        }

        return answer;
    }
}
