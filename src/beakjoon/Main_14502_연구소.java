package beakjoon;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_14502_연구소 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] arr = new int[n][m];
		ArrayList<Integer> virusList = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
				
				if(arr[i][j] == 2) { 	// 바이러스 위치
					virusList.add(i); 	// 바이러스 위치 행
					virusList.add(j);	// 바이러스 위치 열
				}
			}
		}
		
		Perm(findZero(arr), arr, virusList);
		
		System.out.println(maxZero);
		
	}
	
	static ArrayList<Integer> findZero(int[][] arr) {
		ArrayList<Integer> list = new ArrayList<>(); // 0 위치 담을 list
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == 0) {
					list.add(i); // 0 위치 행
					list.add(j); // 0 위치 열
				}
			}
		}
		
		return list;
	}
	
	static void Perm(ArrayList<Integer> list, int[][] arr, ArrayList<Integer> virusList) {
		int[][] wallArr = new int[3][2]; // 벽 세울 위치 담을 배열
		
		for (int i = 0; i < list.size(); i+=2) {
			for (int j = i; j < list.size(); j+=2) {
				if (i == j) continue;
				for (int k = j; k < list.size(); k+=2) {
					if (i == k || j == k) continue;
					
					wallArr[0][0] = list.get(i);	// 벽 세울 0 위치 1
					wallArr[0][1] = list.get(i+1);
					wallArr[1][0] = list.get(j);	// 벽 세울 0 위치 2
					wallArr[1][1] = list.get(j+1);
					wallArr[2][0] = list.get(k);	// 벽 세울 0 위치 3
					wallArr[2][1] = list.get(k+1);
					
					int[][] copyArr = new int[arr.length][arr[0].length]; // 벽 세우고 바이러스 퍼뜨릴 연구소 배열 복사본
					
					for (int l = 0; l < copyArr.length; l++) {
						System.arraycopy(arr[l], 0, copyArr[l], 0, arr[l].length);
					}
					buildWall(wallArr, copyArr, virusList); // 벽 세우기
				}
			}
		}
	}
	
	static void buildWall(int[][] wallArr, int[][] CopyArr, ArrayList<Integer> virusList) {
		
		for (int i = 0; i < wallArr.length; i++) { // 주어진 벽 배열에 따라서 벽 세우기
			CopyArr[wallArr[i][0]][wallArr[i][1]] = 1;
		}
		
		checkVirus(CopyArr, virusList); 
		
		countZero(CopyArr);
	}
	
	static void checkVirus(int[][] arr, ArrayList<Integer> virusList) {
		for (int i = 0; i < virusList.size(); i+=2) {
			spreadVirus(arr, virusList.get(i), virusList.get(i+1)); // 바이러스 퍼뜨리기
			
		}
	}
	
	static int[] dy = {-1, 0, 1, 0}; // 행
	static int[] dx = {0, 1, 0, -1}; // 열
	
	static void spreadVirus(int[][] arr, int r, int c) { // 사방탐색하며 0이라면 바이러스 퍼뜨리기
		for (int i = 0; i < dy.length; i++) {
			if(r + dy[i] < 0 || r + dy[i] > arr.length-1 || c + dx[i] < 0 || c + dx[i] > arr[0].length-1) continue;
			else {
				if(arr[r+dy[i]][c+dx[i]] == 0) {
					arr[r+dy[i]][c+dx[i]] = 2;
					spreadVirus(arr, r+dy[i], c+dx[i]);
				}
			}
		}
	}
	
	static int maxZero = 0;
	
	static void countZero(int[][] arr) { // 0 개수 세기
		
		int cnt = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == 0) cnt++;
			}
		}
		
		if(maxZero < cnt) maxZero = cnt;
	}

}
