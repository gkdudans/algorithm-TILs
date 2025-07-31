import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); 
        Balloon[] balloons = new Balloon[N];

        for (int i = 0; i < N; i++) {
            int move = sc.nextInt();
            balloons[i] = new Balloon(i + 1, move);  
        }

        boolean[] visited = new boolean[N];  
        int current = 0;  // 현재 위치
        int count = 0;    // 터진 풍선 개수

        StringBuilder sb = new StringBuilder();

        while (count < N) {
            int move = balloons[current].move;

            // 현재 풍선 터뜨리기
            visited[current] = true;
            sb.append(balloons[current].idx).append(" ");
            count++;

            if (count == N) break;

            int step = 0;
            while (step < Math.abs(move)) {
                if (move > 0) {
                    current++;
                    if (current == N) current = 0;
                } else {
                    current--;
                    if (current == -1) current = N - 1;
                }

                // 살아 있는 풍선만 이동  
                if (!visited[current]) {
                    step++;
                }
            }
        }

        System.out.println(sb);
    }
    
    static class Balloon {
        int idx;    // 풍선 번호
        int move;   // 이동 값

        Balloon(int idx, int move) {
            this.idx = idx;
            this.move = move;
        }
    }
}
