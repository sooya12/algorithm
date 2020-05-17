package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15683_감시 {
	
	static int N; // 사무실의 세로 크기
	static int M; // 사무실의 가로 크기
	static int[][] office; // 사무실
	static ArrayList<int[]> cctv; // cctv 위치
	static int min = Integer.MAX_VALUE; // 사각 지대 최소 크기
	
	static int[] dr = {0, 1, 0, -1}; // 동 남 서 북
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		
		office = new int[N][M];
		cctv = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				
				if(office[i][j] > 0 && office[i][j] < 6) cctv.add(new int[] {i, j}); // cctv 위치 정보 수집
			}
			
		}
		
		int[][] copy = new int[N][M];
		
		for (int i = 0; i < office.length; i++) {
			copy[i] = office[i].clone();
		}
		
		move(copy, 0);
		
		System.out.println(min);
	}
	
	private static void move(int[][] copy, int idx) {
		if(idx == cctv.size()) { // 모든 cctv 고려한 경우
			int cnt = 0;
			
			for (int i = 0; i < copy.length; i++) {
				for (int j = 0; j < copy[0].length; j++) {
					if(copy[i][j] == 0) cnt++;
				}
			}
			
			min = Math.min(min, cnt);
			return;
		}
		
		int r = cctv.get(idx)[0]; // cctv의 행
		int c = cctv.get(idx)[1]; // cctv의 열
		
		int[][] tmp = new int[N][M]; // 임시 사무실 정보
		
		int turn;
		
		switch (office[r][c]) {
		
		case 1:
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < tmp.length; j++) {
					tmp[j] = copy[j].clone();
				}
				
				if(i % 2 == 0) {
					turn = 1;
					
					while(true) {
						if(c + dc[i]*turn < 0 || c + dc[i]*turn >= M) break;
						
						if(tmp[r][c + dc[i]*turn] == 6) break;
						
						tmp[r][c + dc[i]*(turn++)] = 7;
					}
					
					move(tmp, idx+1);
					
				} else {
					turn = 1;
					
					while(true) {
						if(r + dr[i]*turn < 0 || r + dr[i]*turn >= N) break;
						
						if(tmp[r + dr[i]*turn][c] == 6) break;
						
						tmp[r + dr[i]*(turn++)][c] = 7;
					}
					
					move(tmp, idx+1);
				}
			}
			break;
			
		case 2:
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < tmp.length; j++) {
					tmp[j] = copy[j].clone();
				}
				
				if(i % 2 == 0) { // 가로
					turn = 1;
					
					while(true) {
						if(c + dc[0]*turn >= M) break;
						
						if(tmp[r][c + dc[0]*turn] == 6) break;
						
						tmp[r][c + dc[0]*(turn++)] = 7;
					}
					
					turn = 1;
					
					while(true) {
						if(c + dc[2]*turn < 0) break;
						
						if(tmp[r][c + dc[2]*turn] == 6) break;
						
						tmp[r][c + dc[2]*(turn++)] = 7;
					}
					
					move(tmp, idx+1);
				} else { // 세로
					turn = 1;
					
					while(true) {
						if(r + dr[1]*turn >= N) break;
						
						if(tmp[r + dr[1]*turn][c] == 6) break;
						
						tmp[r + dr[1]*(turn++)][c] = 7;
					}
					
					turn = 1;
					
					while(true) {
						if(r + dr[3]*turn < 0) break;
						
						if(tmp[r + dr[3]*turn][c] == 6) break;
						
						tmp[r + dr[3]*(turn++)][c] = 7;
					}
					
					move(tmp, idx+1);
				}
			}
			break;
			
		case 3:
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < tmp.length; j++) {
					tmp[j] = copy[j].clone();
				}
				
				if(i % 2 == 0) {
					turn = 1;
					
					while(true) {
						if(c + dc[i]*turn < 0 || c + dc[i]*turn >= M) break;
						
						if(tmp[r][c + dc[i]*turn] == 6) break;
						
						tmp[r][c + dc[i]*(turn++)] = 7;
					}
				} else {
					turn = 1;
					
					while(true) {
						if(r + dr[i]*turn < 0 || r + dr[i]*turn >= N) break;
						
						if(tmp[r + dr[i]*turn][c] == 6) break;
						
						tmp[r + dr[i]*(turn++)][c] = 7;
					}
				}
				
				if(((i+1)%4) % 2 == 0) { // 시계방향으로 90도 회전
					turn = 1;
					
					while(true) {
						if(c + dc[(i+1)%4]*turn < 0 || c + dc[(i+1)%4]*turn >= M) break;
						
						if(tmp[r][c + dc[(i+1)%4]*turn] == 6) break;
						
						tmp[r][c + dc[(i+1)%4]*(turn++)] = 7;
					}
				} else {
					turn = 1;
					
					while(true) {
						if(r + dr[(i+1)%4]*turn < 0 || r + dr[(i+1)%4]*turn >= N) break;
						
						if(tmp[r + dr[(i+1)%4]*turn][c] == 6) break;
						
						tmp[r + dr[(i+1)%4]*(turn++)][c] = 7;
					}
				}
				
				move(tmp, idx+1);
			}
			break;
			
		case 4:
			for (int i = 0; i < dr.length; i++) {
				for (int j = 0; j < tmp.length; j++) {
					tmp[j] = copy[j].clone();
				}
				
				for (int j = 0; j < dr.length; j++) {
					if(j == (i+1)%4) continue; // 시계방향으로 90도 회전인 경우 감시하지 않음
					
					turn = 1;
					
					while(true) {
						if(r+dr[j]*turn < 0 || r+dr[j]*turn >= N || c+dc[j]*turn < 0 || c+dc[j]*turn >= M) break;
						
						if(office[r+dr[j]*turn][c+dc[j]*turn] == 6) break;
						
						tmp[r+dr[j]*turn][c+dc[j]*turn++] = 7;
					}
				}
				
				move(tmp, idx+1);
			}
			break;
			
		case 5:
			for (int j = 0; j < tmp.length; j++) {
				tmp[j] = copy[j].clone();
			}
			
			for (int i = 0; i < dr.length; i++) {
				
				turn = 1;
				
				while(true) {
					if(r+dr[i]*turn < 0 || r+dr[i]*turn >= N || c+dc[i]*turn < 0 || c+dc[i]*turn >= M) break;
					
					if(office[r+dr[i]*turn][c+dc[i]*turn] == 6) break;
					
					tmp[r+dr[i]*turn][c+dc[i]*turn++] = 7;
				}
			}
			
			move(tmp, idx+1);
			break;
		}
	}
}
