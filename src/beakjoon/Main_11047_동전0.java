package beakjoon;
import java.util.Scanner;

public class Main_11047_동전0 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 동전 종류
		int k = sc.nextInt(); // 가치의 합
		
		int[] arr = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt(); // 동전의 가치
		}
		
		int cnt = 0;
		
		for (int i = arr.length - 1; i >= 0; i--) {
			if(arr[i] <= k) {
				cnt += k/arr[i];
				k %= arr[i];
			}
			
			if(k == 0) break;
		}
		
		System.out.println(cnt);
	}
}
