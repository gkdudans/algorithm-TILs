import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 종료 시점 기준으로 정렬 
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int lastCam = routes[0][1];
        int count = 1;
        
        for(int i=0; i<routes.length; i++) {
            int enter = routes[i][0];
            int exit = routes[i][1];
            
            // 카메라를 추가로 설치하지 않아도 되는 경우
            if(lastCam >= enter) continue;
            else {
                count++;
                lastCam = exit;
            }
        }
        
        return count;
    }
}