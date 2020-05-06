package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2146_다리만들기 {
	
	static int N; // 지도의 크기
	static int[][] map; // 지도
	static boolean[][] v; // 방문 여부 확인
	static int min = Integer.MAX_VALUE; // 최소 다리 길이
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); 
		
		map = new int[N][N];
		v = new boolean[N][N];
		
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int val = 2; // 지도에 색칠할 값
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j] == 1 && !v[i][j]) { // dfs 탐색하면서 지도에 색칠
					map[i][j] = val;
					v[i][j] = true;
					dfs(i, j, val++);
				}
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if(i == j) continue;
				
				int r1 = list.get(i)[0];
				int c1 = list.get(i)[1];
				int r2 = list.get(j)[0];
				int c2 = list.get(j)[1];
				
				if(map[r1][c1] == map[r2][c2]) continue;
				
				int dist = Math.abs(r1 - r2) + Math.abs(c1 - c2) - 1;
				
				min = Math.min(min, dist);
			}
		}
		
		System.out.println(min);
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static List<int[]> list = new ArrayList<>();
	
	private static void dfs(int r, int c, int val) {
		
		for (int j = 0; j < dr.length; j++) {
			if(r + dr[j] >= 0 && r + dr[j] < N && c + dc[j] >= 0 && c + dc[j] < N 
					&& map[r+dr[j]][c+dc[j]] == 0) {
				list.add(new int[] {r, c});
				break;
			}
		}
		
		for (int i = 0; i < dr.length; i++) {
			int x = r+dr[i];
			int y = c+dc[i];
			
			if(x >= 0 && x < N && y >= 0 && y < N 
					&& map[x][y] == 1 && !v[x][y]) {
				map[x][y] = val;
				v[x][y] = true;
				
				dfs(x, c+dc[i], val);
			}
		}
	}
}
