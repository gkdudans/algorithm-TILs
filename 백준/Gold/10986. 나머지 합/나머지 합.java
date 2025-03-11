import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] C = new int[M]; // 나머지 개수 카운트 배열
        long answer = 0;
        int sum = 0;

        // 누적 합 계산 + 나머지 연산
        for (int i = 0; i < N; i++) {
            sum = (sum + sc.nextInt()) % M;
            C[sum]++; // 나머지 값 카운트 증가
        }

        // 나머지가 0인 경우 (처음부터 해당하는 구간)
        answer += C[0];

        // 같은 나머지를 가진 경우 조합 계산
        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                answer += (long) C[i] * (C[i] - 1) / 2;
            }
        }

        System.out.println(answer);
    }
}
