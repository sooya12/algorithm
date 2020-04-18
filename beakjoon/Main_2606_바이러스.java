package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		int e = Integer.parseInt(br.readLine()); // 네트워크 상 직접 연결된 컴퓨터 쌍의 수
		
		int[][] D = new int[n][n];
		
		for (int i = 0; i < D.length; i++) {
			Arrays.fill(D[i], 99999);
		}
		
		// 연결된 컴퓨터 쌍의 수 D에 입력 - 간선 정보 저장
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int v1 = Integer.parseInt(st.nextToken())-1; // 정점 1
			int v2 = Integer.parseInt(st.nextToken())-1; // 정점 2
			
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
		
//		for (int i = 0; i < D.length; i++) {
//			System.out.println(Arrays.toString(D[i]));
//		}
		
		int cnt = 0; // 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수
		
		for (int i = 0; i < D.length; i++) {
			if(D[0][i] != 99999) cnt++;
		}
		
		System.out.println(cnt);
	}
}
