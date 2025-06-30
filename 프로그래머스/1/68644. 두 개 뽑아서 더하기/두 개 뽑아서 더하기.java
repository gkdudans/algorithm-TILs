import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> sums = new HashSet<>();
        
        for(int i=0; i<numbers.length; i++) {
            for(int j=0; j<numbers.length; j++) {
                if(i == j) continue;
                sums.add(numbers[i] + numbers[j]);
            }
        }
        
        List<Integer> sortedList = new ArrayList<>(sums);
        Collections.sort(sortedList);
        int[] answer = new int[sortedList.size()];
        
        for(int i=0; i<sortedList.size(); i++){
            answer[i] = sortedList.get(i);
        }
        
        return answer;
    }
}