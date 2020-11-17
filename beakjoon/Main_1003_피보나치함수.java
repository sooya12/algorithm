package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003_피보나치함수 {

	static int[] zero = new int[41];
	static int[] one = new int[41];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < zero.length; i++) {
			fibonacci(i);
		}
		
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(zero[n] + " " + one[n]);
		}
	}
	
	public static void fibonacci(int n) {
		if(n == 0) {
			zero[n] += 1;
			one[n] += 0;
		} else if(n == 1) {
			zero[n] += 0;
			one[n] += 1;
		} else {
			zero[n] += zero[n - 1] + zero[n - 2];
			one[n] += one[n - 1] + one[n - 2];
		}
	}
}
