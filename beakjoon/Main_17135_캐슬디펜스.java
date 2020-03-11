package beakjoon;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main_17135_캐슬디펜스 {

	static int max = Integer.MIN_VALUE; // 최대 적 제거수
	static int[][] arr;
	static int n, m, d; // 행, 열, 궁수 공격 거리
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt(); // 행
		m = sc.nextInt(); // 열
		d = sc.nextInt(); // 궁수 공격 거리

		arr = new int[n + 1][m]; // 궁수 자리까지 n+1

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		Stack<Integer> st = new Stack<>();
		pick(m, st, 3);

		System.out.println(max);

	}

	public static void pick(int n, Stack<Integer> st, int r) {
		if (r == 0)
			arrange(st);

		int min = st.isEmpty() ? 0 : st.lastElement() + 1;

		for (int next = min; next < n; next++) {
			st.push(next);
			pick(n, st, r - 1);
			st.pop();
		}
	}

	public static void arrange(Stack<Integer> st) {
		int[][] copyArr = new int[n + 1][m];

		for (int i = 0; i < arr.length; i++) {
			System.arraycopy(arr[i], 0, copyArr[i], 0, arr[i].length);
		}
		
		for (int i : st) {
			copyArr[n][i] = 2;
		}
		
		int cnt = 0; // 죽인 적의 수
		int min = 0; // 최소 거리
		int result = 0; // 적과의 거리
		int[][] target = new int[3][2]; // 궁수가 죽일 적의 위치
		
		while(check(copyArr) == 0) {
			
			for (int i = 0; i < target.length; i++) {
				for (int j = 0; j < target[i].length; j++) {
					target[i][j] = -1;
				}
			}
			
			for (int i = 0; i < st.size(); i++) {
				min = Integer.MAX_VALUE;
				
				for (int j = copyArr.length - 2; j > 0; j--) {
					for (int k = 0; k < copyArr[j].length; k++) {
						if(copyArr[j][k] == 1) {
							
							result = (int)(Math.abs(n - j) + Math.abs(st.get(i) - k));
							
							if(result <= d) {
								if (result < min) {
									target[i][0] = j;
									target[i][1] = k;
									
									min = result;
									
								} else if (result == min && target[i][1] > k) {
									target[i][0] = j;
									target[i][1] = k;
								} 
							}
						}
					}
				}
			}
			
			for (int i = 0; i < target.length; i++) {
				if(target[i][0] == -1 || target[i][1] == -1) continue;
				
				if(copyArr[target[i][0]][target[i][1]] == 1) {
					cnt++;
					copyArr[target[i][0]][target[i][1]] = 0;
				}
			}

            for (int i = copyArr.length - 2; i > 0; i--) {
				for (int j = 0; j < copyArr[i].length; j++) {
					copyArr[i][j] = copyArr[i - 1][j];
					copyArr[i - 1][j] = 0;
				}
			}
			
			max = Math.max(max, cnt);
		}
	}

	public static int check(int[][] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != 0)
					return 0;
			}
		}

		return 1;
	}
}
