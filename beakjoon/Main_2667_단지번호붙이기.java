package beakjoon;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main_2667_단지번호붙이기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] arr = new int[n][n];
		boolean[][] visited = new boolean[n][n];

		String s = "";

		for (int i = 0; i < arr.length; i++) {
			s = sc.next();
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		int[] dr = { -1, 0, 1, 0 }; // 행 델타
		int[] dc = { 0, 1, 0, -1 }; // 열 델타

		Stack<Integer> st = new Stack<>(); // dfs 탐색을 위한 스택
		
		ArrayList<Integer> list = new ArrayList<>(); // 단지의 집 개수 담을 곳
		
		int cnt = 0; // 각 단지의 집 개수
		int danzi = 0; // 단지의 개수

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					
					danzi++;
					
					st.add(i);
					st.add(j);

					visited[i][j] = true;

					cnt = 1;

					while (!st.isEmpty()) {
						int c = st.pop(); // 열
						int r = st.pop(); // 행

						for (int k = 0; k < dc.length; k++) {
							if (r + dr[k] < 0 || r + dr[k] > arr.length - 1 
									|| c + dc[k] < 0 || c + dc[k] > arr.length - 1)
								continue;

							if (arr[r + dr[k]][c + dc[k]] == 1 && !visited[r + dr[k]][c + dc[k]]) {
								visited[r + dr[k]][c + dc[k]] = true;

								cnt++;
								
								st.add(r + dr[k]);
								st.add(c + dc[k]);
							}
						}
					}
					
					list.add(cnt);
				}
			}
		}
		
		list.sort(null);
		
		System.out.println(danzi);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
