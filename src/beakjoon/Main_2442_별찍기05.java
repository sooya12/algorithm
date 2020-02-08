package beakjoon;
import java.util.Scanner;

public class Main_2442_별찍기05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n*2-1; j++) {
				if(j < n - i - 1) System.out.print(" ");
				else if (j < n + i) System.out.print("*");
			}
			System.out.println();
		}
	}

}
