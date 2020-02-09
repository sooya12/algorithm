package beakjoon;

import java.util.Scanner;

public class Main_14501_퇴사 {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		int n = sc.nextInt(); // 일할 수 있는 날
		int[][] advice = new int[n][2];
		
		for (int i = 0; i < advice.length; i++) {
			advice[i][0] = sc.nextInt(); // 상담 소요 일수
			advice[i][1] = sc.nextInt(); // 상담 수익
		}
		
		cal(0, 0, 0, advice);
		
		System.out.println(max);
	}
	
	static int max = 0;
	
	static void cal(int idx, int profit, int lastProfit, int[][] advice) {
		if(idx > advice.length) return;
		
		max = Math.max(profit, max);
		
		if(idx <= advice.length - 1) {
			cal(idx + advice[idx][0], profit + advice[idx][1], advice[idx][1], advice);
			cal(idx + 1, profit, 0, advice);
		}
	}
}
