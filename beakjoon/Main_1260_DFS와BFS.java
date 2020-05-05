package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
	private static int N;
	private static int V;
	private static int M;
	private static int[][] G;
	private static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호
		
		G = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			G[v1][v2] = 1;
			G[v2][v1] = 1;
		}
		
		v = new boolean[N+1];

		v[V] = true;
		dfs(V);
		System.out.println();
		
		v = new boolean[N+1];
		
		bfs(V);
	}
	
	private static void dfs(int x) {
		System.out.print(x + " ");
		for (int i = 0; i < G.length; i++) {
			if(!v[i] && G[x][i] == 1) {
				v[i] = true;
				dfs(i);
			}
		}
	}
	
	private static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		v[x] = true;

		while (!q.isEmpty()) {
			int p = q.poll();
			System.out.print(p + " ");

			for (int i = 1; i < v.length; i++) {
				if (G[p][i] == 1 && !v[i]) {
					q.add(i);
					v[i] = true;
				}
			}
		}
	}
}
