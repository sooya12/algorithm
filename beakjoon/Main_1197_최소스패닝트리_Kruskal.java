package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리_Kruskal {
	
	static int[] parents;
	static int[] rank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		parents = new int[V];
		rank = new int[V];
		
		int[][] edges = new int[E][3];
		
		for (int i = 0; i < edges.length; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			edges[i][0] = Integer.parseInt(st.nextToken()) - 1; // 정점 1
			edges[i][1] = Integer.parseInt(st.nextToken()) - 1; // 정점 2
			edges[i][2] = Integer.parseInt(st.nextToken()); // 가중치
		}
		
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		for (int i = 0; i < V; i++) {
			makeSet(i);
		}
		
		int result = 0;
		int cnt = 0;
		
		for (int i = 0; i < E; i++) {
			int a = findSet(edges[i][0]);
			int b = findSet(edges[i][1]);
			
			if(a == b) continue;
			
			union(a, b);
			
			result += edges[i][2];
			cnt++;
			
			if(cnt == V - 1) break;
		}
		
		System.out.println(result);
	}
	
	public static void makeSet(int x) {
		parents[x] = x;
	}
	
	public static int findSet(int x) {
		if(parents[x] == x) {
			return x;
		} else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}
	
	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(rank[px] > rank[py]) {
			parents[py] = px;
		} else {
			parents[px] = py;
			
			if(rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}
	
}
