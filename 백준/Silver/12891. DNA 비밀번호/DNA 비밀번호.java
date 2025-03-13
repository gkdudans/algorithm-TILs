import java.util.*;

public class Main
{
    // 변수 선언 
    static int[] checkArr = new int [4];
	static int[] myArr = new int [4];
	static int checkSecret = 0;
		
	public static void main(String[] args) {
		// 입력 
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		int P = sc.nextInt();
		int count = 0;
		
        char[] A = sc.next().toCharArray();  
        for (int i = 0; i < 4; i++) {
            checkArr[i] = sc.nextInt();
            if (checkArr[i] == 0) checkSecret++;  
        }
        
		// 초기 상태 체크 
		for(int i=0; i<P; i++){
		    Add(A[i]);
		}
		if (checkSecret == 4) count++;
		
		// 슬라이딩 윈도우 사용
		for(int i=P; i<S; i++){ // i: 윈도우 오른쪽 끝
		    int j = i - P; // j: 윈도우 왼쪽 끝
		    
		    // 윈도우 한 칸 이동할 때마다 체크 
		    Add(A[i]);
		    Remove(A[j]);

		    if (checkSecret == 4) count++;
		}
		System.out.println(count);
	}
	
	// 오른쪽 한 칸 이동 
	public static void Add(char c){
	    if (c == 'A'){
	        myArr[0]++;
	        if (myArr[0] == checkArr[0]) checkSecret++;
	    }
	    else if (c == 'C'){
	        myArr[1]++;
	        if (myArr[1] == checkArr[1]) checkSecret++;
	    }
	    else if (c == 'G'){
	        myArr[2]++;
	        if (myArr[2] == checkArr[2]) checkSecret++;  
	    }
	    else if (c == 'T'){
	        myArr[3]++;
	        if (myArr[3] == checkArr[3]) checkSecret++;
	    }
	}
	
	public static void Remove(char c){
	    if (c == 'A'){
	        myArr[0]--;
	        if (myArr[0] == checkArr[0]-1) checkSecret--;
	    }
	    else if (c == 'C'){
	        myArr[1]--;
	        if (myArr[1] == checkArr[1]-1) checkSecret--;
	    }
	    else if (c == 'G'){
	        myArr[2]--;
	        if (myArr[2] == checkArr[2]-1) checkSecret--;  
	    }
	    else if (c == 'T'){
	        myArr[3]--;
	        if (myArr[3] == checkArr[3]-1) checkSecret--; 
	    }
	}
}