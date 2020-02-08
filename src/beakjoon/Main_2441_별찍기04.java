package beakjoon;
import java.util.Scanner;

public class Main_2441_별찍기04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j < i) System.out.print(" ");
				else System.out.print("*");
			}
			System.out.println();
		}
	}

}
