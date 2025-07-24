import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        
        int answer = 0;
        
        PriorityQueue<Integer> AQueue = new PriorityQueue<>();
        PriorityQueue<Integer> BQueue = new PriorityQueue<>(Collections.reverseOrder()); 

        for(int i=0; i<A.length; i++) {
            AQueue.add(A[i]);
            BQueue.add(B[i]);
        }
        
        for(int i=0; i<A.length; i++) {
            answer += AQueue.poll() * BQueue.poll();
        }
        
        
        return answer;
    }
}