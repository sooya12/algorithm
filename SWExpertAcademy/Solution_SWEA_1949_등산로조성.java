package SWExpertAcademy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1949_등산로조성 {
	private static int N; // 지도 한 변 길이
	private static int K; // 최대 공사 가능 깊이
	private static int[][] map; // 지도 정보
	private static boolean[][] v; // 방문 확인
	private static int result; // 만들 수 있는 가장 긴 등산로의 길이
	
	static int[] dr = {-1, 0, 1, 0}; // 사방탐색
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 수
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			v = new boolean[N][N];
			
			int max = Integer.MIN_VALUE;
			
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					max = Integer.max(max, map[i][j]); // 가장 높은 봉우리 값
				}
			}
			
			result = Integer.MIN_VALUE;
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(map[i][j] == max) { // 가장 높은 봉우리에서 dfs 탐색
						v[i][j] = true;
						dfs(i, j, 1, true);
						v[i][j] = false;
					}
				}
			}
			
			System.out.println("#" + tc + " " + result);
			
		}
	}
	
	private static void dfs(int r, int c, int cnt, boolean flag) {
		for (int i = 0; i < dr.length; i++) {
			if(r + dr[i] >= 0 && r + dr[i] < N && c + dc[i] >= 0 && c + dc[i] < N 
					&& !v[r+dr[i]][c+dc[i]]) {
				
				if(map[r][c] > map[r+dr[i]][c+dc[i]]) {
					v[r+dr[i]][c+dc[i]] = true;
					dfs(r+dr[i], c+dc[i], cnt+1, flag);
					
					v[r+dr[i]][c+dc[i]] = false;
					
				}
				
				if (flag && map[r][c] > map[r+dr[i]][c+dc[i]] - K) { // 지형 깎기를 사용하지 않은 경우
					for (int j = 1; j <= K; j++) {
						if(map[r][c] <= map[r+dr[i]][c+dc[i]] - j) continue;
						
						map[r+dr[i]][c+dc[i]] -= j;
						v[r+dr[i]][c+dc[i]] = true;
						dfs(r+dr[i], c+dc[i], cnt+1, !flag);
						
						map[r+dr[i]][c+dc[i]] += j;
						v[r+dr[i]][c+dc[i]] = false;
						
					}
				} 
			}
		}
		
		result = Integer.max(result, cnt); // 최고값 갱신
		return;
	}
}
