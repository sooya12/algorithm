package beakjoon;
import java.util.Scanner;

public class Main_2444_별찍기07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 0; i < 2*n-1; i++) {
			for (int j = 0; j < 2*n-1; j++) {
				if (i < n) {
					if (j < n - i - 1) System.out.print(" ");
					else if (j < n + i) System.out.print("*");
				} else {
					if (j < i - n + 1) System.out.print(" ");
					else if (j < 2*n- i + n - 2) System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
