package beakjoon;
import java.util.Scanner;

public class Main_2630_색종이만들기 {
	
	static int[][] paper; 		// 색종이 배열
	static boolean[][] visited; // 방문 여부
	static int white = 0;		// 흰색 개수
	static int blue = 0;		// 파란색 개수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 전체 종이 한 변의 길이
		
		paper = new int[n][n]; 
		
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper[i].length; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		
		visited = new boolean[n][n];
		
		divide(0, 0, n);
		
		System.out.println(white);
		System.out.println(blue);
		
	}
	
	static int check(int r, int c, int l) { // 영역 전체가 같은 색인지
		int turn = paper[r][c];
		
		for (int i = r; i < r + l; i++) {
			for (int j = c; j < c + l; j++) {
				if(paper[i][j] != turn) return -1;
			}
		}
		
		for (int i = r; i < r + l; i++) {
			for (int j = c; j < c + l; j++) {
				visited[i][j] = true;
			}
		}
		
		return turn;
	}
	
	static void divide(int r, int c, int n) { // 4등분하여 확인
		if(n <= 0) return;
		
		if(check(r, c, n) == -1) {
			if(!visited[r][c]) divide(r, c, n/2);
			if(!visited[r][c + n/2]) divide(r, c + n/2, n/2);
			if(!visited[r + n/2][c]) divide(r + n/2, c, n/2);
			if(!visited[r + n/2][c + n/2]) divide(r + n/2, c + n/2, n/2);
		} else {
			if (check(r, c, n) == 0) white++;
			else blue++;
		}
	}
}
