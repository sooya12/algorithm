package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2568_전깃줄2_시간초과 {
	
	static class Point implements Comparable<Point> { // 전봇대간 연결
		int a;
		int b;
		
		public Point(int a, int b){
			this.a = a;
			this.b = b;
		}

		@Override
		public String toString() {
			return "Point [a=" + a + ", b=" + b + "]";
		}

		@Override
		public int compareTo(Point o) {
			return this.a - o.a;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 두 전봇대 사이 전깃줄 개수
		
		ArrayList<Point> list = new ArrayList<>(); // 연결을 위치를 저장할 리스트
		Point p;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			p = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			list.add(p);
		}
		
		Collections.sort(list); // A 전봇대 기준 오름차순 정렬
		
		int[] dp = new int[N]; // 최장증가수열 dp를 위한 배열
		ArrayList<Integer>[] dpList = new ArrayList[N]; // 각 전봇대의 최장증가수열에 어떤 값이 포함되었는지 저장할 리스트
		for (int i = 0; i < N; i++) {
			dpList[i] = new ArrayList<>();
		}
		
		ArrayList<Integer> tmpI;
		ArrayList<Integer> tmpJ;
		
		for (int i = 0; i < N; i++) {
			tmpI = dpList[i];
			
			if(dp[i] == 0) {  
				dp[i] = 1;
				tmpI.add(list.get(i).a);
			}
			for (int j = 0; j < i; j++) {
				if(list.get(i).b > list.get(j).b && dp[i] < dp[j]+1) {
					dp[i] = dp[j] + 1;
					tmpI.clear();
					
					tmpJ = dpList[j];
					for (int k = 0; k < tmpJ.size(); k++) {
						tmpI.add(tmpJ.get(k));
					}
					tmpI.add(list.get(i).a);
				} 
			}
		}
		
		int max = 0;
		int maxIdx = -1;
		for (int i = 0; i < N; i++) {
			if(max < dp[i]) {
				max = dp[i];
				maxIdx = i;
			}
		}
		
		System.out.println(N - max);
		
		tmpI = dpList[maxIdx];
		int a;
		
		for (int i = 0; i < list.size(); i++) {
			a = list.get(i).a;
			if(!tmpI.contains(a)) 
				System.out.println(a);
		}
	}
}
