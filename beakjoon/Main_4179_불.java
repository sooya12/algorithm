package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4179_불 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int R = Integer.parseInt(st.nextToken()); // 행
		int C = Integer.parseInt(st.nextToken()); // 열
		
		char[][] map = new char[R][C]; // 미로
		
		Queue<Point> jq = new LinkedList<Point>(); // 지훈 큐
		Queue<Point> fq = new LinkedList<Point>(); // 불 큐
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'J') {
					jq.add(new Point(i, j, 1));
				} else if(map[i][j] == 'F') {
					fq.add(new Point(i, j));
				}
			}
		}
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		String result = "IMPOSSIBLE";
		
		x : while(!jq.isEmpty()) {
			int nr, nc;
			
			int size = fq.size();
			
			for (int s = 0; s < size; s++) {
				Point p = fq.poll();
				
				for (int i = 0; i < 4; i++) {
					nr = p.r + dr[i];
					nc = p.c + dc[i];
					
					if(nr >= 0 && nr < R && nc >= 0 && nc < C && (map[nr][nc] == '.' || map[nr][nc] == 'J')) {
						fq.add(new Point(nr, nc));
						map[nr][nc] = 'F';
					}
				}
			}
			
			size = jq.size();
			
			for (int s = 0; s < size; s++) {
				Point j = jq.poll();
				
				int r = j.r;
				int c = j.c;
				
				if(r == 0 || r == R - 1 || c == 0 || c == C-1) {
					result = String.valueOf(j.time);
					break x;
				}
				
				
				for (int i = 0; i < 4; i++) {
					nr = r + dr[i];
					nc = c + dc[i];
					
					if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') {
						
						if(map[nr][nc] == '.' && (nr == 0 || nr == R-1 || nc == 0 || nc == C-1)) {
							result = String.valueOf(j.time + 1);
							break x;
						}
						
						map[nr][nc] = 'J';
						jq.add(new Point(nr, nc, j.time + 1));
						
					}
				}
			}
		}
		
		System.out.println(result);
	}
	
	static class Point {
		int r;
		int c;
		int time;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		public Point(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
}
