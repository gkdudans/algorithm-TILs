import java.io.*;
import java.util.*;

class Solution {
    static int[] arrX;
    static int[] arrY;
    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String X = br.readLine();
        for(int i=0; i<X.length(); i++) {
            arrX[i] = X.charAt(i);
        }
        
        String Y = br.readLine();
        for(int i=0; i<Y.length(); i++) {
            arrY[i] = Y.charAt(i);
        }
        
        Arrays.sort(arrX);
        Arrays.sort(arrY);
        
        for(int i=0; i<arrX.length; i++) {
            System.out.println(arrX[i]);
        }
        
        
        
        
        
        
	} 
    
    

    public String solution(String X, String Y) {
        String answer = "";
        return answer;
    }
}