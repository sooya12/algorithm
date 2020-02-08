package beakjoon;


import java.util.Scanner;

public class Main_2231_분해합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int min = 0; //���� ���� ������
		
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			String num = Integer.toString(i);
			String[] arr = num.split("");
			
			for (int j = 0; j < arr.length; j++) {
				sum += Integer.parseInt(arr[j]);
			}
			
			sum += i;
			
			if(sum == n) {
				min = i;
				break;
			}
		}
		
		System.out.println(min);
	}
}
