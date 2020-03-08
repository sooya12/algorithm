package beakjoon;
import java.util.Scanner;

public class Main_1316_그룹단어체커 {
	
	static boolean[] check; // 이미 사용했던 문자인지 확인
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 단어의 개수
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			boolean turn = true;
			check = new boolean[26];
			
			char tmp = s.charAt(0);
			check[tmp - 'a'] = true;
			
			for (int j = 1; j < s.length(); j++) {
				if(tmp == s.charAt(j)) continue;
				else {
					if(check[s.charAt(j) - 'a']) {
						turn = false;
						break;
					}
					
					tmp = s.charAt(j);
					check[tmp - 'a'] = true;
				}
			}
			
			if(turn) cnt++;
		}
		
		System.out.println(cnt);
	}
}
