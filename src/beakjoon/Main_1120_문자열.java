package beakjoon;

import java.util.Scanner;

public class Main_1120_문자열 {
	
	static int min = Integer.MAX_VALUE; // a, b 차이 최솟값
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next(); // a 문자열
		String b = sc.next(); // b 문자열
		
		int diff = b.length() - a.length();
		
		for (int i = 0; i <= diff; i++) {
			add(a, b, i);
		}
		
		System.out.println(min); 
	}
	
	static void add(String a, String b, int idx) {
		String result = "";
		for (int i = 0; i < idx; i++) {
			result += b.charAt(i);
		}
		
		result += a;
		
		if(result.length() < b.length()) {
			for (int i = result.length(); i < b.length(); i++) {
				result += b.charAt(i);
			}
		}
		
		check(result, b);
	}
	
	static void check(String result, String b) {
		int cnt = 0;
		
		for (int i = 0; i < result.length(); i++) {
			if(result.charAt(i) != b.charAt(i)) cnt++;
		}
		
		min = Math.min(min, cnt);
	}
}
