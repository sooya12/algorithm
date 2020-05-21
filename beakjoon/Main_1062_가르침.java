package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1062_가르침 {
	
	static int N; // 단어의 개수
	static int K; // 가르칠 글자 수
	static ArrayList<Character> listAnta; // 남극 기본 단어
	static ArrayList<Character> listNew; // 추가할 단어
	static char[] antatica = {'a', 'c', 'i', 'n', 't'}; // anta tica -> a c i n t
	static String[] srr; // 입력된 단어
	
	static int max = Integer.MIN_VALUE; // 최대 글자수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 단어의 개수
		K = Integer.parseInt(st.nextToken()); // 가르칠 글자 수
		
		
		if(K < 5) System.out.println(0);
		
		else {
			listAnta = new ArrayList<>();
			listNew = new ArrayList<>();
			
			for (int i = 0; i < antatica.length; i++) {
				listAnta.add(antatica[i]);
			}
			
			K -= 5;
			
			srr = new String[N];
			String input;
			for (int i = 0; i < srr.length; i++) {
				input = br.readLine();
				input = input.substring(4, input.length()-4);
				srr[i] = input;
				
			}
			
			for (int i = 0; i < srr.length; i++) {
				for (int j = 0; j < srr[i].length(); j++) {
					char val = srr[i].charAt(j);
					
					if(!listAnta.contains(val) && !listNew.contains(val)) {
						listNew.add(val);
					}
				}
			}
			
			comb(0, 0, new char[K]);
			
			System.out.println(max);
		}
		
	}
	
	private static void comb(int r, int idx, char[] tmp) {
		if(r == K || r == listNew.size()) {
			check(tmp);
			return;
		} else {
			for (int i = idx; i < listNew.size(); i++) {
				tmp[r] = listNew.get(i);
				
				comb(r+1, i+1, tmp);
			}
		}
	}
	
	private static void check(char[] tmp) {
		ArrayList<Character> tmpList = new ArrayList<>();
		for (int i = 0; i < tmp.length; i++) {
			tmpList.add(tmp[i]);
		}
		
		int cnt = 0;
		boolean flag;
		
		for (int i = 0; i < srr.length; i++) {
			flag = true;
			
			for (int j = 0; j < srr[i].length(); j++) {
				char val = srr[i].charAt(j);
				
				if(!tmpList.contains(val) && !listAnta.contains(val)) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				cnt++;
			}
		}
		
		max = Math.max(max, cnt);
	}
}
