package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	
	static int n; // 사람 수
	static int[][] arr; // 능력치
	static int min; // 최소 값
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		
		makeCombination(n/2, new int[n/2], 0); // 스타트팀 조합
		
		System.out.println(min);
	}
	
	static void makeCombination(int r, int[] start, int idx) {
		if(r == 0) {
			cal(start);
		} else {
			for (int i = idx; i < arr.length; i++) {
				start[r - 1] = i;
				
				makeCombination(r - 1, start, i + 1);
			}
		}
	}
	
	static void cal(int[] start) {
		int ssum = 0; // 스타트팀 능력치 합
		int lsum = 0; // 링크팀 능력치 합
		
		int[] link = new int[n/2]; 
		int idx = 0;
		
		for (int i = 0; i < n; i++) {
			boolean turn = false;
			
			for (int j = 0; j < start.length; j++) {
				if(i == start[j]) turn = true;
			}
			
			if(!turn) link[idx++] = i; // 스타트팀에 해당하지 않는 사람
		}
		
		for (int i = 0; i < start.length; i++) {
			for (int j = 0; j < start.length; j++) {
				if(i == j) continue;
				
				ssum += arr[start[i]][start[j]];
				lsum += arr[link[i]][link[j]];
			}
		}
		
//		for (int i = 0; i < link.length; i++) {
//			for (int j = 0; j < link.length; j++) {
//				if(i == j) continue;
//				
//				lsum += arr[link[i]][link[j]];
//			}
//		}
		min = Math.min(min, Math.abs(ssum - lsum));
	}
}
