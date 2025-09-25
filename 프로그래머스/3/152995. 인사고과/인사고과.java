import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        
        boolean flag = true; // 완호가 인센티브를 받을 수 있는지 확인 
        for(int i=1; i<scores.length; i++) {
            if(scores[i][0] > scores[0][0] && scores[i][1] > scores[0][1]) {
                flag = false;
                break;
            }
        }
        int myScore = scores[0][0] + scores[0][1];
        
        if(!flag) return -1;
        else {
            ArrayList<int[]> A = new ArrayList<>(Arrays.asList(scores));
            
            A.sort((o1, o2) -> {
                // 2번째 점수 기준 오름차순
                if (o1[0] == o2[0]) return o1[1] - o2[1]; 
                // 1번재 점수 기준 내림차순 
                return o2[0] - o1[0]; 
            });
            
            ArrayList<Integer> sum = new ArrayList<>();
            int max = -Integer.MAX_VALUE;
            for(int[] score : A) {
                if(score[1] >= max) {
                    sum.add(score[0] + score[1]);
                    max = Math.max(max, score[1]);
                    
                }
            }
            
            int rank = 1;
            for (int score : sum) {
                if (score > myScore) rank++;
            }
            
            return rank;
            
        }
    }
}