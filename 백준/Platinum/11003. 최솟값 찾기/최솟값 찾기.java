import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        // N개의 수에 대한 슬라이딩 윈도우(덱) 
        Deque<Node> nodeDeque = new LinkedList<>();
        
        st = new StringTokenizer(br.readLine()); 
        
        for (int i = 1; i <= N; i++) {
            int newValue = Integer.parseInt(st.nextToken());
            
            while (!nodeDeque.isEmpty() && nodeDeque.getLast().value >= newValue) {
                nodeDeque.removeLast();
            }

            nodeDeque.addLast(new Node(newValue, i));
            
            if (nodeDeque.getFirst().index <= i - L) {
                nodeDeque.removeFirst();
            }
            
            sb.append(nodeDeque.getFirst().value).append(" ");
        }
        
        // 한 번에 출력
        System.out.println(sb.toString());
    }
    
    static class Node {
        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
