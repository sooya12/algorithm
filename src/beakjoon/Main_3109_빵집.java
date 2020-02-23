package beakjoon;
import java.util.Scanner;
import java.util.Stack;

public class Main_3109_빵집 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt(); // 행
		int c = sc.nextInt(); // 열
		
		char[][] arr = new char[r][c];
		boolean[][] visited = new boolean[r][c];
		
		int[] dy = {1, 0, -1}; // 위 옆 아래 탐색
		
		String s = "";
				
		for (int i = 0; i < arr.length; i++) {
			s = sc.next();
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = s.charAt(j);
				
				if(arr[i][j] == 'x') visited[i][j] = true;
			}
		}
		
		int max = 0;
		int[] location = new int[2];
		
		for (int i = 0; i < arr.length; i++) {
			Stack<int[]> st = new Stack<>(); // 아래 옆 위 순으로 넣고 위 옆 아래 순으로 탐색하기 위해서
			
			location[0] = i;
			location[1] = 0;
			
			st.push(location);
			
			while(!st.isEmpty()) {
				
				location = st.pop();
				
				int rr = location[0];
				int cc = location[1];
				
				if(cc == arr[0].length - 1) {
					max++;
					break;
				}
				
				visited[rr][cc] = true;
				
				for (int j = 0; j < dy.length; j++) {
					if(rr + dy[j] < 0 || rr + dy[j] > arr.length - 1 
							|| cc + 1 > arr[0].length - 1) continue;
					
					if(!visited[rr + dy[j]][cc + 1]) {
						int[] arrrr = new int[2];
						
						arrrr[0] = rr + dy[j];
						arrrr[1] = cc + 1;
						
						st.push(arrrr);
					}
				}
			}
		}
		
		System.out.println(max);
	}
}
