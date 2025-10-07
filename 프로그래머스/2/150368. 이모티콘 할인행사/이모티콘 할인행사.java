import java.util.*;

class Solution {
    public int[] solution(int[][] users, int[] emoticons) {

        int N = (int) Math.pow(4, emoticons.length);
        int[] rate = new int[emoticons.length];
        int[] answer = new int[2];
        
        for(int i=0; i<N; i++) {
            // 해당 경우의 수의 비율 계산 
            for(int j=0; j<emoticons.length; j++) {
                // (i / 4^j) % 4: i의 4진수에서 j번째 자리의 값(0~3) 을 의미
                // 예: 003 -> 3 / 0 / 0 -> [40, 10, 10]
                // 0~3 -> 1~4로 만들기 위해 + 1 추가 
                rate[j] = 10 * (1 + (i / (int) Math.pow(4, j)) % 4);
            }
            
            int totalUser = 0;
            int totalSum = 0;
            for(int j=0; j<users.length; j++) {
                int sum = 0;
                boolean flag = false;
                for(int k=0; k<emoticons.length; k++) {
                    if(users[j][0] <= rate[k]) {
                        sum += emoticons[k] * (100 - rate[k]) / 100;
                    }
                    if(sum >= users[j][1]) {
                        flag = true;
                        totalUser++;
                        break;
                    }
                }
                if(!flag) totalSum += sum;
            }
            
            if(totalUser > answer[0]) {
                answer[0] = totalUser;
                answer[1] = totalSum;
            } else if(totalUser == answer[0] && totalSum > answer[1]) {
                answer[1] = totalSum;
            }
            
        }

        return answer;
    }
}