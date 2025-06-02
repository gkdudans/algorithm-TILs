import java.util.*;

class Solution {
    static Set<Integer> kinds = new HashSet<>();
    
    public int solution(int[] nums) {
        int size = nums.length / 2;
        
        for(int num : nums) {
            kinds.add(num); 
        }

        return Math.min(kinds.size(), size);
    }
}