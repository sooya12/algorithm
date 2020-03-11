package SWExpertAcademy;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_SWEA_7793_오나의여신님_D5 {
	static char[][] map; // 전체 위치 배열
	static boolean[][] visited; // 수연 방문 여부 확인
	static boolean[][] devilhand; // 악마 손아귀 방문 여부 확인
	
	static int n;
	static int m;
	
	static int min; // 최소 거리
	
	static int goddessr; // 여신 위치 행
	static int goddessc; // 여신 위치 열
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt(); // 행
			m = sc.nextInt(); // 열
			
			map = new char[n][m];
			visited = new boolean[n][m]; 
			devilhand = new boolean[n][m]; 
			
			Queue<Integer> qd = new LinkedList<Integer>(); // 악마
			Queue<Integer> qs = new LinkedList<>(); // 수연
			
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (int j = 0; j < m; j++) {
					map[i][j] = s.charAt(j);
					
					if(map[i][j] == 'S') {
						qs.add(i);
						qs.add(j);
					} else if(map[i][j] == '*') {
						qd.add(i);
						qd.add(j);
					} else if(map[i][j] == 'D') {
						goddessr = i;
						goddessc = j;
					}
				}
			} // end of for input
			
			move(0, qd, qs);
			
			if(min == Integer.MAX_VALUE) System.out.println("#" + tc + " GAME OVER");
			else System.out.println("#" + tc + " " + min);
		}
	} // end of main
	
	static void move(int cnt, Queue<Integer> qd, Queue<Integer> qs) {
		
		if(min < cnt) return; // 최소값 갱신 못하므로
		
		int size = qs.size()/2;
		
		for (int s = 0; s < size; s++) {
			int sr = qs.poll();
			int sc = qs.poll();
			
			qs.add(sr);
			qs.add(sc);
			
			for (int i = 0; i < dr.length; i++) {
				if(sr + dr[i] < 0 || sr + dr[i] > n - 1 
						|| sc + dc[i] < 0 || sc + dc[i] > m - 1) continue;
				
				if(map[sr + dr[i]][sc + dc[i]] == 'D') {
					min = Math.min(min, cnt + 1);
					return;
				}
			}
		}
		
		if(!check()) return; // 여신에게 도달할 방법이 없을 때
		
		size = qd.size()/2;
		if(size > 0) {
			for (int s = 0; s < size; s++) {
				int dvr = qd.poll(); // 악마 손아귀 행 좌표
				int dvc = qd.poll(); // 악마 손아귀 열 좌표
				
				for (int i = 0; i < dr.length; i++) {
					if(dvr + dr[i] < 0 || dvr + dr[i] > n - 1 
							|| dvc + dc[i] < 0 || dvc + dc[i] > m - 1) continue;
					
					if((map[dvr + dr[i]][dvc + dc[i]] == '.' || map[dvr + dr[i]][dvc + dc[i]] == 'S') && !devilhand[dvr + dr[i]][dvc + dc[i]]) {
						devilhand[dvr + dr[i]][dvc + dc[i]] = true;
						map[dvr + dr[i]][dvc + dc[i]] = '*';
						qd.add(dvr + dr[i]);
						qd.add(dvc + dc[i]);
					}
				}
			}
		}
		
		if(qs.isEmpty()) return; // 없으면 런타임 에러 발생
		
		size = qs.size()/2;
		if(size > 0) {
			for (int s = 0; s < size; s++) {
				int sr = qs.poll();
				int sc = qs.poll();
				
				for (int i = 0; i < dr.length; i++) {
					if(sr + dr[i] < 0 || sr + dr[i] > n - 1 
							|| sc + dc[i] < 0 || sc + dc[i] > m - 1) continue;
					
					if(map[sr + dr[i]][sc + dc[i]] == '.' && !visited[sr + dr[i]][sc + dc[i]] && !devilhand[sr + dr[i]][sc + dc[i]]) {
						visited[sr + dr[i]][sc + dc[i]] = true;
						map[sr + dr[i]][sc + dc[i]] = 'S';
						
						qs.add(sr + dr[i]);
						qs.add(sc + dc[i]);
					}
				}
			}
		}
		
		move(cnt + 1, qd, qs);
		
	} // end of move
	
	static boolean check() {
		
		for (int i = 0; i < dr.length; i++) {
			if(goddessr + dr[i] < 0 || goddessr + dr[i] > n - 1 
					|| goddessc + dc[i] < 0 || goddessc + dc[i] > m - 1) continue;
			
			if(map[goddessr + dr[i]][goddessc + dc[i]] == '.') return true;
		}
		
		return false;
	} // end of check
}
