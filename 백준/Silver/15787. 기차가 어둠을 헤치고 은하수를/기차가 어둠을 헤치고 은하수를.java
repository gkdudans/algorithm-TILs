import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] train = new int[N + 1];           
        final int MASK20 = (1 << 20) - 1; 

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());

            switch (flag) {
                case 1: { 
                    int i = Integer.parseInt(st.nextToken());
                    int x = Integer.parseInt(st.nextToken());

                    // 좌석 x 비트를 1로 
                    // 비트 (x-1)만 1이고 나머지는 0인 마스크를 생성해 OR 할당
                    train[i] |= (1 << (x - 1)); 
                    break;
                }
                case 2: { 
                    int i = Integer.parseInt(st.nextToken());
                    int x = Integer.parseInt(st.nextToken());

                    // 좌석 x 비트를 0으로
                    // 비트 (x-1)만 0이고 나머지는 1인 마스크를 생성해 AND 할당
                    train[i] &= ~(1 << (x - 1));
                    break;
                }
                case 3: {
                    int i = Integer.parseInt(st.nextToken());

                    // 모든 승객을 한 칸 뒤로
                    // 왼쪽으로 한 비트 이동하고 하위 20비트만 유지 
                    train[i] = (train[i] << 1) & MASK20;
                    break;
                }
                case 4: {
                    int i = Integer.parseInt(st.nextToken());

                    // 모든 승객을 한 칸 앞으로
                    // 부호 없이 오른쪽으로 한 비트 이동
                    train[i] >>>= 1; 
                    break;
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) set.add(train[i]);
        System.out.println(set.size());
    }
}
