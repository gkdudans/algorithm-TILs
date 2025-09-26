import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        // 1. col번째 컬럼 기준 오름차순 / 1번째 컬럼 기준 내림차순 정렬
        Arrays.sort(data, (o1, o2) -> {
                 if(o1[col-1] == o2[col-1]) return o2[0] - o1[0];
                 return o1[col-1] - o2[col-1];
        });
        
        // 2. S_i를 구하고, row_begin <= S_i <= row_end라면 누적한다.
        int[] sumList = new int[data.length + 1];
        
        for(int i=row_begin-1; i<row_end; i++) {
            int sum = 0;
            for(int j=0; j<data[i].length; j++) {
                sum += (data[i][j] % (i + 1));
            }
            sumList[i] = sum;
        }
        
        // 3. 출력: bitwise XOR 한 값을 구한다. 
        int answer = -1;
        for(int i=1; i<=data.length; i++) {
            if(sumList[i] == 0) continue;
            else {
                if(answer == -1) answer = sumList[i];
                else {
                   answer = answer ^ sumList[i]; 
                }
            }
        }
        
        if(answer != -1) return answer;
        else return 0;
    }
}