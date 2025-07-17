import java.util.*;
import java.io.*;

public class Main
{
    static int[] weights;
    static int[] heights;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		weights = new int[N];
		heights = new int[N];
		
		for(int i=0; i<N; i++) {
		    st = new StringTokenizer(br.readLine());
		    weights[i] = Integer.parseInt(st.nextToken()); 
		    heights[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
		    int score = 1;
		    for(int j=0; j<N; j++) {
		        if(i == j) continue;
		        else {
		            if(isBigger(i, j)) score++;
		        }
		    }
		    System.out.print(score + " ");
		}
	}
	
	static boolean isBigger(int a, int b) {
	    if(weights[a] < weights[b] && heights[a] < heights[b]) return true;
	    else return false;
	}
}