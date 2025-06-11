import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqr = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> multiset = new HashMap<>();
        
        for(int i=0; i<operations.length; i++) {
            String[] parts = operations[i].split(" ");
            if(parts[0].equals("I")) {
                int num = Integer.parseInt(parts[1]);
                pq.add(num);
                pqr.add(num);
                multiset.put(num, multiset.getOrDefault(num, 0) + 1);
            } else {
                if(multiset.isEmpty()) continue;

                if(parts[1].equals("1")) {
                    while(!pqr.isEmpty()) {
                        int num = pqr.poll();
                        if(multiset.containsKey(num)) {
                            if(multiset.get(num) == 1) {
                                multiset.remove(num);
                            } else {
                                multiset.put(num, multiset.get(num) - 1);
                            }
                            break;
                        }
                    }
                } else {
                    while(!pq.isEmpty()) {
                        int num = pq.poll();
                        if(multiset.containsKey(num)) {
                            if(multiset.get(num) == 1) {
                                multiset.remove(num);
                            } else {
                                multiset.put(num, multiset.get(num) - 1);
                            }
                            break;
                        }
                    }
                }
            }  
        }
        
        if(multiset.isEmpty()) return new int[]{0, 0};
        else {
            int max = 0;
            while(!pqr.isEmpty()) {
                int num = pqr.poll();
                if(multiset.containsKey(num)) {
                    max = num;
                    break;
                }
            }
            int min = 0;
            while(!pq.isEmpty()) {
                int num = pq.poll();
                if(multiset.containsKey(num)) {
                    min = num;
                    break;
                }
            }
            return new int[]{max, min};
        }
    }
}
