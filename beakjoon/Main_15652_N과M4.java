package beakjoon;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main_15652_N과M4 {
	private static int N;
	private static int M;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		perm(new int[M], 0, 1);
		bw.flush();
	}
	
	private static void perm(int[] tmp, int idx, int val) throws IOException {
		if(idx ==  M) {
			for (int i = 0; i < tmp.length; i++) {
				bw.write(tmp[i] + " ");
			}
			bw.newLine();
			
		} else {
			for (int i = val; i <= N; i++) {
				tmp[idx] = i;

				perm(tmp, idx + 1, i);
			}
		}
	}
}
