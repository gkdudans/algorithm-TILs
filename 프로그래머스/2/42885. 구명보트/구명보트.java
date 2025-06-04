import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        
        int s = 0;
        int e = people.length-1;
        
        while(s <= e) {
            if(s == e) {
                answer++;
                break;
            }
            
            if(people[s] + people[e] <= limit) {
                answer++;
                s++;
                e--;
            } else {
                answer++;
                e--;
            }
        } 

        return answer;
    }
}