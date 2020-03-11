package beakjoon;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1182_부분수열의합 {

	static int n;
	static int s;
	static int[] arr;
	static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt(); // n개의 정수로 이루어진 수열
		s = sc.nextInt(); // 합

		arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		makePowerSet();
		
		System.out.println(result);
	}


	public static void makePowerSet() {
		for (int i = 0; i < (1 << arr.length); i++) {
			
			List<Integer> list = new ArrayList<>();
			
			for (int j = 0; j < arr.length; j++) {
				if ((i & 1 << j) > 0) {
					list.add(arr[j]);
				}
			}
			
			int sum = 0;
			
			for (int j = 0; j < list.size(); j++) {
				sum += list.get(j);
			}
			
			if(list.size() > 0 && sum == s) result++;
		}
	}
}
