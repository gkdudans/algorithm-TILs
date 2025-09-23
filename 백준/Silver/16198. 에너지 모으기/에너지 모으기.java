import java.io.*;
import java.util.*;

public class Main
{
    static int max = 0;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> energy = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
		   energy.add(Integer.parseInt(st.nextToken()));
		}
		
		addEnergy(0, energy);
		
		System.out.println(max);
	}
	
	static void addEnergy(int sum, ArrayList<Integer> energy) {
	    if(energy.size() == 2) {
	        max = Math.max(max, sum);
	        return;
	    }
	    
	    for(int i=1; i<=energy.size()-2; i++) {
	        int now = energy.get(i-1) * energy.get(i+1);
	        ArrayList<Integer> nextEnergy = new ArrayList<>(energy);
	        nextEnergy.remove(i);
	        // 재귀 호출 
	        addEnergy(sum + now, nextEnergy);
	    }
	}
}