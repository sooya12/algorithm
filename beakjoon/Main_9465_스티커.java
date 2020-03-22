package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465_스티커 {
	
	static int n; // 스티커 총 개수는 2n
	static int[][] stickers; // 스티커 배열
	static int[][] memo; // 메모이제이션

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			stickers = new int[2][n];
			memo = new int[2][n];
			
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				for (int j = 0; j < n; j++) {
					stickers[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end of input
			
			memoization();
			
			System.out.println(Math.max(memo[0][n-1], memo[1][n-1]));
			
		} // end of testcase
	} // end of main
	
	private static void memoization() {
		memo[0][0] = stickers[0][0];
		memo[1][0] = stickers[1][0];
		
		memo[0][1] = memo[1][0] + stickers[0][1];
		memo[1][1] = memo[0][0] + stickers[1][1];
		
		for (int i = 2; i < n; i++) {
			memo[0][i] = Math.max(memo[0][i-2], memo[1][i-2]);
			memo[0][i] = Math.max(memo[1][i-1], memo[0][i]);
			memo[0][i] += stickers[0][i];
			
			memo[1][i] = Math.max(memo[0][i-2], memo[1][i-2]);
			memo[1][i] = Math.max(memo[0][i-1], memo[1][i]);
			memo[1][i] += stickers[1][i];
		}
	} // end of memoization
	
}
