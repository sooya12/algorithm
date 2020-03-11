package SWExpertAcademy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5656_벽돌깨기 {

	static int n; // 구슬 쏘는 횟수
	static int w; // 벽돌 열
	static int h; // 벽돌 행
	static int[][] arr;
	static int min; // 남은 벽돌 수. 최대한 많이 깼을 때이므로, 최솟값 구해야 함

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int t = Integer.parseInt(st.nextToken()); // 테스트 케이스 수

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			arr = new int[h][w]; 
			
			min = Integer.MAX_VALUE; 

			for (int i = 0; i < arr.length; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end of input

			makePermutation(0, new int[n]);

			System.out.println("#" + tc + " " + min);

		} // end of tc

	}

	// 중복 순열
	private static void makePermutation(int r, int[] tmp) {
		if (r == n) {
			int[][] copyArr = new int[h][w];
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					copyArr[i][j] = arr[i][j];
				}
			}
			
			for (int i = 0; i < tmp.length; i++) {
				for (int j = 0; j < h; j++) {
					if(copyArr[j][tmp[i]] > 0) {
						broken(j, tmp[i], copyArr);
						down(copyArr);
						break;
					}
				}
			}
			
			min = Math.min(min, cnt(copyArr));
			
		} else {
			for (int i = 0; i < w; i++) {
				tmp[r] = i;
				makePermutation(r + 1, tmp);
			}
		}
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void broken(int r, int c, int[][] copyArr) {
		int val = copyArr[r][c];
		copyArr[r][c] = 0;

		for (int i = 0; i < dr.length; i++) {
			for (int j = 1; j <= val - 1; j++) {
				if (r + dr[i] * j >= 0 && r + dr[i] * j < copyArr.length && c + dc[i] * j >= 0
						&& c + dc[i] * j < copyArr[0].length) {

					if (copyArr[r + dr[i] * j][c + dc[i] * j] > 0)
						broken(r + dr[i] * j, c + dc[i] * j, copyArr);
				}
			}
		}
	}

	public static void down(int[][] copyArr) {
		for (int i = copyArr.length - 1; i >= 0; i--) {
			for (int j = 0; j < copyArr[i].length; j++) {
				if (copyArr[i][j] == 0) {
					for (int k = i - 1; k >= 0; k--) {
						if (copyArr[k][j] > 0) {
							copyArr[i][j] = copyArr[k][j];
							copyArr[k][j] = 0;
							break;
						}
					}
				}
			}
		}
	}
	
	public static int cnt(int[][] copyArr) {
		int cnt = 0;
		
		for (int i = 0; i < copyArr.length; i++) {
			for (int j = 0; j < copyArr[i].length; j++) {
				if(copyArr[i][j] > 0) cnt++;
			}
		}
		
		return cnt;
	}
}
