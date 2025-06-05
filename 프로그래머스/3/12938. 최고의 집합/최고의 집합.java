class Solution {
    public int[] solution(int n, int s) {
        if(s < n) return new int[]{-1};
        int[] answer = new int[n];
        
        // 가장 곱이 커지도록 분할: s를 n개의 수로 분배할 때 가능한 한 균등하게 분배 
        int base = s / n;
        int remainder = s % n; 
        
        // n-remainder: s/n으로 채움 
        for(int i=0; i<n-remainder; i++) {
            answer[i] = base;
        }
        
        // remainder개: s/n + 1로 채움 
        for(int i=n-remainder; i<n; i++) {
            answer[i] = base + 1;
            
        }
        
        return answer;
    }
}