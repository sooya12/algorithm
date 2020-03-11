package beakjoon;
import java.util.Scanner;

public class Main_4963_섬의개수 {
	
	static boolean[][] visited;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			int w = sc.nextInt(); // 지도 너비
			int h = sc.nextInt(); // 지도 높이
			
			if(w == 0 && h == 0) break;
			
			map = new int[h][w]; 
			visited = new boolean[h][w];
			
			int cnt = 0;
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
		
	}
	
	static int[] dr = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
	
	static void dfs(int r, int c) {
		
		visited[r][c] = true;
		
		for (int i = 0; i < dr.length; i++) {
			if(r + dr[i] < 0 || r + dr[i] > map.length - 1 
					|| c + dc[i] < 0 || c + dc[i] > map[0].length - 1) continue;
			
			if(map[r + dr[i]][c + dc[i]] == 1 && !visited[r + dr[i]][c + dc[i]]) {
				visited[r + dr[i]][c + dc[i]] = true;
				
				dfs(r + dr[i], c + dc[i]);
			}
		}
	}
}
