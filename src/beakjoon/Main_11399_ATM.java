package beakjoon;
import java.util.Arrays;
import java.util.Scanner;

public class Main_11399_ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int sum = 0;
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			total += sum;
		}
		
		System.out.println(total);
	}
}
