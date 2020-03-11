package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class Main_1012_유기농배추 {
	
	static int[][] field;
	static boolean[][] visited;
	static Stack<Integer> str = new Stack<>();
	static Stack<Integer> stc = new Stack<>();
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt(); // 테스트 케이스 수
		
		for (int testCase = 1; testCase <= t; testCase++) {
			int m = sc.nextInt(); // 배추밭 가로 길이
			int n = sc.nextInt(); // 배추밭 세로 길이
			
			field = new int[n][m];
			visited = new boolean[n][m];
			
			int k = sc.nextInt(); // 배추 심어져 있는 위치 개수
			
			for (int i = 0; i < k; i++) {
				int inputC = sc.nextInt();
				int inputR = sc.nextInt();
				
				field[inputR][inputC] = 1; // 배추 심어져 있는 위치 표시
			}
			
			int cnt = 0;
						
			for (int i = 0; i < field.length; i++) {
				for (int j = 0; j < field[i].length; j++) {
					if(field[i][j] == 1 && !visited[i][j]) {
						str.push(i);
						stc.push(j);
						
						visited[i][j] = true;
						
						while(!str.isEmpty()) {
							int r = str.pop();
							int c = stc.pop();
							
							for (int x = 0; x < dr.length; x++) {
								if(r + dr[x] < 0 || r + dr[x] > field.length - 1 
										|| c + dc[x] < 0 || c + dc[x] > field[0].length - 1) continue;
								
								if(field[r + dr[x]][c + dc[x]] == 1 && !visited[r + dr[x]][c + dc[x]]) {
									str.push(r + dr[x]);
									stc.push(c + dc[x]);
									
									visited[r + dr[x]][c + dc[x]] = true;
								}
							}
						}
						
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
}
