class Solution {
    static int answer = 0;
    public int solution(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    isPrime(sum);
                }
            }
        }
        return answer;
    }
    
    public void isPrime(int n) {
         if(n<2) return;
         for(int i=2; i<=Math.sqrt(n); i++) {
             if(n%i==0) return;
         } 
        answer++;
    }
}