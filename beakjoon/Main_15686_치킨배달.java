package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
	
	static int n; // 도시의 크기
	static int m; // 수익을 많이 낼 수 있는 치킨집의 개수
	static int[][] arr; // 도시 배열
	static ArrayList<Integer> home = new ArrayList<>(); // 집 위치 
	static ArrayList<Integer> chicken = new ArrayList<>(); // 치킨집 위치
	static int min = Integer.MAX_VALUE; // 최소 도시 치킨 거리
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken()); 
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];
		
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(arr[i][j] == 1) {
					home.add(i);
					home.add(j);
				} else if(arr[i][j] == 2) {
					chicken.add(i);
					chicken.add(j);
				}
			}
		} // end of for input
		
		makeCombination(2*m, new int[2*m], 0);
		
		System.out.println(min);
		
	} // end of main

	private static void makeCombination(int r, int[] tmp, int idx) {
		if(r == 0) {
			
			int sum = 0; // 해당 조합의 도시 치킨 거리
			boolean turn = true;
			
			for (int i = 0; i < home.size(); i+=2) {
				
				if(sum > min) { // 가지치기
					turn = false;
					break;
				}
				
				int hsum = Integer.MAX_VALUE; // 해당 집의 최소 치킨 거리 
				
				for (int j = 0; j < tmp.length; j+=2) {
					hsum = Math.min(hsum, Math.abs(home.get(i) - tmp[j]) + Math.abs(home.get(i + 1) - tmp[j + 1]));
				}
				
				sum += hsum;
			}
			
			if(turn) min = Math.min(min, sum);
		} else {
			for (int i = idx; i < chicken.size(); i+=2) {
				tmp[r - 2] = chicken.get(i);
				tmp[r - 1] = chicken.get(i + 1);
				
				makeCombination(r - 2, tmp, i + 2);
			}
		}
	}
}
