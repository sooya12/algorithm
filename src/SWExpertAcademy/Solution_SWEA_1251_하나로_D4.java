package SWExpertAcademy;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_SWEA_1251_하나로_D4 {
	
	static int n; // 섬의 개수 (1 <= n <= 1000)
	static int[] landx; // 섬 x 좌표
	static int[] landy; // 섬 y 좌표
	static double e; // 세수
	static boolean[] visited; // 방문 여부
	static int min; // 최소 환경 부담금
	
	public static int[] p;
	public static int[] rank;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt(); // 테스트 케이스 수
		
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt(); 
			
			landx = new int[n];
			landy = new int[n];
			visited = new boolean[n];
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < n; i++) {
				landx[i] = sc.nextInt(); // x 좌표 
			}
			
			for (int i = 0; i < n; i++) {
				landy[i] = sc.nextInt(); // y 좌표
			}
			
			e = sc.nextDouble(); // 세수
			
			// 간선 배열을 사용
			Edge[] G = new Edge[n*(n-1)/2];
			int idx = -1;
			
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					if(i == j) continue;
					
					G[++idx] = new Edge(i, j, length(landx[i], landy[i], landx[j], landy[j]));
				}
			}
			
			Arrays.sort(G);
			
			// 각 정점을 집합으로 만듦
			p = new int[n];
			rank = new int[n];
			for (int i = 0; i < p.length; i++) {
				makeSet(i);
			}
			
			int cnt = 0; // 선택된 간선의 개수
			double MST = 0; // 최소 신장 트리의 가중치 합
			
			// 가중치가 최소인 간선을 V-1개 선택
			for (int i = 0; i < n*(n-1)/2; i++) { // 간선을 정렬해놓은 순서대로 검토
				Edge ed = G[i];
				
				int px = findSet(ed.a);
				int py = findSet(ed.b);
				
				// 사이클이 생기면 안됨, 대표자가 다르면
				if(px != py) {
					// 두 정점을 같은 집합으로 합침
					union(px, py);
					
					cnt++;
					MST += (double)(e*ed.val);
					
					if(cnt == n-1) break;
				}
			}
			
			System.out.println("#" + tc + " " + Math.round(MST));
			
		}
		
	}
	
	private static double length(int sr, int sc, int er, int ec) {
		return (double)(Math.pow(Math.abs(sr - er), 2) + Math.pow(Math.abs(sc - ec), 2));
	}
	
	public static void union(int px, int py) {
		// rank 값을 기준으로 합치자
		if(rank[px] > rank[py]) {
			// 큰 쪽을 대표자로
			p[py] = px;
			
		} else {
			p[px] = py;
			
			if(rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}

	public static int findSet(int x) {
		if(p[x] != x) p[x] = findSet(p[x]); // 패스 컴프레션

		return p[x];
	}
	
	

	private static void makeSet(int x) {
		p[x] = x;
	}

	public static class Edge implements Comparable<Edge>{
		int a; // 정점1
		int b; // 정점2
		double val; // 가중치
		
		public Edge() {}
		
		public Edge(int a, int b, double val) {
			super();
			this.a = a;
			this.b = b;
			this.val = val;
		}
		
		@Override
		public String toString() {
			return a + ", " + b + ", " + val;
		}

		@Override
		public int compareTo(Edge o) {
			// 나 this o1, 참조변수 o o2
			return (int) (this.val - o.val); // 가중치 기준 오름차순 정렬
		}
	}
}
