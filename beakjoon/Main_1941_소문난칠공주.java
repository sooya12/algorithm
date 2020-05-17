package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1941_소문난칠공주 {
	
	static char[][] arr; // 자리배치도
	static int[] num; // 조합을 위한 0 ~ 24
	static boolean[] v; // 방문 여부
	static ArrayList<Integer> list; // 각 조합의 구성
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int max = 0; // 경우의 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new char[5][5]; // 자리 배치도
		
		for (int i = 0; i < 5; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < 5; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		num = new int[25];
		
		for (int i = 0; i < 25; i++) {
			num[i] = i;
		}
		
		comb(0, new int[7], 0, 0); // 7명의 조합
		
		System.out.println(max);
	}
	
	public static void comb(int r, int[] tmp, int idx, int cnt) {
		if(r == 7) { // 7명이면서
			if(cnt >= 4) { // 이다솜파가 4명 이상인 경우
				list = new ArrayList<>();
				
				for (int i = 0; i < tmp.length; i++) {
					list.add(tmp[i]);
				}
				bfs(tmp); // 서로 인접해서 앉았는지 확인
			}
			
			return;
		} else {
			for (int i = idx; i < num.length; i++) {
				tmp[r] = num[i];
				
				if(arr[num[i]/5][num[i]%5] == 'S') // 이다솜파인 경우
					comb(r+1, tmp, i+1, cnt+1);
				else 
					comb(r+1, tmp, i+1, cnt);
			}
		}
	}

	private static void bfs(int[] tmp) {
		Queue<Integer> q = new LinkedList<>();
		q.add(tmp[0]);
		
		v = new boolean[25];
		v[tmp[0]] = true;
		
		int cnt = 1; // 인접한 사람 수
		
		while(!q.isEmpty()) {
			int val = q.poll();
			int r = val/5; // 행
			int c = val%5; // 열
			
			for (int i = 0; i < dr.length; i++) {
				int next = (r + dr[i])*5 + c + dc[i];
				
				if(0 <= r + dr[i] && r + dr[i] < 5 && 0 <= c + dc[i] && c + dc[i] < 5 
						&& !v[next] && list.contains(next)) {
					cnt++;
					v[next] = true;
					q.add(next);
				}
			}
		}
		
		if(cnt == 7) { // 7명 모두가 인접한 경우
			max++;
		}
		
		return;
	}
}
