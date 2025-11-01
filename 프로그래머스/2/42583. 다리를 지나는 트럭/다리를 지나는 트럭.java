import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Deque<Truck> queue = new ArrayDeque<>();
        int max = bridge_length * truck_weights.length + 1;
        
        queue.add(new Truck(1, truck_weights[0])); 
        int sum = truck_weights[0]; 
        int index = 1;
        int answer = 0;
        
        for(int t=2; t<=max; t++) {
            // 다리를 지난 트럭 추가
            if(t - queue.peek().t == bridge_length) {
                // System.out.printf("[%d]초 %d가 지남\n", t, queue.peek().weight);
                sum -= queue.peek().weight;
                queue.poll();
                
                if(index >= truck_weights.length && queue.isEmpty()) {
                    answer = t;
                    break;
                }
            }
            
            // 무게 체크해서 새로운 트럭 추가
            if(index < truck_weights.length && weight >= sum + truck_weights[index]) {
                // System.out.printf("[%d]초 %d 추가\n", t, truck_weights[index]);
                queue.add(new Truck(t, truck_weights[index]));
                sum += truck_weights[index];
                index++;
            }
        }
        
        return answer;
    }
    
    static class Truck {
        int t;
        int weight;
        
        Truck(int t, int weight) {
            this.t = t;
            this.weight = weight;
        }
    }
}

