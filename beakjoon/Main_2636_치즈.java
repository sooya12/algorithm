package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	
	static int R; // 판의 세로 길이
	static int C; // 판의 가로 길이
	static int[][] pan; // 판
	static int result; // 한 시간 전 남아있는 치즈 개수
	static int cnt; // 총 치즈 개수
	static int time; // 치즈가 모두 녹아서 없어지는데 걸리는 시간
	static ArrayList<int[]> list; // 녹을 치즈
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken()); // 판의 세로 길이
		C = Integer.parseInt(st.nextToken()); // 판의 가로 길이
		
		pan = new int[R][C];
		
		cnt = 0;
		result = 0;
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < C; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
				
				if(pan[i][j] == 1) cnt++;
			}
		}
		
		checkAir(0, 0); // 초기 공기(0) 4로 변환
		
		checkOutLine(); // 공기와 닿아있는 부분 2로 변환
		
		int x = -1, y = -1; // checkAir할 위치
		time = 0;
		
		while(cnt > 0) {
			result = cnt;
			time++;
			
			for(int[] tmp : list) {
				int i = tmp[0];
				int j = tmp[1];
				
				pan[i][j] = 0;
				cnt--;
				
				if(x == -1) {
					x = i;
					y = j;
				}
			}
			
			checkAir(x, y);
		
			checkOutLine();
			
			x = -1;
			y = -1;
			
		}
		
		System.out.println(time);
		System.out.println(result);
		
	}
	
	private static void checkAir(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] v = new boolean[R][C];
		
		q.offer(new int[] {x, y});
		pan[x][y] = 4;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			
			v[r][c] = true;
			
			for (int i = 0; i < dr.length; i++) {
				if(0 <= r + dr[i] && r + dr[i] < R && 0 <= c + dc[i] && c + dc[i] < C 
						&& (pan[r+dr[i]][c+dc[i]] == 0 || pan[r+dr[i]][c+dc[i]] == 4)
						&& !v[r+dr[i]][c+dc[i]]) {
					pan[r+dr[i]][c+dc[i]] = 4;
					
					v[r+dr[i]][c+dc[i]] = true;
					q.add(new int[] {r+dr[i], c+dc[i]});
				}
			}
		}
	}
	
	private static void checkOutLine() {
		list = new ArrayList<>();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				
				if(pan[i][j] == 4) continue;
				
				for (int k = 0; k < dr.length; k++) {
					if(0 <= i + dr[k] && i + dr[k] < R && 0 <= j + dc[k] && j + dc[k] < C) {
						if(pan[i + dr[k]][j + dc[k]] == 4) {
							pan[i][j] = 2;
							list.add(new int[] {i, j});
							break;
						}
					}
				}
			}
		}
	}
}
