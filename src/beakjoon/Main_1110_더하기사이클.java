package beakjoon;


import java.util.Scanner;

public class Main_1110_더하기사이클 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		int cnt = 0;
		int tmp = input;
		
		while(true) {
			tmp = cycle(tmp);
			cnt++;
			
			if(tmp == input) break;
		}
		
		System.out.println(cnt);
	}
	
	static int cycle(int input) {
		int left, right, result = 0;
		
		if(input < 10) {
			left = 0;
			right = input;
		} else {
			left = input / 10;
			right = input % 10;
		}
		
		result = right * 10 + (left + right) % 10;
//		System.out.println(result);
		return result;
	}
}
