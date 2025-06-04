class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long max = 0;
        long start = 1;
        for (int time : times) {
            if (time > max) max = time;
        }
        long end = (long) max * n;
        
        answer = binarySearch(start, end, n, times);
        return answer;
    }
    
    static long binarySearch(long s, long e, int n, int[] times) {
        long answer = 0;
        while (s <= e) {
            long mid = (s + e) / 2;
            long count = countResult(mid, times); 
            
            if(count >= n) {
                answer = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return answer;
        
    } 
    
    // mid분 으로 처리 가능한 사람 수 개산 
    static long countResult(long mid, int[] times) {
        long count = 0;
        for(int i=0; i<times.length; i++) {
            count += mid / times[i];
        }
        return count;
    }
}