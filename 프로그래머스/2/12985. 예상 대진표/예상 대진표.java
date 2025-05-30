import java.util.*;

class Solution
{
    static long[] tree;
    public int solution(int n, int a, int b)
    {
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        int h = (int)Math.ceil(Math.log(n) / Math.log(2));
        int base = (int)Math.pow(2, h);
        tree = new long[4 * n];
        
        // 리프 노드
        for(int i=1; i<=n; i++) {
            tree[base+i] = i;
        } 
        // 트리 채우기
        for(int i=base; i>0; i--) {
            tree[i] = Math.min(tree[2*i], tree[2*i+1]);
        }
        
        int answer = getRound(base+a, base+b);
        return answer;
    }
    
    static int getRound(int start, int end) {
        int count = 0;
        
        while(start != end) {
            if(start%2==1) {
                start++;
            }
            if(end%2==0) {
                end--;
            }
            start /= 2;
            end /= 2;
            count++;
        }
        return count;
    }
} 