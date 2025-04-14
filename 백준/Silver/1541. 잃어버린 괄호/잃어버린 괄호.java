import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String mathExpr = br.readLine();
		
		String[] minusParts = mathExpr.split("-");
		
		// -를 만나기 이전 덩어리 합 계산
		int sum = sumOfNumbers(minusParts[0]);
		
		// - 를 만난 이후를 괄호로 묶어서 수식 계산
		for(int i=1; i<minusParts.length; i++) {
		    sum -= sumOfNumbers(minusParts[i]);
		}
		
		System.out.println(sum);
		
	}
	
	// 합 계산 함수 
	static int sumOfNumbers(String part) {
	    // '+'는 이스케이프 필요
	    String[] parts = part.split("\\+");

	    int sum = 0;
	    for(int i=0; i<parts.length; i++) {
	        sum += Integer.parseInt(parts[i]);

	    }
	    return sum;
	}
}