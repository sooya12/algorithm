package beakjoon;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2178_미로탐색 {
	
	static char[][] arr; // 미로
	static boolean[][] visited; // 방문 여부
	static Queue<Integer> qr = new LinkedList<Integer>(); // 방문하고 1인 행
	static Queue<Integer> qc = new LinkedList<Integer>(); // 방문하고 1인 열
	static Queue<Integer> qcnt = new LinkedList<Integer>(); // 방문했을 때까지 이동 횟수
	static int min = Integer.MAX_VALUE; // n, m 까지의 최소 이동 횟수
	
	static int[] dr = {-1, 0, 1, 0}; // 사방탐색
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 목적지 n 행
		int m = sc.nextInt(); // 목적지 m 열
		
		arr = new char[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < arr.length; i++) {
			String s = sc.next();
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		//시작 위치 
		qr.add(0);
		qc.add(0);
		qcnt.add(1);
		
		visited[0][0] = true;
		
		while(!qr.isEmpty()) {
			int r = qr.poll();
			int c = qc.poll();
			int cnt = qcnt.poll();
			
			for (int i = 0; i < dr.length; i++) {
				if(r + dr[i] < 0 || r + dr[i] > arr.length - 1 
						|| c + dc[i] < 0 || c + dc[i] > arr[0].length - 1) continue;
				
				if(r + dr[i] == arr.length - 1 && c + dc[i] == arr[0].length - 1) min = Math.min(min, cnt + 1);
				
				else if(arr[r + dr[i]][c + dc[i]] == '1' && !visited[r + dr[i]][c + dc[i]]) {
					qr.add(r + dr[i]);
					qc.add(c + dc[i]);
					qcnt.add(cnt + 1);
					
					visited[r + dr[i]][c + dc[i]] = true;
				}
			}
		}
		
		System.out.println(min);
		
	}
	
}
