package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17142_연구소3 {

	static int N; // 연구소 크기
	static int M; // 놓을 수 있는 바이러스 개수
	static int[][] arr; // 연구소 정보
	
	static class Point {
		int r;
		int c;
		
		Point(int r, int c){
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
	
	static ArrayList<Point> list; // 바이러스 위치 저장
	static int min = Integer.MAX_VALUE; // 바이러스 퍼지는 최소 시간
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(arr[i][j] == 2) {
					list.add(new Point(i, j));
				}
			}
		}
		
		if(check(arr)) { // 연구소에 빈 곳이 없는 경우
			System.out.println(0);
		} else {
			comb(0, new int[M], 0); // 조합으로 M개의 위치 선정
			
			min = (min == Integer.MAX_VALUE) ? -1 : min; // 바이러스를 퍼뜨릴 수 없는 경우 -1 출력
			System.out.println(min);
		}
	} 
	
	private static void comb(int r, int[] tmp, int idx) { // M개의 바이러스 위치 구하기
		if(r == M) {
			spread(tmp); // 바이러스 BFS로 퍼뜨리기
			return;
		}
		
		for (int i = idx; i < list.size(); i++) {
			tmp[r] = i;
			comb(r+1, tmp, i+1);
		}
	}
	
	static int[] dr = {-1, 0, 1, 0}; // 사방탐색
	static int[] dc = {0, 1, 0, -1};
	
	private static void spread(int[] tmp) { // BFS
		int[][] trr = new int[N][N]; // 새로운 연구소 정보
		for (int i = 0; i < N; i++) {
			trr[i] = arr[i].clone();
		}
		
		int r, c;
		Point p;
		
		int idx = 0;
		for (int i = 0; i < list.size(); i++) {
			if(idx < tmp.length && tmp[idx] == i) { // 선택된 바이러스인 경우
				idx++;
				continue;
			}
			
			p = list.get(i); // 선택되지 못한 바이러스인 경우
			trr[p.r][p.c] = -2;
		}
		
		Queue<Point> q = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			p = list.get(tmp[i]);
			
			r = p.r;
			c = p.c;
			
			trr[r][c] = 2;
			q.offer(p);
		}
		
		int size;
		int nr, nc;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			size = q.size();
			cnt++;
			
			for (int i = 0; i < size; i++) {
				p = q.poll();
				r = p.r;
				c = p.c;
				
				for (int j = 0; j < dr.length; j++) {
					nr = r + dr[j];
					nc = c + dc[j];
					
					if(0 <= nr && nr < N && 0 <= nc && nc < N && (trr[nr][nc] == 0 || trr[nr][nc] == -2)) {
						q.offer(new Point(nr, nc));
						trr[nr][nc] = cnt;
					}
				}
			}
			
			if(check(trr)) { // 바이러스가 다 퍼진 경우 (= 0이 없는 경우)
				min = Math.min(min, cnt);
				return;
			}
		}
	}
	
	private static boolean check(int[][] trr) { // 연구소에 0이 있는지 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(trr[i][j] == 0) return false;
			}
		}
		
		return true;
	}
}
