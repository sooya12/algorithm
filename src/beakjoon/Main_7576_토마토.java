package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {

	public static int day = 0; // 익기까지 걸린 날짜
	public static int cnt = 0; // 0에서 1로 변한 토마토들
	public static int zero = 0; // 기존의 0인 토마토들
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken()); // 토마토 상자 가로 칸 수
		int n = Integer.parseInt(st.nextToken()); // 토마토 상자 세로 칸 수

		int[][] box = new int[n][m];
		
		Queue<Integer> qr = new LinkedList<>(); // 익은 토마토의 행 좌표
		Queue<Integer> qc = new LinkedList<>(); // 익은 토마토의 열 좌표
		

		for (int i = 0; i < box.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < box[i].length; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());

				if (box[i][j] == 0)
					zero++;
				if (box[i][j] == 1) {
					qr.add(i);
					qc.add(j);
				}
			}
		}

		/*
		 * 큐에 1 좌표 삽입 0 개수 세기 
		 * 0 개수가 없다면 0 출력 
		 * 사방탐색 현재 1 좌표 큐에서 제거 
		 * 탐색을 통해 익게된 1 좌표 추가 추가할 때마다, 차감된 0 개수 세기
		 * 
		 * 큐가 비게 되었을 때, 기존의 0 개수와 차감된 0 개수가 같다면 다 익은 것 
		 * 같지 않다면 -1 출력
		 */

		if (zero == 0)
			System.out.println(0);

		else {
			search(qr, qc, day, cnt, box);
		}

	} // end of main

	static int[] dy = { -1, 0, 1, 0 }; // 행
	static int[] dx = { 0, 1, 0, -1 }; // 열

	static void search(Queue<Integer> qr, Queue<Integer> qc, int day, int cnt, int[][] arr) { // 사방탐색
		if (qr.isEmpty() || qc.isEmpty()) {
			day -= 1;
			if(zero == cnt) System.out.println(day); // 토마토가 다 익었을 때
			else System.out.println(-1); // 토마토가 다 익지 않았을 때
			return;
		}

		int n = qr.size();
		
		while(n > 0) { // q 사이즈 만큼 반복
			int r = qr.poll();
			int c = qc.poll();
			
			for (int i = 0; i < dy.length; i++) {
				if (r + dy[i] < 0 || r + dy[i] > arr.length - 1 || c + dx[i] < 0 || c + dx[i] > arr[0].length - 1)
					continue;

				if (arr[r + dy[i]][c + dx[i]] == 0) {
					qr.add(r + dy[i]);
					qc.add(c + dx[i]);
					cnt++; // 새롭게 익은 토마토 개수 세기 (기존에 0이었던)
					arr[r + dy[i]][c + dx[i]] = 1;
				}
			}
			n--;
		}
		
		search(qr, qc, day+1, cnt, arr);
	} // end of search

}
