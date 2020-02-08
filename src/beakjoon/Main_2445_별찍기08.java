package beakjoon;
import java.util.Scanner;

public class Main_2445_별찍기08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 0; i < 2*n-1; i++) {
			for (int j = 0; j < 2*n; j++) {
				if (i < n) {
					if (j < i+1 || j > 2*n-i-2) System.out.print("*");
					else System.out.print(" ");
				} else {
					if (j < 2*n-1-i || j > i) System.out.print("*");
					else System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
