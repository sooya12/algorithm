package beakjoon;
import java.util.Scanner;

public class Main_14500_테트로미노 {
	
	static int[][] arr;
	static int max = Integer.MIN_VALUE; // 합의 최댓값
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 종이의 세로 크기
		int m = sc.nextInt(); // 종이의 가로 크기
		
		arr = new int[n][m]; // 종이
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				tetromino(i, j, i, j, 1, arr[i][j]); // dfs로 연결된 4칸 찾아서 값 계산
				tetromino_f(i, j, arr[i][j]);		 // 凸 모양 4칸 찾아서 값 계산
			}
		}
		
		System.out.println(max);
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	/**
	 * @param r		행
	 * @param c		열
	 * @param fr	이전 행
	 * @param fc	이전 열
	 * @param cnt	이전까지 탐색한 칸 수
	 * @param sum	이전까지 탐색한 칸들의 합
	 */
	static void tetromino(int r, int c, int fr, int fc, int cnt, int sum) {
		
		if(cnt == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 0; i < dr.length; i++) {
			if(r + dr[i] < 0 || r + dr[i] > arr.length - 1 
					|| c + dc[i] < 0 || c + dc[i] > arr[0].length - 1) continue;
			
			if(r + dr[i] == fr && c + dc[i] == fc) continue;
			
			tetromino(r + dr[i], c + dc[i], r, c, cnt + 1, sum + arr[r + dr[i]][c + dc[i]]);
		}
		
	}
	
	static void tetromino_f(int r, int c, int sum) {
		if(r - 1 >= 0 && c - 1 >= 0 && c + 1 < arr[0].length) { // ㅗ
			int ssum = sum;
			
			ssum += arr[r - 1][c];
			ssum += arr[r][c - 1];
			ssum += arr[r][c + 1];
			
			max = Math.max(max, ssum);
		} 
		
		if(r - 1 >= 0 && c + 1 < arr[0].length && r + 1 < arr.length) { // ㅏ
			int ssum = sum;
			
			ssum += arr[r - 1][c];
			ssum += arr[r][c + 1];
			ssum += arr[r + 1][c];
			
			max = Math.max(max, ssum);
		}
		
		if(r + 1 < arr.length && c - 1 >= 0 && c + 1 < arr[0].length) { // ㅜ
			int ssum = sum;
			
			ssum += arr[r + 1][c];
			ssum += arr[r][c - 1];
			ssum += arr[r][c + 1];
			
			max = Math.max(max, ssum);
		} 
		
		if(r - 1 >= 0 && c - 1 >= 0 && r + 1 < arr.length) { // ㅓ
			int ssum = sum;
			
			ssum += arr[r - 1][c];
			ssum += arr[r][c - 1];
			ssum += arr[r + 1][c];
			
			max = Math.max(max, ssum);
		}
	}
}
