//4. 소트인사이드
import java.util.Scanner;
import java.util.Arrays;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String[] num = str.split(""); //한 자리씩 나누기
		
		int[] arr = new int[num.length];
		for(int i=0; i<num.length; i++){
		    arr[i] = Integer.parseInt(num[i]);
		}
		Arrays.sort(arr); 

		for (int i = arr.length-1; i>=0; i--) {
			System.out.print(arr[i]);
		} //정렬한 뒤 내림차순으로 출력 
		
	}
}
