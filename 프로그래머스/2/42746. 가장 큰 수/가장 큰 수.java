import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] nums = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b)); 
        // a="3", b="30"을 비교했을 때 330과 303을 비교해 더 큰 값이 앞에 오도록 

        if (nums[0].equals("0")) return "0"; // 전부 0일 경우 예외 처리

        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            sb.append(num);
        }
        
        return sb.toString();
    }
}
