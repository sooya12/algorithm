package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {
	static int N; // 행과 열의 크기
	static int[][] map; // 지도
	static boolean[][] v; // 방문 여부
	
	static int result; // 최대 안전 영역
	
	static int[] dr = {-1, 0, 1, 0}; // 사방탐색
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 행과 열의 크기
		map = new int[N][N]; // 지도
		
		int max = Integer.MIN_VALUE; // 최대 높이
		int min = Integer.MAX_VALUE; // 최소 높이
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}
		
		result = 0;
		
		for (int i = 0; i < max; i++) {
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(map[j][k] == i) map[j][k] *= (-1);
				}
			}
			
			v = new boolean[N][N];
			
			int cnt = 0;
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(map[j][k] > 0 && !v[j][k]) {
						v[j][k] = true;
						dfs(j, k);
						cnt++;
					}
				}
			}
			
			result = Math.max(result, cnt);
		}
		
		System.out.println(result);
		
	}

	private static void dfs(int r, int c) {
		for (int i = 0; i < dr.length; i++) {
			if(r + dr[i] >= 0 && r + dr[i] < N && c + dc[i] >= 0 && c + dc[i] < N 
					&& !v[r+dr[i]][c+dc[i]] && map[r+dr[i]][c+dc[i]] > 0) {
				v[r+dr[i]][c+dc[i]] = true;
				
				dfs(r+dr[i], c+dc[i]);
			}
		}
	}
}
