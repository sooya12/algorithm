package beakjoon;
import java.util.Arrays;
import java.util.Scanner;

public class Main_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // ������ ũ��
		
		int[] arr = new int[n]; // ���� �迭
		int[] dpArr = new int[arr.length+1];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		dpArr[0] = 0;
		dpArr[1] = 1;
		
		int max = dpArr[1];
		
		for (int i = 1; i < arr.length; i++) {
			dpArr[i+1] = dp(arr, i, dpArr)+1;
			
			if(max < dpArr[i+1]) max = dpArr[i+1];
		}
		
		System.out.println(max);
	}
	
	static int dp(int[] arr, int idx, int[] dpArr) {
		int result = 0;
		int dpVal = dpArr[0];
		
		for (int i = 0; i < idx; i++) {
			if (arr[i] < arr[idx] && dpArr[i+1] > dpVal) {
				dpVal = dpArr[i+1];
				result = dpArr[i+1];

			} else continue;
		}
		return result;
	}

}
