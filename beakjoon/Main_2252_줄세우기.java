package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252_줄세우기 {
	
	static int N;
	static int M;
	static ArrayList<Integer>[] list; // 정점이 향하고 있는 정점을 가진 리스트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 학생의 수
		M = Integer.parseInt(st.nextToken()); // 키를 비교한 횟수
		
		list = new ArrayList[N+1];
		
		int[] nodes = new int[N+1]; // 자기 자신을 가리키고 있는 정점의 개수를 저장할 배열
		ArrayList<Integer> resultList = new ArrayList<>(); // 정렬 결과 리스트
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b); // a에서 b로의 방향
			nodes[b]++; // a가 b를 가르키므로, b를 가리키는 값 증가
		}
		
		for (int i = 1; i <= N; i++) {
			if(nodes[i] == 0) q.add(i); // 자기 자신을 가리키는 정점이 없는 경우 큐에 삽입
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			resultList.add(cur); // 처리한 노드는 순서대로 저장
			
			for (int i = 0; i < list[cur].size(); i++) {
				int tmp = list[cur].get(i);
				
				nodes[tmp]--;
				
				if(nodes[tmp] == 0) {
					q.add(tmp);
				}
			}
		}
		
		for (int i = 0; i < resultList.size(); i++) {
			System.out.print(resultList.get(i) + " ");
		}
	}
}
