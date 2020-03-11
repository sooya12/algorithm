package algorithm;

import java.util.Scanner;

public class Main_6603_로또 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int n = sc.nextInt(); // 집합 S의 개수
			int[] numArr = new int[n];
			boolean[] boolArr = new boolean[n];
			int[] result = new int[6];
			
			if (n != 0) {
				numArr = new int[n]; // 집합 S
				
				for (int i = 0; i < n; i++) {
					numArr[i] = sc.nextInt();
				}
				
				combination(numArr, 6, 0, result, 0);
				
				System.out.println();

			} else
				break; // 0이 나와서 종료
		} // end of while
	} // end of main

	static void combination(int[] numArr, int r, int idx, int[] result, int target) {
		if(r == 0) {
			print(result);
			return;
		} 
		
		if(target == numArr.length) return;
		
		result[idx] = numArr[target];
		combination(numArr, r-1, idx+1, result, target+1);
		combination(numArr, r, idx, result, target+1);
	} 
	

	static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
} // end of class 
