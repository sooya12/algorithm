package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_7793_오나의여신님_D5_re {

	static int[] dr = {-1, 0, 1, 0}; // 사방탐색
	static int[] dc = {0, 1, 0, -1};
	
	static int N, M; // 행, 열
	static char[][] map; // 지도
	static Queue<Point> sq; // 수연
	static Queue<Point> dq; // 악마
	
	static class Point {
		int r;
		int c;
		int cnt;
		
		private Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		private Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
		@Override
		public String toString() {
			return r + " " + c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		x : for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new char[N][M];
			
			sq = new LinkedList<>(); // 수연 큐
			dq = new LinkedList<>(); // 악마 큐
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				map[i] = st.nextToken().toCharArray();
				
				for (int j = 0; j < M; j++) {
					
					// 수연, 여신, 악마 위치 파악
					if(map[i][j] == 'S') {
						sq.add(new Point(i, j, 0));
					} else if(map[i][j] == '*') {
						dq.add(new Point(i, j));
					}
				}
			}
			
			while(!sq.isEmpty()) {
				int nr, nc;
				int size = dq.size();
				
				for (int s = 0; s < size; s++) {
					Point dp = dq.poll(); // 악마 위치
					
					for (int i = 0; i < 4; i++) {
						nr = dp.r + dr[i];
						nc = dp.c + dc[i];
						
						if(nr >=0 && nr < N && nc >=0 && nc < M && (map[nr][nc] == '.' || map[nr][nc] == 'S')) {
							dq.add(new Point(nr, nc));
							map[nr][nc] = '*';
						}
					}
				}
				
				size = sq.size();
				
				for (int s = 0; s < size; s++) {
					Point sp = sq.poll(); // 수연 위치
					
					if(sp.cnt >= N*M) continue;
					
					for (int i = 0; i < 4; i++) {
						nr = sp.r + dr[i];
						nc = sp.c + dc[i];
						
						if(nr >=0 && nr < N && nc >=0 && nc < M) {
							
							if(map[nr][nc] == 'D') {
								sb.append("#").append(tc).append(" ").append(sp.cnt + 1).append("\n");
								continue x;
							}
							
							if(map[nr][nc] == '.') {
								sq.add(new Point(nr, nc, sp.cnt + 1));
								map[nr][nc] = 'S';
							}
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ").append("GAME OVER").append("\n");
		}
		
		System.out.println(sb);
	}
}
