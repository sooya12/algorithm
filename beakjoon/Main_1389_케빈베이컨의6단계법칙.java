package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1389_케빈베이컨의6단계법칙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 유저의 수
		int M = Integer.parseInt(st.nextToken()); // 친구 관계 수
		
		int[][] D = new int[N][N];
		
		for (int i = 0; i < D.length; i++) {
			Arrays.fill(D[i], 987654321);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int v1 = Integer.parseInt(st.nextToken()) - 1; // 유저 1
			int v2 = Integer.parseInt(st.nextToken()) - 1; // 유저 2
			
			D[v1][v2] = 1;
			D[v2][v1] = 1;
		}
		
		for (int k = 0; k < D.length; k++) {
			for (int i = 0; i < D.length; i++) {
				if(k == i) continue;
				
				for (int j = 0; j < D.length; j++) {
					if(k == j || i == j) continue;
					
					if(D[i][j] > D[i][k] + D[k][j]) {
						D[i][j] = D[i][k] + D[k][j];
					}
				}
			}
		}
		
		int min = Integer.MAX_VALUE; // 최소 케빈 베이컨 수
		int minIdx = -1; // 최소 케빈 베이컨 수를 가진 유저
		
		for (int i = 0; i < D.length; i++) {
			int cnt = 0; // 각 유저의 케빈 베이컨 수
			
			for (int j = 0; j < D.length; j++) {
				if(D[i][j] != 987654321) cnt += D[i][j];
			}
			
			if(min > cnt) {
				min = cnt;
				minIdx = i;
			}
		}
		
		System.out.println(minIdx + 1);
	}
}
