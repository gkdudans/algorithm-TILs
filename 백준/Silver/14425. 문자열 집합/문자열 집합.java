import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 초기화: 루트 노드를 만드는 것 
		Node root = new Node(); 
		int count = 0;
		
		// 단어들을 사전의 형태로 생성 
		for(int i=0; i<N; i++) {
		    String text = br.readLine();
		    Node now = root; // 항상 루트에서 시작 
		    
		    for(int j=0; j<text.length(); j++) {
		        char c = text.charAt(j); // j번째 위치의 문자 하나를 추출 
		        
		        // 입력에 주어지는 문자열은 알파벳 소문자로만 구성 
		        if(now.next[c - 'a'] == null) {
		            // c에 해당하는 다음 노드가 null이라면 신규 노드 생성 
		            now.next[c - 'a'] = new Node();
		        }
		        now = now.next[c - 'a'];
		        if(j == text.length() - 1) {
		            now.isEnd = true;
		        }
		    }
		}
		
		// 트라이: 문자열 검색 
		for(int i=0; i<M; i++) {
		    String text = br.readLine();
		    Node now = root; // 루트에서 시작 
		    
		    for(int j=0; j<text.length(); j++) {
		        char c = text.charAt(j);
		        
		        if(now.next[c - 'a'] == null) {
		            break;
		        }
		        
		        now = now.next[c - 'a'];
		        
		        if(j == text.length()-1 && now.isEnd == true) {
		            count++;
		        }
		    }
		}
		
		System.out.println(count);
	}
	
	static class Node {
	    Node[] next = new Node[26]; // 알파벳 개수만큼 자식 노드 배열 
	    boolean isEnd = false;
	}
}