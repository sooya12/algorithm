package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_18290_NM과K1 {
	
	private static int N;
	private static int M;
	private static int K;
	private static int[][] arr;
	private static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // NxM 격자판
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // K 칸 선택
		
		arr = new int[N][M]; // 격자판
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				boolean[][] v = new boolean[N][M];
				
				v[i][j] = true;
				
				for (int k = 0; k < dr.length; k++) {
					if(i + dr[k] >= 0 && i + dr[k] < N && j + dc[k] >= 0 && j + dc[k] < M) {
						v[i+dr[k]][j+dc[k]] = true;
					}
				}
				
				search(arr[i][j], 1, v);
			}
		}
		
		System.out.println(max);
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static ArrayList<int[]> list;
	
	private static void search(int sum, int cnt, boolean[][] v) {
		if(cnt == K) {
			max = Math.max(max, sum);
			return;
		}
		
		int maxVal = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!v[i][j] && maxVal < arr[i][j]) {
					maxVal = arr[i][j];
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!v[i][j] && maxVal == arr[i][j]) {
					v[i][j] = true;
					
					list = new ArrayList<>();
					
					for (int k = 0; k < dr.length; k++) {
						if(i + dr[k] >= 0 && i + dr[k] < N && j + dc[k] >= 0 && j + dc[k] < M) {
							if(!v[i + dr[k]][j + dc[k]]) {
								list.add(new int[] {i + dr[k], j + dc[k]});
							}
							
							v[i + dr[k]][j + dc[k]] = true;
						}
					}
					
					search(sum + arr[i][j], cnt + 1, v);
					
					v[i][j] = false;
					
					for(int[] tmp : list) {
						v[tmp[0]][tmp[1]] = false;
					}
				}
			}
		}
	}
}
