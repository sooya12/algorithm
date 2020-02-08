package beakjoon;
import java.util.Scanner;

public class Main_2447_별찍기10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String[][] arr = new String[n][n];
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = "*";
			}
		}
		
		int size = n;
		
		while(size > 0) {
			findSpace(arr, n, size);
			size /= 3;
		}
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	static void findSpace(String[][] arr, int n, int size) {
		for (int i = 0; i < n; i+=size) {
			for (int j = 0; j < n; j+=size) {
				makeSpace(arr, i, i+size-1, j, j+size-1);
			}
		}
	}
	
	
	static void makeSpace(String[][] arr, int sr, int er, int sc, int ec) {
		int x = (er - sr + 1) / 3;
		
		for (int i = sr; i < er; i++) {
			for (int j = sc; j < ec; j++) {
				if ((i >= sr + x && i <= er - x) &&
						(j >= sc + x && j <= ec - x)) arr[i][j] = " ";
			}
		}
	}
	
}
