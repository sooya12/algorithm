package SWExpertAcademy;
import java.util.Scanner;

public class Solution_SWEA_2115_벌꿀채취 {
	
	static int n; // 벌통 크기
	static int m; // 선택할 수 있는 벌통 개수
	static int c; // 채취할 수 있는 용량
	
	static int[][] tong; // 벌통 배열
	
	static int[][] p1; // 일꾼 1
	static int[][] p2; // 일꾼 2
	
	
	static int max; // 총 수익
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt(); // 테스트 케이스 개수
		
		for (int testCase = 1; testCase <= t; testCase++) {
			n = sc.nextInt();
			m = sc.nextInt();
			c = sc.nextInt();
			
			tong = new int[n][n];
			
			p1 = new int[m][2];
			p2 = new int[m][2];
			
			// tong에 input
			for (int i = 0; i < tong.length; i++) {
				for (int j = 0; j < tong.length; j++) {
					tong[i][j] = sc.nextInt();
				}
			}
			
			max = Integer.MIN_VALUE;
			
			for (int i = 0; i < tong.length; i++) {
				for (int j = 0; j < tong.length; j++) {
					if(j + m <= tong.length) {
						int idx = 0;
						for (int k = j; k < j + m; k++, idx++) {
							p1[idx][0] = i;
							p1[idx][1] = k;
						}
						
						get(i, j, cal(p1));
					}
				}
			}
			
			System.out.println("#" + testCase + " " + max);
		} // end of for testCase
	} // end of main

	public static void get(int r, int c, int sum) {
		// 같은 행에서 탐색
		for (int i = c + m; i < tong.length; i++) {
			if(i + m <= tong.length) {
				int idx = 0;
				for (int j = i; j < i + m; j++, idx++) {
					p2[idx][0] = r;
					p2[idx][1] = j;
				}
				
				max = Math.max(max, sum + cal(p2));
				
			}
		}
		// 다른 행에서 탐색
		for (int i = r + 1; i < tong.length; i++) {
			for (int j = 0; j < tong.length; j++) {
				if(j + m <= tong.length) {
					int idx = 0;
					
					for (int k = j; k < j + m; k++, idx++) {
						p2[idx][0] = i;
						p2[idx][1] = k;
					}
					
					max = Math.max(max, sum + cal(p2));
					
				}
			}
		}
	} // end of get
	
	// 조합을 이용하여 용량을 넘지않은 최대값 구하기
	static int cal(int[][] p) {
		int max = 0;
		
		for (int i = 0; i < (1 << p.length); i++) {
			int sum = 0;
			int cnt = 0;
			
			for (int j = 0; j < p.length; j++) {
				if((i & 1 << j) > 0) {
					cnt += tong[p[j][0]][p[j][1]];
					if(cnt <= c) {
						sum += tong[p[j][0]][p[j][1]] * tong[p[j][0]][p[j][1]];
						max = Math.max(max, sum);
					}
				}
			}
		}
		
		return max;
	}
	
}
