package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1238_파티 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 학생의 수 - 정점
		int M = Integer.parseInt(st.nextToken()); // 단방향 도로 수 - 간선
		int X = Integer.parseInt(st.nextToken()) - 1; // X(출발지)
		
		int[][] D = new int[N][N];
		
		for (int i = 0; i < D.length; i++) {
			Arrays.fill(D[i], 99999);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int s = Integer.parseInt(st.nextToken()) - 1; // 도로 시작점
			int e = Integer.parseInt(st.nextToken()) - 1; // 도로 끝점
			int t = Integer.parseInt(st.nextToken()); // 도로 지나는데 필요한 소요 시간
			
			D[s][e] = t;
		}
		
		for (int k = 0; k < D.length; k++) {
			for (int i = 0; i < D.length; i++) {
				if(k == i) continue;
				
				for (int j = 0; j < D.length; j++) {
					if(k == j || i == j) continue;
					
					if(D[i][j] > D[i][k] + D[k][j]) {
						D[i][j] = D[i][k] + D[k][j];
					}
				}
			}
		}
		
		int max = Integer.MIN_VALUE; // 오고 가는데 가장 오래거리는 학생의 소요시간
		int idx = -1; // 오고 가는데 가장 오래 걸리는 학생
		
		for (int i = 0; i < D.length; i++) {
			if(D[i][X] != 99999 && D[X][i] != 99999 && max < D[i][X] + D[X][i]) {
				max = D[i][X] + D[X][i];
				idx = i;
			}
		}
		
		System.out.println(D[idx][X] + D[X][idx]);
	}
}
