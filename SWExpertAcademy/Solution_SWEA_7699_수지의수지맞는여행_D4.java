package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_7699_수지의수지맞는여행_D4 {

	private static int R, C; // 섬의 크기
	private static char[][] land; // 섬 명물 정보
	private static boolean[] alph; // 명물 관람 체크
	private static boolean[][] visit; // 섬 위치 방문 체크
	private static int max; // 수지가 볼 수 있는 최대 명물 개수
	
	static int[] dr = {-1, 0, 1, 0}; // 사방탐색
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			land = new char[R][C];
			visit = new boolean[R][C];
			alph = new boolean[26];
			
			for (int i = 0; i < R; i++) {
				land[i] = br.readLine().toCharArray();
			}
			
			max = -1;
			
			alph[land[0][0] - 'A'] = true;
			visit[0][0] = true;
			
			dfs(0, 0, 1);
			
			System.out.println("#" + tc + " " + max);
		}
	}

	private static void dfs(int r, int c, int cnt) {
		max = Math.max(max, cnt);
		
		int nr, nc;
		
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			
			if(nr >= 0 && nr < R && nc >= 0 && nc < C && !alph[land[nr][nc] - 'A'] && !visit[nr][nc]) {
				alph[land[nr][nc] - 'A'] = true;
				visit[nr][nc] = true;
				
				dfs(nr, nc, cnt + 1);
				
				alph[land[nr][nc] - 'A'] = false;
				visit[nr][nc] = false;
			}
		}
	}
}
