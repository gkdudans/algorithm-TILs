import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        mData[] A = new mData[N];
        
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            A[i] = new mData(value, i);
        }

        // 정렬 (value 기준 오름차순)
        Arrays.sort(A);

        // 최대 인덱스 변화값 (전 - 후)
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < A[i].index - i) {
                max = A[i].index - i;
            }
        }

        System.out.println(max + 1);
    }
}

class mData implements Comparable<mData> {
    int value, index;

    public mData(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o) {
        return Integer.compare(this.value, o.value);
    }
}
