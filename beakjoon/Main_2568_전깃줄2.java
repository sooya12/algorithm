package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2568_전깃줄2 {
	
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
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 두 전봇대 사이 전깃줄 개수
		
		ArrayList<Point> list = new ArrayList<>(); // 연결을 위치를 저장할 리스트
		Point p;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			p = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			list.add(p);
		}
		
		Collections.sort(list); // A 전봇대 기준 오름차순 정렬
		
		int[] lis = new int[N]; // 해당 인덱스에 올 수 있는 최솟값 저장
		int[] lisIdx = new int[N]; // lis 각 인덱스에 저장되는 값의 인덱스 저장
		int[] preIdx = new int[N]; // 경로 추적을 위한 이전 인덱스 저장
		
		int size = 0;
		
		for (int i = 0; i < N; i++) {
			int tmp = Arrays.binarySearch(lis, 0, size, list.get(i).b);
			tmp = -tmp-1;
			lis[tmp] = list.get(i).b;
			lisIdx[tmp] = i;
			preIdx[i] = (tmp == 0)? -1 : lisIdx[tmp-1];
			
			if(tmp == size) ++size;
		}
		
		int cur = lisIdx[size-1];
		Stack<Integer> s = new Stack<Integer>();
		
		while(cur != -1) {
			s.push(list.get(cur).b);
			cur = preIdx[cur];
		}
		
		sb.append(N-size).append("\n");
		
		for (int i = 0; i < N; i++) {
			if(!s.contains(list.get(i).b)) sb.append(list.get(i).a).append("\n");
		}
		System.out.println(sb.toString());
	}
}
