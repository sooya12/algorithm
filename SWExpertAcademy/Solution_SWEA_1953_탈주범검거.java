package SWExpertAcademy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1953_탈주범검거 {
	
	static int[] dr = {-1, 0, 1, 0}; // 사방탐색
	static int[] dc = {0, 1, 0, -1};
	
	static class Point {
		int r;
		int c;
		
		Point(int r, int c){
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 수
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken()); // 지하 터널 세로 길이
			int M = Integer.parseInt(st.nextToken()); // 지하 터널 가로 길이
			int R = Integer.parseInt(st.nextToken()); // 맨홀 세로 위치
			int C = Integer.parseInt(st.nextToken()); // 맨홀 가로 위치
			int L = Integer.parseInt(st.nextToken())-1; // 탈출 후 소요 시간
			
			int[][] map = new int[N][M]; // 지하 터널 정보
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 1; // 가능한 방문 터널 개수
			
			if(L != 0) {
				Queue<Point> q = new LinkedList<>();
				boolean[][] v = new boolean[N][M];
				
				q.offer(new Point(R, C));
				
				int size; // q 사이즈
				int val; // 현재 위치 값
				Point p; // q에서 꺼낸 값
				int r, c; 
				int nr, nc;
				
				while(!q.isEmpty()) {
					L--;
					size = q.size();

					for (int i = 0; i < size; i++) {
						p = q.poll();
						r = p.r;
						c = p.c;
						val = map[r][c];
						v[r][c] = true;
						
						switch(val) {
						case 1:
							for (int j = 0; j < 4; j++) {
								nr = r + dr[j];
								nc = c + dc[j];
								
								if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] != 0 && check(j, map[nr][nc]) && !v[nr][nc]) {
									v[nr][nc] = true;
									q.offer(new Point(nr, nc));
									max++;
								}
							}
							break;
						case 2:
							for (int j = 0; j < 4; j+=2) {
								nr = r + dr[j];
								nc = c + dc[j];
								
								if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] != 0 && check(j, map[nr][nc]) && !v[nr][nc]) {
									v[nr][nc] = true;
									q.offer(new Point(nr, nc));
									max++;
								}
							}
							break;
						case 3:
							for (int j = 1; j < 4; j+=2) {
								nr = r + dr[j];
								nc = c + dc[j];
								
								if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] != 0 && check(j, map[nr][nc]) && !v[nr][nc]) {
									v[nr][nc] = true;
									q.offer(new Point(nr, nc));
									max++;
								}
							}
							break;
						case 4:
							for (int j = 0; j < 2; j++) {
								nr = r + dr[j];
								nc = c + dc[j];
								
								if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] != 0 && check(j, map[nr][nc]) && !v[nr][nc]) {
									v[nr][nc] = true;
									q.offer(new Point(nr, nc));
									max++;
								}
							}
							break;
						case 5:
							for (int j = 1; j < 3; j++) {
								nr = r + dr[j];
								nc = c + dc[j];
								
								if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] != 0 && check(j, map[nr][nc]) && !v[nr][nc]) {
									v[nr][nc] = true;
									q.offer(new Point(nr, nc));
									max++;
								}
							}
							break;
						case 6:
							for (int j = 2; j < 4; j++) {
								nr = r + dr[j];
								nc = c + dc[j];
								
								if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] != 0 && check(j, map[nr][nc]) && !v[nr][nc]) {
									v[nr][nc] = true;
									q.offer(new Point(nr, nc));
									max++;
								}
							}
							break;
						case 7:
							for (int j = 3; j < 5; j++) {
								nr = r + dr[j%4];
								nc = c + dc[j%4];
								
								if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] != 0 && check(j%4, map[nr][nc]) && !v[nr][nc]) {
									v[nr][nc] = true;
									q.offer(new Point(nr, nc));
									max++;
								}
							}
							break;
						}
					}
					
					if(L == 0) {
						break;
					}
				}
			}
			
			System.out.println("#" + tc + " " + max);
		}
	}
	
	private static boolean check(int dir, int val) {
		boolean flag = false;
		
		switch(dir) {
		case 0:
			if(val == 1 || val == 2 || val == 5 || val == 6) flag = true;
			break;
		case 1:
			if(val == 1 || val == 3 || val == 6 || val == 7) flag = true;
			break;
		case 2:
			if(val == 1 || val == 2 || val == 4 || val == 7) flag = true;
			break;
		case 3:
			if(val == 1 || val == 3 || val == 4 || val == 5) flag = true;
			break;
		}
		
		return flag;
	}
}
