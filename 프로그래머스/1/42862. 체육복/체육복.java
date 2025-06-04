import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        
        for (int l : lost) lostSet.add(l);
        for (int r : reserve) {
            if (lostSet.contains(r)) {
                // 여벌도 있고 도난도 당한 경우 
                lostSet.remove(r);
                answer++;
            } else {
                reserveSet.add(r);
            }
        }
        
        List<Integer> reserveList = new ArrayList<>(reserveSet);
        Collections.sort(reserveList); 

        for(int r : reserveList) {
            if(lostSet.contains(r-1)) {
                lostSet.remove(r-1);
                answer++;
            } else if(lostSet.contains(r+1)) {
                lostSet.remove(r+1);
                answer++;
            }
        }
               
        return answer;     
    }
}