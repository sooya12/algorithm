package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] v = new boolean[200002];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		v[N] = true;
		
		int cnt = 0;
		boolean flag = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			while(size > 0) {
				int val = q.poll();
				
				size--;
				
				if(val == K) {
					flag = false;
					break;
				}
				
				if(val < 0 || val > 100000) continue;
				
				if(val*2 <= 100000 && !v[val*2]) {
					v[val*2] = true;
					q.add(val*2);
				}
				if(val+1 <= 100000 && !v[val+1]) {
					v[val+1] = true;
					q.add(val+1);
				}
				if(val-1 >= 0 && !v[val-1]) {
					v[val-1] = true;
					q.add(val-1);
				}
			}
			
			if(!flag) break;
			
			cnt++;
		}
		
		System.out.println(cnt);
	}

}
