package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_P기능개발 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[] {1, 30, 5})));
		System.out.println(Arrays.toString(solution(new int[]{90, 95, 2, 97}, new int[] {2, 3, 2, 3})));
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		int[] result = new int[progresses.length];
		
		Queue<function> q = new LinkedList<>();
		for (int i = 0; i < progresses.length; i++) {
			q.offer(new function(progresses[i], speeds[i], i));
		}
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			cnt++;
			
			int size = q.size();
			function f;
			
			for (int i = 0; i < size; i++) {
				f = q.poll();
				
				if(f.progress + f.speed >= 100) {
					result[f.idx] = cnt;
				} else {
					f.progress += f.speed;
					q.offer(f);
				}
			}
		}
		
		int answerCnt = 0;
		
		for (int i = 0; i < result.length; i++) {
			if(result[i] == 0) continue;
			answerCnt++;
			int checkCnt = 1;
			for (int j = i + 1; j < result.length; j++) {
				if(result[j] == 0) continue;
				
				if(result[j] > result[i]) break;
				
				result[j] = 0;
				checkCnt++;
			}
			
			result[i] = checkCnt;
		}
		
		answer = new int[answerCnt];
		int idx = 0;
		
		for (int i = 0; i < result.length; i++) {
			if(result[i] > 0) answer[idx++] = result[i];
		}
		
		return answer;
	}
	
	static class function{
		int progress;
		int speed;
		int idx;
		
		public function() {}
		
		public function(int progress, int speed, int idx) {
			this.progress = progress;
			this.speed = speed;
			this.idx = idx;
		}
		
		@Override
		public String toString() {
			return progress + " " + speed;
		}
	}
}
