package beakjoon;
import java.util.Scanner;

public class Main_15649_N과M1 {
	private static int N;
	private static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		perm(new int[M], new boolean[N+1], 0);
	}
	
	private static void perm(int[] tmp, boolean[] v, int idx) {
		if(idx ==  M) {
			for (int i = 0; i < tmp.length; i++) {
				System.out.print(tmp[i]+ " ");
			}
			System.out.println();
		} else {
			for (int i = 1; i <= N; i++) {
				if(!v[i]) {
					tmp[idx] = i;
					v[i] = true;
					
					perm(tmp, v, idx+1);
					
					v[i] = false;
				}
			}
		}
	}
}
