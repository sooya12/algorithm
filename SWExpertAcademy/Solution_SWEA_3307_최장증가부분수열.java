package SWExpertAcademy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3307_최장증가부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 수
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 수열의 길이
			int[] arr = new int[N]; // 수열의 원소
			int[] dp = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = Integer.MIN_VALUE;
			
			for (int i = 0; i < dp.length; i++) {
				dp[i] = 1;
				
				for (int j = 0; j < i; j++) {
					if(arr[i] > arr[j] && dp[i] < dp[j]+1) dp[i] = dp[j]+1;
				}
				
				max = Math.max(max, dp[i]);
			}
			
			System.out.println("#" + tc + " " + max);
		}
	}
}
