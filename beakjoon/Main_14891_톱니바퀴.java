package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {

	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		arr = new char[4][8]; // 톱니바퀴 정보. N:0 / S:1

		for (int i = 0; i < 4; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		int k = Integer.parseInt(br.readLine()); // 회전 횟수

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int num = Integer.parseInt(st.nextToken()) - 1; // 회전시킨 톱니바퀴 번호
			int dir = Integer.parseInt(st.nextToken()); // 회전 방향. 1:시계 / -1:반시계

			rotate(num, dir, 0);
		}
		
		int sum = 0; // 결과값
		
		for (int i = 0; i < 4; i++) {
			if(arr[i][0] - '0' == 1) {
				sum += (int)Math.pow(2, i);
			}
		}
		
		System.out.println(sum);
		
	}

	private static void rotate(int num, int dir, int way) {
		if(way < 1 && num > 0 && arr[num][6] != arr[num - 1][2]) { // 왼쪽 톱니바퀴 회전
			rotate(num - 1, dir * (-1), -1);
		}
		
		if(way > -1 && num < 3 && arr[num][2] != arr[num + 1][6]) { // 오른쪽 톱니바퀴 회전
			rotate(num + 1, dir * (-1), 1);
		}
		
		if(dir == 1) { // 시계 방향
			char tmp = arr[num][7];
			
			for (int i = 7; i > 0; i--) {
				arr[num][i] = arr[num][i - 1];
			}
			
			arr[num][0] = tmp;
		} else { // 반시계 방향
			char tmp = arr[num][0];
			
			for (int i = 0; i < 7; i++) {
				arr[num][i] = arr[num][i + 1];
			}
			
			arr[num][7] = tmp;
		}
	}
}
