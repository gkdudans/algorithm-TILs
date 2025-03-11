import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] score = new int[N];
		int max = 0;
		
		for(int i=0; i<N; i++){
		    score[i] = sc.nextInt();
		    if (score[i] > max) max = score[i];
		}
		
		double[] resultScore = new double[N];
		double sum = 0;
		for(int i=0; i<N; i++){
		    resultScore[i] = (score[i]/(double)max)*100;
		    sum += resultScore[i];
		}
		
		// 결과 출력 
		double avg = sum/N;
		System.out.println(avg);
		
		
	}
}