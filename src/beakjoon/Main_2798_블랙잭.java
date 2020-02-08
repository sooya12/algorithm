package beakjoon;


import java.util.Scanner;

public class Main_2798_블랙잭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int arr[] = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr.length; j++) {
				if(j == i) continue;
				
				for (int k = 0; k < arr.length; k++) {
					if(k == i || k == j) continue;
					
					sum += arr[i] + arr[j] + arr[k];
					
					if(max < sum && sum <= m) max = sum;
					
					sum = 0;
				}
			}
		}
		
		System.out.println(max);
	}
}
