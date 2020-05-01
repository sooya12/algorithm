package SWExpertAcademy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_4050_재관이의대량할인_D4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int sum = 0;
			
			for (int i = arr.length-1, cnt = 0; i >= 0; i--, cnt++) {
				if((cnt+1)%3 == 0) continue;
				sum += arr[i];
			}
			
			
			System.out.println("#" + tc + " " + sum);
		}
	}
}
