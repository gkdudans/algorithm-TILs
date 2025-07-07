import java.util.*;

class Solution {
    static int[] parent;
    static int[] money;
    static Map<String, Integer> nameToIdx = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        parent = new int[enroll.length];
        money = new int[enroll.length];
        
        for(int i=0; i<enroll.length; i++) {
            nameToIdx.put(enroll[i], i);
        }
        
        for(int i=0; i<referral.length; i++) {
            if(referral[i].equals("-")) {
                parent[i] = -1;
            }
            else {
                parent[i] = nameToIdx.get(referral[i]);
            }
        }
        
        for(int i=0; i<seller.length; i++) {
            int index = nameToIdx.get(seller[i]);
            calculateMoney(index, amount[i]*100);
        }

        return money;
    }
    
    static void calculateMoney(int now, int value) {
        // 10%를 계산한 금액이 1원 미만인 경우 
        if(value / 10 < 1) {
            money[now] += value;
            return;
        }
        // 10%를 계산한 금액이 1원 이상인 경우 
        else {
            int nextValue = value / 10;
            // 배분할 추천인이 없는 경우 
            if(parent[now] == -1) {
                money[now] += (value - nextValue);
                return;
            } 
            // 배분할 추천인이 있는 경우
            else {
                money[now] += (value - nextValue);   
                calculateMoney(parent[now], nextValue); 
            }
        }
    }
}