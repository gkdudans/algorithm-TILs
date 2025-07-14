import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> list = Arrays.stream(win_nums)
                            .boxed()
                            .collect(Collectors.toList());
        
        int winCount = 0;
        int zeroCount = 0;
        
        for(int num : lottos) {
            if(num == 0) zeroCount++;
            else if(list.contains(num)) winCount++;
        }
        
        int high = calculRateRank(winCount+zeroCount);
        int low = calculRateRank(winCount);

        int[] answer = {high, low};
        return answer;
    }
    
    static int calculRateRank(int n) {
        if(n<=1) return 6;
        else return 7 - n;
    }
}