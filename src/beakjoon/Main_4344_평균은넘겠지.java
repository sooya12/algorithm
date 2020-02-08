package beakjoon;


import java.util.Scanner;

public class Main_4344_평균은넘겠지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int i = 0; i < testCase; i++) {
			int n = sc.nextInt();
			int[] score = new int[n];
			double sum = 0;
			double avg = 0;
			double cnt = 0;
			
			for(int j = 0; j < score.length; j++) {
				score[j] = sc.nextInt();
				sum += score[j];
			}
			
			avg = sum / n;
			
			for(int j = 0; j < score.length; j++) {
				if(score[j] > avg) cnt++;
			}
			
			System.out.printf("%.3f",Math.round((cnt/n)*100*1000)/1000.0);
			System.out.println("%");
		}
	}
}
