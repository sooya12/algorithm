package beakjoon;
import java.util.Scanner;

public class Main_2567_색종이2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] paper = new int[102][102]; // 사방탐색을 위해 여백 추가
		
		int n = sc.nextInt(); // 색종이 개수
		
		for (int i = 0; i < n; i++) {
			int left = sc.nextInt(); // 왼쪽 변과 사이 거리
			int bottom = sc.nextInt(); // 아래쪽 변과 사이 거리
			
			for (int j = 91 - bottom; j < 101 - bottom; j++) {
				for (int k = left + 1; k <= left + 10; k++) {
					paper[j][k] = 1;
				}
			}
		}
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		int cnt = 0;

		for (int i = 1; i < paper.length - 1; i++) {
			for (int j = 1; j < paper.length - 1; j++) {
				
				if(paper[i][j] == 0) continue;
				
				for (int k = 0; k < dc.length; k++) {
					
					if(i + dr[k] < 0 || i + dr[k] > paper.length - 1
							|| j + dc[k] < 0 || j + dc[k] > paper.length - 1) continue;
					
					if(paper[i][j] != 0 && (paper[i + dr[k]][j + dc[k]] == 0)) {
						cnt++;
						paper[i][j] = cnt;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}
