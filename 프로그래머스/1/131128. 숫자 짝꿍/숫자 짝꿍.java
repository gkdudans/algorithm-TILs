import java.io.*;
import java.util.*;

class Solution {
    static int[] arrX;
    static int[] arrY;
    static int[] result;

    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        arrX = new int[10];
        arrY = new int[10]; 
        result = new int[10];
        
        for(int i=0; i<X.length(); i++) {
            int c = X.charAt(i) - '0';
            arrX[c]++;
        }
        
        for(int i=0; i<Y.length(); i++) {
            int c = Y.charAt(i) - '0';
            arrY[c]++;
        }
        
        for(int i=9; i>0; i--) {
            result[i] = Math.min(arrX[i], arrY[i]);
            for(int j=0; j<result[i]; j++) {
                sb.append(i);
            }
        }
        
        if(sb.length() != 0) {
            result[0] = Math.min(arrX[0], arrY[0]);
            for(int j=0; j<result[0]; j++) {
                sb.append(0);
            }
        } else {
            result[0] = Math.min(arrX[0], arrY[0]);
            if(result[0] > 0) sb.append(0);
        }
    
        if (sb.length() == 0) {
            return "-1";
        }
        
        String answer = sb.toString();
        return answer;
    }
}