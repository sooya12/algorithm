package beakjoon;
import java.util.Scanner;

public class Main_2443_별찍기06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2*n-1; j++) {
				if (j < i) System.out.print(" ");
				else if (j < 2*n - i - 1) System.out.print("*");
			}
			System.out.println();
		}
	}

}
