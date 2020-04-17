package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11562_백양로브레이크 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken()); // 건물의 수
		int m = Integer.parseInt(st.nextToken()); // 길의 수

		int[][] D = new int[n][n];

		for (int i = 0; i < D.length; i++) {
			for (int j = 0; j < D.length; j++) {
				if (i != j)
					D[i][j] = 987654321;
			}
		}

		for (int i = 0; i < D.length; i++) {
			for (int j = 0; j < D.length; j++) {
				if (i == j)
					D[i][j] = 0;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int u = Integer.parseInt(st.nextToken()) - 1; // 건물1
			int v = Integer.parseInt(st.nextToken()) - 1; // 건물2
			int b = Integer.parseInt(st.nextToken()); // 0:일방통행 1:양방향통행

			if (b == 0) {
				D[u][v] = 0;
				D[v][u] = 1;

			} else {
				D[u][v] = 0;
				D[v][u] = 0;
			}
		}

		for (int k = 0; k < D.length; k++) {
			for (int i = 0; i < D.length; i++) {
				if (k == i)
					continue;

				for (int j = 0; j < D.length; j++) {
					if (k == j || i == j)
						continue;

					if (D[i][j] > D[i][k] + D[k][j]) {
						D[i][j] = D[i][k] + D[k][j];
					}
				}
			}
		}

		int k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;

			System.out.println(D[s][e]);
		}
	}
}
