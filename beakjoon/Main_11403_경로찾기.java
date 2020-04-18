package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11403_경로찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 정점의 개수
		
		int[][] D = new int[N][N]; // 그래프 인접 행렬
		
		for (int i = 0; i < D.length; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < D.length; j++) {
				int input = Integer.parseInt(st.nextToken());
				
				if(input == 1) D[i][j] = 1;
				else D[i][j] = 99999;
			}
		}
		
		for (int k = 0; k < D.length; k++) {
			for (int i = 0; i < D.length; i++) {
				if(k == i) continue;
				
				for (int j = 0; j < D.length; j++) {
//					if(k == j || i == j) continue;
					
					if(D[i][j] > D[i][k] + D[k][j]) {
						D[i][j] = 1;
					}
				}
			}
		}
		
		for (int i = 0; i < D.length; i++) {
			for (int j = 0; j < D.length; j++) {
				System.out.print(D[i][j] == 99999? 0 + " " : 1 + " ");
			}
			System.out.println();
		}
		
	}
}
