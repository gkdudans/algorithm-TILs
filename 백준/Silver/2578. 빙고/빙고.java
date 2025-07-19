import java.util.*;
import java.io.*;

public class Main
{
	static Map<Integer,int[]> bingoMap=new HashMap<>();
	static int[] rowCnt=new int[5];
	static int[] colCnt=new int[5];
	static int[] diagCnt=new int[2];
	static boolean[] rowDone=new boolean[5];
	static boolean[] colDone=new boolean[5];
	static boolean[] diagDone=new boolean[2];
	static int bingoCount=0;

	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<5;i++){
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++){
				int now=Integer.parseInt(st.nextToken());
				bingoMap.put(now,new int[]{i,j});
			}
		}

		int answer=0;
		int callCount=0;
		
		outer: // 레이블 
		for(int i=0;i<5;i++){
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++){
				callCount++;
				
				int now=Integer.parseInt(st.nextToken());
				int[] loc=bingoMap.get(now);
				
				markAndCheck(loc[0],loc[1]);
				
				if(bingoCount>=3){
					answer=callCount;
					break outer; 
				}
			}
		}

		System.out.println(answer);
	}

	static void markAndCheck(int r,int c){
		// 행
		rowCnt[r]++;
		if(rowCnt[r]==5&&!rowDone[r]){
			rowDone[r]=true;
			bingoCount++;
		}
		
		// 열
		colCnt[c]++;
		if(colCnt[c]==5&&!colDone[c]){
			colDone[c]=true;
			bingoCount++;
		}
		
		// 대각선
		if(r==c){
			diagCnt[0]++;
			if(diagCnt[0]==5&&!diagDone[0]){
				diagDone[0]=true;
				bingoCount++;
			}
		}
		
		// 대각선
		if(r+c==4){
			diagCnt[1]++;
			if(diagCnt[1]==5&&!diagDone[1]){
				diagDone[1]=true;
				bingoCount++;
			}
		}
	}
}
