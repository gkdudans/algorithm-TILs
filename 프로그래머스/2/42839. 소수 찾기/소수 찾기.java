import java.util.*;

class Solution {
    static boolean[] visited; 
    static Set<Integer> uniqueNums;
    
    public int solution(String numbers) {
        // 숫자 배열로 변환 
        char[] digits = numbers.toCharArray(); 
        visited = new boolean[digits.length];
        uniqueNums = new HashSet<>();
        generateNum("", digits, visited);

        int answer = 0;
        for(int num : uniqueNums) {
            if(isPrime(num)) answer++;
        }
        return answer;
    }
    
    static void generateNum(String current, char[] digits, boolean[] visited) {
        // current가 빈 문자열이 아닌 경우 unique 체크해서 set에 집어넣음 
        if(!current.isEmpty()) {
            int num = Integer.parseInt(current);
            uniqueNums.add(num);
        }
        
        // digits에 대해 순열 생성
        for(int i=0; i<digits.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                generateNum(current+digits[i], digits, visited);
                visited[i] = false; // 백트래킹 
            }
        }
        
    }
    
    static boolean isPrime(int n) {
        if(n == 0) return false; 
        if(n == 1) return false;
        
        // 2 이상 ~ 루트 n까지 나눠지면 false return 
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n%i==0) return false;
        }
        return true; 
    }
}