package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {

	static int N, M; // 정점 개수, 간선 개수
	static int[] parent; // 연결된 부모 정점 저장
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			makeSet(i);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			union(x, y);
 		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			int p = findSet(parent[i]);
			
			if(!list.contains(p))
				list.add(p);
		}
		
		System.out.println(list.size());
	}
	
	private static void makeSet(int x) {
		parent[x] = x;
	}
	
	private static int findSet(int x) {
		if(x == parent[x])
			return x;
		else {
			parent[x] = findSet(parent[x]);
			
			return parent[x];
		}
	}
	
	private static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(px != py) {
			parent[py] = px;
		}
	}
	
}
