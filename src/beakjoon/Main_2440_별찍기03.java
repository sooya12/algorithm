package beakjoon;
import java.util.Scanner;

public class Main_2440_별찍기03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
