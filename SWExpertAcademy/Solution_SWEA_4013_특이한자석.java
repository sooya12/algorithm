package SWExpertAcademy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_4013_특이한자석 {

	static int[][] magnet;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine()); // 자석 회전 횟수
			
			magnet = new int[4][8]; // 4개의 자석의 8개 자성 정보
			
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int num; // 회전할 자석 순번
			int dir; // 회전 방향 1:시계 / -1:반시계
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				num = Integer.parseInt(st.nextToken())-1;
				dir = Integer.parseInt(st.nextToken());
				
				rotation(num, dir, 0);
			}
			
			int result = 0;
			
			for (int i = 0; i < 4; i++) {
				result += magnet[i][0]*(int)Math.pow(2, i);
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
	
	// flag가 0이면 좌우로 이동 / -1이면 좌측으로만 이동 / 1이면 우측으로만 이동 
	private static void rotation(int num, int dir, int flag) {
		
		int left = magnet[num][6]; // 초기 좌측 값
		int right = magnet[num][2]; // 초기 우측 값
		
		int tmp; // 임시로 값 저장
		
		if(dir == 1) { // 시계 방향 회전
			tmp = magnet[num][7];
			for (int i = 7; i >= 1; i--) {
				magnet[num][i] = magnet[num][i-1];
			}
			
			magnet[num][0] = tmp;
			
		} else { // 반시계 방향 회전
			tmp = magnet[num][0];
			for (int i = 0; i < 7; i++) {
				magnet[num][i] = magnet[num][i+1];
			}
			
			magnet[num][7] = tmp;
		}
		
		if(num > 0 && left != magnet[num-1][2] && (flag == 0 || flag == -1)) { // 좌측 회전
			rotation(num-1, dir*(-1), -1);
		} 
		
		if(num < 3 && right != magnet[num+1][6] && (flag == 0 || flag == 1)) { // 우측 회전
			rotation(num+1, dir*(-1), 1);
		}
	}
}
