package beakjoon;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_3190_뱀 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 보드의 크기
		int[][] board = new int[n+2][n+2]; // 벽 세우기 위해서 더 크게
		
		int k = sc.nextInt(); // 사과의 개수
		int[] appleR = new int[k]; // 사과 행
		int[] appleC = new int[k]; // 사과 열
		
		for (int i = 0; i < k; i++) {
			appleR[i] = sc.nextInt();
			appleC[i] = sc.nextInt();
			
			board[appleR[i]][appleC[i]] = 4; // 사과 표시
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(i == 0 || i == board.length - 1 
						|| j == 0 || j == board.length - 1) board[i][j] = 1; // 벽 표시
			}
		}
		
		int l = sc.nextInt(); // 뱀의 방향 변환 횟수
		
		int[] ltime = new int[l + 1]; // 뱀 회전 시간
		String[] ldir = new String[l + 1]; // 뱀 회전 방향
		
		for (int i = 0; i < l; i++) {
			ltime[i] = sc.nextInt(); // x초가 끝난 뒤
			ldir[i] = sc.next(); // L이면 왼쪽으로  / D면 오른쪽으로 90도 회전
		}
		
		int idx = 0; // 뱀 회전 시간, 방향 조절 위한 index
		
		ArrayList<pairS> list = new ArrayList<pairS>(); // 뱀 이동 경로
		
		list.add(new pairS(1,1));
		
		int r = 1; // 뱀 머리 위치 행
		int c = 1; // 뱀 머리 위치 열
		
		board[r][c] = 7; // 시작 위치 표시
		
		int dir = 2; // 1 상 	2 우 	3 하 	4 좌
		
		int time = 0; // 게임 소요 시간
		
		int length = 1; // 뱀의 길이
		
		// 뱀 이동
		while(true) {
			
			int x = ltime[idx];
			String xr = " ";
			if(time == x) xr = ldir[idx++];  // 뱀 이동 시간과 현재 시간 일치하면 뱀 회전
			
			switch(dir) {
			
			case 1 : // 상
				if(time == x) {
					if (xr.equals("L")) {
						c -= 1;
						dir = 4;
					} else {
						c += 1;
						dir = 2;
					}
				} else {
					r -= 1;
				}
								
				break;
				
			case 2 : // 우
				if(time == x) {
					if (xr.equals("L")) {
						r -= 1;
						dir = 1;
					} else {
						r += 1;
						dir = 3;
					}
				} else {
					c += 1;
				}
								
				break;
				
			case 3 : // 하
				if(time == x) {
					if (xr.equals("L")) {
						c += 1;
						dir = 2;
					} else {
						c -= 1;
						dir = 4;
					}
				} else {
					r += 1;
				}
								
				break;
				
			case 4 : // 좌
				if(time == x) {
					if (xr.equals("L")) {
						r += 1;
						dir = 3;
					} else {
						r -= 1;
						dir = 1;
					}
				} else {
					c -= 1;
				}
								
				break;
			}
			
			time++;
			
			list.add(new pairS(r, c));
			
			if(board[r][c] == 7) { // 뱀 몸통을 만났을 때
				break;
			} else if(board[r][c] == 4) { // 사과를 만났을 때
				board[r][c] = 7;
				length++;
			} else if(board[r][c] == 0) { // 아무것도 안 만났을 때
				board[r][c] = 7;
			}
			
			if(list.size() > length) { // 뱀 길이만큼만 표시
				board[list.get(list.size() - length - 1).row][list.get(list.size() - length - 1).col] = 0;
			}
			
			if(r < 1 || r >= board.length - 1 || c < 1 || c >= board.length - 1) { // 뱀이 벽을 만났을 때
				break;
			} 
		}
		
		System.out.println(time);
	}
}

class pairS {
	int row;
	int col;
	
	pairS(){}
	
	pairS(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	@Override
	public String toString() {
		return row + " " + col;
	}
}
