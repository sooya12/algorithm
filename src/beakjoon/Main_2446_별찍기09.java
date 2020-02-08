package beakjoon;
import java.util.Scanner;

public class Main_2446_별찍기09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 0; i < 2*n-1; i++) {
			for (int j = 0; j < 2*n-1; j++) {
				if (i < n) {
					if (j >= i && j < 2*n-1-i) System.out.print("*");
					else if (j < i) System.out.print(" ");
				} else {
					if (j >= 2*n-i-2 && j <= i) System.out.print("*");
					else if (j < 2*n-i-2) System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
