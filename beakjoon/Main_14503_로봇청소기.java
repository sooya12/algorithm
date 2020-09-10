package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {

	static int N, M; // 세로, 가로 크기
	static int[][] map; // 영역
	static int cnt = 0; // 청소하는 칸의 개수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine(), " ");
		// 로봇 청소기 위치 및 바라보는 방향
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken()); // 0북 1동 2남 3서
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cleaning(r, c, d);
		
		System.out.println(cnt);
	}
	
	static int[] dr = {0, -1, 0, 1}; // d에 따른 왼쪽
	static int[] dc = {-1, 0, 1, 0};
	
	private static void cleaning(int r, int c, int d) {
		if(map[r][c] == 0) { // 1. 현재 위치 청소
			map[r][c] = 2;
			cnt++;
		}
		
		int nr = 0;
		int nc = 0;
		
		for (int i = 0; i < 4; i++) {
			nr = r + dr[d];
			nc = c + dc[d];
			
			d = (d - 1) < 0 ? 3 : d - 1;
			
			// 2-a. 왼쪽에 아직 청소하지 않은 공간이 존재
			if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
				cleaning(nr, nc, d);
				return;
			}
		}
		
		// 2-cd. 후진
		r += dr[(d - 1) < 0 ? 3 : d - 1];
		c += dc[(d - 1) < 0 ? 3 : d - 1];
		
		if(map[r][c] != 1) {
			cleaning(r, c, d);
		} else {
			return;
		}
	}
}
