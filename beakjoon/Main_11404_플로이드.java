package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11404_플로이드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 도시의 개수
		int m = Integer.parseInt(br.readLine()); // 버스의 개수
		
		final int M = Integer.MAX_VALUE;
		
		int[][] D = new int[n][n];
		
		for (int i = 0; i < D.length; i++) {
			Arrays.fill(D[i], M);
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken());
			
			D[s][e] = Math.min(D[s][e], v);
		}
		
		for (int k = 0; k < D.length; k++) {
			for (int i = 0; i < D.length; i++) {
				if(k == i) continue;
				
				for (int j = 0; j < D.length; j++) {
					if(k == j || i == j) continue;
					
					if(D[i][k] != M && D[k][j] != M && D[i][j] > D[i][k] + D[k][j]) {
						D[i][j] = D[i][k] + D[k][j];
					}
				}
			}
		}
		
		for (int i = 0; i < D.length; i++) {
			for (int j = 0; j < D.length; j++) {
				if(D[i][j] == M) D[i][j] = 0;
			}
		}
		
		for (int i = 0; i < D.length; i++) {
			for (int j = 0; j < D.length; j++) {
				System.out.print(D[i][j] + " ");
			}
			System.out.println();
		}
	}
}
